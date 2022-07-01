package Netology.СreationalPatterns.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int n = scanner.nextInt();
        System.out.print("Введите верхнюю границу для значений: ");
        int m = scanner.nextInt();

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>(n);
        System.out.print("Вот случайный список: ");
        for (int i = 0; i < n; i++) {
            int rand = random.nextInt(m);
            list.add(rand);
            System.out.print(rand + (i < n - 1 ? " " : "\n"));
        }

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        Filter filter = new Filter(scanner.nextInt());
        List<Integer> filteredList = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        int count = 0;
        for (Integer item : filteredList) {
            System.out.print(item + (count < filteredList.size() - 1 ? " " : "\n"));
            count++;
        }
        logger.log("Завершаем программу");
    }
}
