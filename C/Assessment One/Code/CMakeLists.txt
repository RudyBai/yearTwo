cmake_minimum_required(VERSION 3.13)
project(A01 C)

set(CMAKE_C_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -static-libstdc++ -static-libgcc")

add_executable(A01 main.c word_game.h word_game.c)