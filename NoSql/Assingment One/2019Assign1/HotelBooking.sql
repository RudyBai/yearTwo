create database if not exists hotelBooking;

use hotelBooking;

create table if not exists hotel(hotelNo char(10) NOT NULL, hotelName varchar(30), city varchar(10))engine=innodb;

create table if not exists room(roomNo char(10) NOT NULL, hotelNo char(10) NOT NULL, type enum('Single', 'Double', 'Family') NOT NULL, price double(8,2))engine=innodb;

create table if not exists booking(bookingNo char(10) not null, dateFrom date NOT NULL, dateTo date, guestNo varchar(10) NOT NULL DEFAULT '', roomNo char(10) NOT NULL, hotelNo char(10) NOT NULL)engine=innodb;

create table if not exists guest(guestNo varchar(10) NOT NULL DEFAULT '', guestName varchar(20) DEFAULT '', guestAddress varchar(30) DEFAULT '')engine=innodb;

SET GLOBAL local_infile = 'ON';

LOAD DATA LOCAL INFILE 'C:/Users/walus/OneDrive - mycit.ie/NoSql/2019Assign1/2019Assign1/hotel.txt' INTO TABLE hotel;
 
load data local infile '/home/local/CIT/jinghua.ye/nosql/project/assignment1/guest.txt' into table guest fields terminated by ',' ignore 1 lines;

load data local infile '/home/local/CIT/jinghua.ye/nosql/project/assignment1/room.txt' into table room fields terminated by ',' ignore 1 lines;

alter table hotel add constraint pk_hotel primary key(hotelNo);

alter table room add constraint pk_room primary key(roomNo, hotelNo);

alter table guest add constraint pk_guest primary key(guestNo);

alter table booking add constraint pk_booking primary key(bookingNo);

alter table room add constraint fk_room foreign key (hotelNo) references hotel(hotelNo) on update restrict on delete cascade;

alter table booking add constraint fk_booking foreign key (roomNo, hotelNo) references room(roomNo, hotelNo) on update restrict on delete restrict;

alter table booking add constraint fk_booking2 foreign key (guestNo) references guest(guestNo) on update restrict on delete restrict;

load data local infile '/home/local/CIT/jinghua.ye/nosql/project/assignment1/booking.txt' into table booking fields terminated by ',' ignore 1 lines;

desc Hotel;
desc Room;
desc Booking;
desc Guest;
