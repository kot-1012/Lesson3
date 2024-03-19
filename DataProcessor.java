import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class DataProcessor {
    public void processData(Person person) {
        try {
            // Определение имени файла
            String filename = person.getLastName() + ".txt";
            
            // Создание объекта FileOutputStream для записи в файл
            FileOutputStream fileOutputStream = new FileOutputStream(filename, true);
            
            // Создание объекта OutputStreamWriter с указанием кодировки UTF-8
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            
            // Создание объекта BufferedWriter для эффективной записи данных
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            // Формирование строки с данными о персоне
            String line = person.getLastName() + " " + person.getFirstName() + " " + person.getMiddleName() + " " +
                    person.getBirthDate() + " " + person.getPhoneNumber() + " " + person.getGender();
            
            // Запись строки в файл
            bufferedWriter.write(line);
            bufferedWriter.newLine();

            // Закрытие BufferedWriter
            bufferedWriter.close();
            
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            // В случае возникновения ошибки ввода-вывода
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

