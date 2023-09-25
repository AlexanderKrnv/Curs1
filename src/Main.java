import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> member = new LinkedList<>();
        int choice;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1) Добавить посетителя");
            System.out.println("2) Удалить посетителя");
            System.out.println("3) Вывести информацию о посетителе");
            System.out.println("-1) Завершить программу");

            choice = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после ввода числа

            switch (choice) {
                case 1 -> {
                    // Добавление посетителя
                    mem = mm.addMembers(member);
                    fh.appendFile(mem);
                }
                case 2 -> {
                    // Удаление посетителя
                    mm.removeMember(member);
                    fh.overWriteFile(member);
                }
                case 3 -> {
                    // Вывод информации о посетителе
                    mm.printMemberInfo(member);
                    System.out.flush(); // Очистить буфер вывода, чтобы увидеть информацию в консоли
                }
                case -1 -> {
                    // Завершение программы
                    System.out.println("Программа завершена.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Неверный выбор. Пожалуйста, выберите действие из списка.");
            }
        }

    }
}