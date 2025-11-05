package app;

import app.Exception.NotCorrectEmailFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String email = askEmail();
            System.out.println("Email принят: " + email);
        } catch (NotCorrectEmailFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String askEmail() throws NotCorrectEmailFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите email: ");
        String email = scanner.nextLine();
        scanner.close();

        List<String> errors = new ArrayList<>();

        if (email.length() < 5)
            //throw new NotCorrectEmailFormatException("Email должен содержать не менее 5 символов");
            errors.add("строка короче 5 символов");

        if (!email.contains("@"))
            //throw new NotCorrectEmailFormatException("Email должен содержать символ '@'");
            errors.add("отсутствует символ '@'");

        /*if (email.startsWith("@") || email.endsWith("@"))
            throw new NotCorrectEmailFormatException("Символ '@' не должен быть первым или последним");
         */
        if (email.startsWith("@"))
            errors.add("'@' не должна быть первой");
        if (email.endsWith("@"))
            errors.add("'@' не должна быть последней");

        if (!errors.isEmpty()) {
            throw new NotCorrectEmailFormatException(String.join(", ", errors));

        }
        return email;
    }

}