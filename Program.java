import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите имя фамилию отчество через пробед: :");
        String userData = scanner.nextLine();

        String[] dataParts = userData.split(" ");

        if (dataParts.length != 3) {
            System.out.println("Ошибка, Введены не коректные значения.");
            return;
        }

        String surname = dataParts[0];
        String firstName = dataParts[1];
        String patronymic = dataParts[2];

        System.out.println("ВВедите телефоный номер:");
        String phoneNumberString = scanner.nextLine();

        int phoneNumber;
        try {
            phoneNumber = Integer.parseInt(phoneNumberString);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка.Ведите коректный номер");
            return;
        }

        try {
            FileWriter fileWriter = new FileWriter(surname + ".txt");
            fileWriter.write(surname + " " + firstName + " " + patronymic + " " + phoneNumber);
            fileWriter.close();
            System.out.println("Данные записаны");
        } catch (IOException e) {
            System.out.println("Не удалось записать файл");
        }
    }
}
