package Netology.СreationalPatterns.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    // В этом поле храним ссылку на тот
    // единственный объект этого класса
    // который будем отдавать пользователям
    private static Logger logger;
    protected int num = 1;

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {
    }

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле, которое
    // мы заполняем в этом методе если оно
    // до того не было заполнено
    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("[" +
                localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.YYYY")) + " " +
                localDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " " +
                num++ +
                "] " + msg);
    }

}
