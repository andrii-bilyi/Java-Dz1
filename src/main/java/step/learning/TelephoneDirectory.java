package step.learning;
import java.util.*;

public class TelephoneDirectory {
    Map<String, String> map = new HashMap<>();

    public void start(){
        initializeDirectory();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1 - вивести все");
            System.out.println("2 - пошук за телефоном");
            System.out.println("3 - пошук за ім'ям");
            System.out.println("4 - додати запис");
            System.out.println("0 - вихід");
            System.out.print("Виберіть дію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    searchByPhone();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    addRecord(scanner);
                    break;
                case 0:
                    System.out.println("Дякую за використання телефонного довідника!");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice != 0);

        scanner.close();
    }


    private void initializeDirectory() {
        map.put("Степан", "111");
        map.put("Марія", "222");
        map.put("Петро", "333");
    }

    private void displayAll() {

        System.out.println("Всі записи у телефонному довіднику:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private void searchByPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер телефону: ");
        String phone = scanner.next();
        boolean found = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(phone)) {
                System.out.println("Ім'я: " + entry.getKey());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Запис з таким номером телефону не знайдено.");
        }
    }

    private void searchByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я: ");
        String name = scanner.nextLine();
        if (map.containsKey(name)) {
            System.out.println("Номер телефону: " + map.get(name));
        } else {
            System.out.println("Запис з таким ім'ям не знайдено.");
        }
    }

    private void addRecord(Scanner scanner) {
        System.out.print("Введіть ім'я: ");
        String name = scanner.next();
        System.out.print("Введіть номер телефону: ");
        String phone = scanner.next();
        map.put(name, phone);
        System.out.println("Запис додано до телефонного довідника.");
    }
}
