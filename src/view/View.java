package view;

import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public String printMenuAndGetCommand(){
        System.out.println("Выберите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Факториал");
        System.out.println("5. Запустить вычисления");
        return scanner.nextLine();
    }

    public String readNumbers(){
        System.out.println("Введите числа для вычислений через пробел:");
        return scanner.nextLine();
    }

    public void wrongCommand(){
        System.out.println("Несуществующая команда.\n");
    }

    public void printCommandStatus(boolean success){
        System.out.println(success? "Операция успешно добавлена.\n": "Некорректный ввод.\n");
    }
}
