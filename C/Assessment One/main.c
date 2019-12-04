
//--------------------------------------------------
// INCLUDE LIBRARIES
//--------------------------------------------------
#include "word_game.h"

//-------------------------------------
//	APPLICATION MAIN ENTRY POINT: main
//-------------------------------------
int main() {
    //1. We select the current and target words we want to play with
    char current_word[NUM_LETTERS + 1] = {'b', 'e', 'l', 'l', '\0'};
    char target_word[NUM_LETTERS + 1] = {'c', 'o', 'a', 't', '\0'};
    char pointer_string[5] = {' ', ' ', ' ', ' ', '\0'};
    char all_words[1025] = {};

    //2. We perform the interactive session
    user_game_word(current_word, target_word, pointer_string, all_words);

    //4. We finish the program
    return 0;
}
