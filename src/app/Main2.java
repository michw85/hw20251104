package app;

import app.Exception.NotCorrectEmailFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //2 Variant 2 Task

        String email = null;
        while ((email == null)) {
            try {
                email = inputEmail();
                System.out.println("Email:" + email);
            } catch (NotCorrectEmailFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        try {
            checkEmail(email);
        } catch (NotCorrectEmailFormatException e){
            System.out.println("При вводе email возникли следующие ошибки:");
            e.getList().forEach(System.out::println);
            throw e;
        }

        scanner.close();

        return email;
    }

    public static void checkEmail(String email) {

        List<String> errors = new ArrayList<>();
        int atIndex = email.indexOf('@');
        int atLastIndex = email.lastIndexOf('@');
        if (email.length() < 5) {
            errors.add("строка короче 5 символов");
        }
        if (atIndex <= 0) {
            errors.add("отсутствует символ '@'");
        }
        if (atIndex == 0 ) {
            errors.add("не может начинаться с '@'");
        }
        if (atLastIndex == email.length() - 1 ) {
            errors.add("не может заканчиваться на '@'");
        }
        if (atLastIndex != atIndex ) {
            errors.add("должен быть один символ '@'");
        }

        if (!errors.isEmpty()){
            throw new NotCorrectEmailFormatException(errors);
        }

    }
}