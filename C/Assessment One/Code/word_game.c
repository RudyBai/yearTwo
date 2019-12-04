
//--------------------------------------------------
// INCLUDE LIBRARIES
//--------------------------------------------------
#include "word_game.h"

//--------------------------------------------------
// my_getchar
//--------------------------------------------------
int my_get_char() {
    //1. We create the output variable with the value the user has input by keyboard
    int res = getchar();

    //2. We discard any extra character the user has input by keyboard
    boolean finish = False;
    int dummy_char;

    while (finish == False) {
        dummy_char = getchar();
        if (dummy_char == '\n')
            finish = True;
    }

    //3. We return the output variable
    return res;
}

//--------------------------------------------------
// ask_for_new_command
//--------------------------------------------------
char ask_for_new_command() {
    //1. We create the output variable with an initial value
    char res = ' ';

    //2. While we have not received a valid command
    while ((res == '<' || res == '>' || (res > 96 && res < 123)) == False) {
        //2.1 We ask the user for a new command
        printf("Enter new command :    'a-z'    '>'    '<'\n");
        //2.2. We read the command entered by the user
        res = (char) my_get_char();
        printf("\n");
    }
    //3. We return the output variable
    return res;
}

//--------------------------------------------------
// process_movement
//--------------------------------------------------
void process_movement(char current_word[NUM_LETTERS], char **letter_ptr_ptr, int *num_mov_ptr, char command,
                      char all_words[1025], int *all_words_counter) {
    if (command == '<') {
        // 5.2.1 Check for border
        if (*letter_ptr_ptr == &current_word[0]) {
            for (int i = 0; i < 10; i++) {
                printf("\n\n\n");
            }
            printf("You are already at the border\n\n");
        } else {
            for (int i = 0; i < 10; i++) {
                printf("\n\n\n");
            }
            *letter_ptr_ptr = *letter_ptr_ptr - 1;
            printf("Moving to the previous letter\n\n");
            *num_mov_ptr = *num_mov_ptr + 1;
        }
    } else if (command == '>') {
        // 5.2.2 Check for border
        if (*letter_ptr_ptr == &current_word[NUM_LETTERS - 1]) {
            for (int i = 0; i < 10; i++) {
                printf("\n\n\n");
            }
            printf("You are at the border\n\n");
        } else {
            for (int i = 0; i < 10; i++) {
                printf("\n\n\n");
            }
            *letter_ptr_ptr = *letter_ptr_ptr + 1;
            printf("Moving to next letter\n\n");
            *num_mov_ptr = *num_mov_ptr + 1;
        }
    } else if (command > 96 && command < 123) {
        for (int i = 0; i < 10; i++) {
            printf("\n\n\n");
        }
        **letter_ptr_ptr = command;
        *num_mov_ptr = *num_mov_ptr + 1;
        all_words[*all_words_counter] = current_word[*all_words_counter % NUM_LETTERS];
        all_words[*all_words_counter + 1] = current_word[(*all_words_counter + 1) % NUM_LETTERS];
        all_words[*all_words_counter + 2] = current_word[(*all_words_counter + 2) % NUM_LETTERS];
        all_words[*all_words_counter + 3] = current_word[(*all_words_counter + 3) % NUM_LETTERS];
        *all_words_counter += 4;
    }
}

//--------------------------------------------------
// print_status
//--------------------------------------------------
void
print_status(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], char *letter_ptr, int num_mov, int max_mov,
             char pointer_string[5]) {
    //1. We clean the screen

    //2. We print the status
    // TO-DO
    //3. We print the target word
    printf("Target     = %10s\n", target_word);
    //4. We print the current word
    printf("Current    = %10s\n", current_word);
    //5. We print the underscore associated to the pointer
    unsigned long i = (letter_ptr - &current_word[0]);
    pointer_string[i] = '^';
    printf("Pointer at = %10s\n", pointer_string);
    pointer_string[i] = ' ';
    //6. We print the number_of_movements
    printf("Moves left = %10d\n\n", (max_mov - num_mov));
    int matching = 0;
    for (int j = 0; j < 4; ++j) {
        if (current_word[j] == target_word[j]) {
            matching++;
        }
    }
    printf("Matching chars = %10d\n\n", matching);
    //7. We print a last line
    // TO-DO
}

//--------------------------------------------------
// is_game_over
//--------------------------------------------------
int is_game_over(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], int num_mov, int max_mov) {
    //1. We create traverse variable.
    int i = 0;
    //2. If we have used all of our moves then the game is over
    if (num_mov == max_mov) {
        return 1;
    }
    //3. Traverse current_word
    while (current_word[i] != '\0') {
        if (current_word[i] != target_word[i]) {
            return 0;
        } else {
            i++;
        }
    }
    //4. If all match return 1
    return 1;
}


//--------------------------------------------------
// user_game_word
//--------------------------------------------------
void user_game_word(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], char pointer_string[5],
                    char all_words[1025]) {
    //1. We initialise the pointer to the first position of the array
    char *letter_pointer = &current_word[0];
    //2. We initialise the num_mov and max_mov
    int num_mov = 0;
    int max_mov = NUM_LETTERS * 2;
    int all_words_counter = 0;
    int *all_words_counter_pointer = &all_words_counter;
    //3. We initialise the game to not to be over
    //int game_over = is_game_over(&current_word[0], &target_word[0], num_mov, max_mov);
    //4. We print the initial status of the game
    print_status(current_word, target_word, letter_pointer, num_mov, max_mov, pointer_string);
    //5. We perform the main loop
    while (is_game_over(&current_word[0], &target_word[0], num_mov, max_mov) == 0) {
        //5.1. We ask for a new command
        char command = ask_for_new_command();
        //5.2. We process the command
        process_movement(current_word, &letter_pointer, &num_mov, command, all_words, all_words_counter_pointer);
        //5.3. We print the current status
        print_status(current_word, target_word, letter_pointer, num_mov, max_mov, pointer_string);
        //5.4. We determine if the game is over
    }

    //6. Once the game is finished, we display the outcome of it
    boolean gameOver = False;
    for (int i = 0; i < NUM_LETTERS; i++) {
        if (target_word[i] != current_word[i]) {
            gameOver = True;
        }
    }

    if (gameOver == False) {
        printf("Congratulations!");
    } else if (max_mov == num_mov) {
        printf("Oh no! It looks like you ran out of moves!");
    }

    printf("\n%s", "Here are all the combinations you went through:");
    for (int i = 0; i < all_words_counter; i++) {
        if (i % 4 == 0) {
            printf("\n");
        }
        printf("%c", all_words[i]);
    }
}
