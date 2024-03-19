import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String userData = "";

        System.out.println("Введите данные в формате: Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");

        try {
            // Чтение строки данных с клавиатуры
            userData = scanner.nextLine();

            // Разделение введенных данных по пробелу
            String[] userDataArray = userData.split(" ");

            // Проверка количества введенных данных
            if (userDataArray.length < 6) {
                throw new InsufficientDataException("Введено недостаточное количество данных.");
            } else if (userDataArray.length > 6) {
                throw new ExcessiveDataException("Введено слишком много данных.");
            }

            // Проверка корректности формата данных
            if (!isValidPhoneNumber(userDataArray[4])) {
                throw new NumberFormatException("Некорректный формат номера телефона.");
            }
            if (!isValidGender(userDataArray[5])) {
                throw new IllegalArgumentException("Некорректный формат пола.");
            }
            if (!isValidDate(userDataArray[3])) {
                throw new IllegalArgumentException("Некорректный формат даты рождения. Ведите в формате dd.mm.yyyy");
            }

            // Создание объекта Person
            Person person = new Person(userDataArray[0], userDataArray[1], userDataArray[2],
                    userDataArray[3], Long.parseLong(userDataArray[4]), userDataArray[5].charAt(0));

            // Обработка данных
            DataProcessor dataProcessor = new DataProcessor();
            dataProcessor.processData(person);

        } catch (InsufficientDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
            printMissingData(userData);
        } catch (ExcessiveDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Некорректный формат номера телефона.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: Некорректный формат данных.");
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Проверка корректности номера телефона
    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d+");
    }

    // Проверка корректности пола
    private static boolean isValidGender(String gender) {
        return gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f");
    }

    // Проверка корректности формата даты рождения
    // private static boolean isValidDate(String date) {
    //     return date.matches("\\d{2}.\\d{2}.\\d{4}");
    // }
    private static boolean isValidDate(String date) {
        return date.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    // Выводит данные, которые не были введены
    private static void printMissingData(String userData) {
        String[] dataNames = {"Фамилия", "Имя", "Отчество", "Дата_рождения", "Номер_телефона", "Пол"};
        String[] userDataArray = userData.split(" ");
        for (int i = 0; i < dataNames.length; i++) {
            if (userDataArray.length <= i || userDataArray[i].isEmpty()) {
                System.out.println(dataNames[i]);
            }
        }
    }
}
