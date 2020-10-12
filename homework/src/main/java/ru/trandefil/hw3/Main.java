package ru.trandefil.hw3;

public class Main {
    public static void main(String[] args) {
        String test_email =
                new EmailBuilder()
                        .addSubject("Test email")
                        .addEmailFrom("trandefil.yurii@yandex.ru")
                        .addEmailTo("1@test.com")
                        .addEmailTo("2@test.com", "3@test.com")
                        .addEmailTo("4@test.com")
                        .addEmailCopyTo("6@copy.com")
                        .addEmailCopyTo("7@copy.com", "89@copy.com")
                        .addEmailCopyTo("10@copy.com")
                        .addContent("Meeting at monday 9 pm", "Trandefil Yury, java developer")
                        .build();

        System.out.println(test_email);


    }
}
