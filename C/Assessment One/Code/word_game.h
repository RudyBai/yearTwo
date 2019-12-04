
#ifndef A01_WORD_GAME_H
#define A01_WORD_GAME_H

//--------------------------------------------------
// INCLUDE LIBRARIES
//--------------------------------------------------
#include <stdio.h>

//--------------------------------------------------
// DATA TYPES DEFINITIONS
//--------------------------------------------------
enum Bool { False, True };
typedef enum Bool boolean;

//--------------------------------------------------
// CONSTANTS
//--------------------------------------------------
#define NUM_LETTERS 4

//--------------------------------------------------
//
// FUNCTIONS
//
//--------------------------------------------------

//--------------------------------------------------
// my_getchar
//--------------------------------------------------
int my_get_char();

//--------------------------------------------------
// ask_for_new_command
//--------------------------------------------------
char ask_for_new_command();

//--------------------------------------------------
// process_movement
//--------------------------------------------------
void process_movement(char current_word[NUM_LETTERS], char** letter_ptr_ptr, int* num_mov_ptr, char command, char all_words[1025], int* all_words_counter);

//--------------------------------------------------
// print_status
//--------------------------------------------------
void print_status(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], char* letter_ptr, int num_mov, int max_mov, char pointer_string[5]);

//--------------------------------------------------
// is_game_over
//--------------------------------------------------
int is_game_over(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], int num_movs, int max_movs);

//--------------------------------------------------
// user_game_palindrome
//--------------------------------------------------
void user_game_word(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], char pointer_string[5], char all_words[1025]);


#endif //A01_WORD_GAME_H
