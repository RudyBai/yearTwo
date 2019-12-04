package Controllers;

import Components.Module;
import Components.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.ArrayList;

class MySQLController {

    private static final String DATABASE_URL = "jdbc:mysql://localhost/school?serverTimezone=UTC";

    private Connection connection;

    MySQLController() {
        {
            try {
                this.connection = DriverManager.getConnection(DATABASE_URL, "root", "szklarz231");
                System.out.println("\n\n========== CONNECTION ESTABLISHED ===========\n\n");
            } catch (SQLException e) {
                System.out.println("\n\n========== CONNECTION ERROR ===========\n\n");
                e.printStackTrace();
            }
        }
    }

    void addStudent(Student student) {

        try {

            Object object = student.getModules();

            String sql = String.format("INSERT INTO %s(fname, mname, lname, email, pnumber, modules) VALUES (?, ?, ?, ?, ?, ?)", student.getClassGroup().getClassGroupName());
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, student.getName().getFirstName());
            preparedStatement.setObject(2, student.getName().getMiddleName());
            preparedStatement.setObject(3, student.getName().getLastName());
            preparedStatement.setObject(4, student.getEmail());
            preparedStatement.setObject(5, student.getPhoneNumber());
            preparedStatement.setObject(6, object);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void removeStudent(Student student) {

        String sql = String.format("DELETE FROM %s WHERE pnumber = \"%s\"", student.getClassGroup().getClassGroupName(), student.getPhoneNumber());

        Statement statement;

        try {
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void addTeacher(Teacher teacher) {

        String sql = String.format("INSERT INTO TEACHERS (fname, mname, lname, email, pnumber, degree) VALUES (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")", teacher.getName().getFirstName(), teacher.getName().getMiddleName(), teacher.getName().getLastName(), teacher.getEmail(), teacher.getPhoneNumber(), teacher.getDegree());

        Statement statement;

        try {
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void removeTeacher(Teacher teacher) {
        String sql = String.format("DELETE FROM TEACHERS WHERE pnumber = \"%s\"", teacher.getPhoneNumber());

        Statement statement;

        try {
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void addClassGroup(ClassGroup classGroup) {

        String sql = String.format("CREATE TABLE IF NOT EXISTS %s(\n\tfname\tVARCHAR(255),\n\tmname\tVARCHAR(255),\n\tlname\tVARCHAR(255),\n\temail\tVARCHAR(255),\n\tpnumber\tVARCHAR(255),\n    modules VARCHAR(511),\n\tPRIMARY KEY(pnumber)\n);", classGroup.getClassGroupName());

        Statement statement;

        try {
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void removeClassGroup(ClassGroup classGroup) {

        String sql = String.format("DROP TABLE %s", classGroup.getClassGroupName());

        Statement statement;

        try {
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ObservableList<ClassGroup> loadClassGroups() {

        ObservableList<ClassGroup> classGroupObservableList = FXCollections.observableList(new ArrayList<>());

        Statement statement;
        ResultSet tableSet;
        ResultSet studentSet;

        try {
            statement = connection.createStatement();
            tableSet = statement.executeQuery("SHOW TABLES WHERE Tables_in_school != \"teachers\"");

            ArrayList<String> classGroupNames = new ArrayList<>();

            while (tableSet.next()) {
                classGroupNames.add(tableSet.getString(1));
            }

            for (String s : classGroupNames) {

                ClassGroup classGroup = new ClassGroup(s);

                String sql = String.format("SELECT * FROM %s", s);
                studentSet = statement.executeQuery(sql);

                while (studentSet.next()) {

                    byte[] bytes = studentSet.getBytes(6);
                    ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));

                    try {
                        @SuppressWarnings("unchecked") ArrayList<Module> moduleArrayList = (ArrayList<Module>) objectInputStream.readObject();
                        classGroup.addStudent(new Student(new Name(studentSet.getString(1), studentSet.getString(2), studentSet.getString(3)), studentSet.getString(4), studentSet.getString(5), moduleArrayList, classGroup));
                    } catch (EOFException e) {
                        classGroup.addStudent(new Student(new Name(studentSet.getString(1), studentSet.getString(2), studentSet.getString(3)), studentSet.getString(4), studentSet.getString(5), new ArrayList<>(), classGroup));
                    }
                }
                classGroupObservableList.add(classGroup);
            }

        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return classGroupObservableList;
    }

    ObservableList<Teacher> loadTeachers() {

        ObservableList<Teacher> teacherObservableList = FXCollections.observableList(new ArrayList<>());

        Statement statement;
        ResultSet teacherSet;

        try {
            statement = connection.createStatement();

            String sql = "SELECT * FROM teachers";
            teacherSet = statement.executeQuery(sql);

            while (teacherSet.next()) {
                teacherObservableList.add(new Teacher(new Name(teacherSet.getString(1), teacherSet.getString(2), teacherSet.getString(3)), teacherSet.getString(4), teacherSet.getString(5), teacherSet.getString(6)));
            }

            teacherSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return teacherObservableList;
    }

    void close() {
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}