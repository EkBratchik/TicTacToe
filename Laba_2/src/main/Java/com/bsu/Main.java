package com.bsu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] gamefield = new char[9];
        int n = 0;

        printGameField();

        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("\nХодит первый игрок:");
            } else
                System.out.println("\nХодит второй игрок:");

            do {
                if (sc.hasNextInt()) {

                    n = sc.nextInt();
                    if (n > 0 && n < 10 && i % 2 == 0 && isEmpty(n, gamefield)) {
                        firstPlayerMove(n, gamefield);
                        break;

                    } else if (n > 0 && n < 10 && i % 2 != 0 && isEmpty(n, gamefield)) {
                        secondPlayerMove(n, gamefield);
                        break;
                    } else {
                        System.out.println("Be attenion! Try again, player " + (i % 2 + 1)
                                + ". Неверный номер поля или поле не свободно");
                        continue;
                    }

                }
                System.out.println("Вы ввели не число. Try again, player " + (i % 2 + 1)+"!:");
                sc.next();


            } while (((n < 0) || (n >= 10) ||(sc.hasNextInt())|| !isEmpty(n, gamefield)));

            printField(gamefield);
            if (checkWin(gamefield)) {
                System.out.println("\nИгрок " + (i % 2 + 1) + " Победа!!! Поздравляю!!!");
                break;
            }
            if (i == 8) {
                System.out.println("\nНичья!");
            }

        }

        sc.close();
    }

    //вывод схемы игрового поля
    static void printGameField() {
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("-----------");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("-----------");
        System.out.println(" 7 | 8 | 9 ");
    }

    static void firstPlayerMove(int move, char[] arr) {
        if (move > 0 && move < 10) {
            arr[move - 1] = 'X';
        }
    }

    static void secondPlayerMove(int move, char[] arr) {
        if (move > 0 && move < 10) {
            arr[move - 1] = 'O';
        }
    }

    static boolean isEmpty(int m, char[] arr) {
        return arr[m - 1] == '\u0000';
    }

    static void printField(char[] arr) {
        System.out.println(" " + arr[0] + " | " + arr[1] + " | " + arr[2]);
        System.out.println("-----------");
        System.out.println(" " + arr[3] + " | " + arr[4] + " | " + arr[5]);
        System.out.println("-----------");
        System.out.println(" " + arr[6] + " | " + arr[7] + " | " + arr[8]);
    }
    static boolean checkWin(char[] arr) {
        boolean var1;
        var1 = (arr[0] == arr[1] && arr[1] == arr[2] && arr[0] != '\u0000')
                || (arr[3] == arr[4] && arr[4] == arr[5] && arr[3] != '\u0000')
                || (arr[6] == arr[7] && arr[7] == arr[8] && arr[6] != '\u0000')
                || (arr[0] == arr[3] && arr[3] == arr[6] && arr[0] != '\u0000')
                || (arr[1] == arr[4] && arr[4] == arr[7] && arr[1] != '\u0000')
                || (arr[2] == arr[5] && arr[5] == arr[8] && arr[2] != '\u0000')
                || (arr[0] == arr[4] && arr[4] == arr[8] && arr[0] != '\u0000')
                || (arr[2] == arr[4] && arr[4] == arr[6] && arr[2] != '\u0000');
        return var1;
    }
}

