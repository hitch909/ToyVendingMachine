package org.example;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;
import java.util.Scanner;

@ToString
@NoArgsConstructor
public class Controller extends VendingMachine {
    VendingMachine vendingMachin = new VendingMachine();

    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033[35m здравствуйте, это безпроигрышная лотерея");
        System.out.println("\033[31m     МЕНЮ    \033[0m");

        System.out.println("\033[34m добавление игрушек на склад\033[0m ");

        int n = 0;
        boolean isQuit = false;
        while (!isQuit) {
            vendingMachin.addListToys(toys, toysArrayList);
            System.out.println("выход из режима добавления игрушек:\033[34m 0 \033[0m");
            if (scanner.nextInt() == 0) {
                isQuit = true;
                vendingMachin.showListToys(toysArrayList);
            }
        }
        boolean Quit = false;
        while (!Quit) {
            System.out.println("вывод списка розыгрыша:\033[34m 1\033[0m");
            System.out.println("начать розыгрыш:\033[34m  2\033[0m");
            System.out.println("повторить розыгрыш:\033[34m 3\033[0m");
            n = scanner.nextInt();
            if (n == 1) {
                vendingMachin.createLotteryList(toysArrayList);
                vendingMachin.showLotteryList();
            }
            if (n == 2) {
                vendingMachin.createLotteryList(toysArrayList);
                vendingMachin.raffleLotteryList();
            }
            System.out.println("\033[31m для выхода наберите: 90,  для продолжения любую цифру.\033[0m ");
            if (scanner.nextInt() == 90) {
                Quit = true;
            }
        }
    }
}
