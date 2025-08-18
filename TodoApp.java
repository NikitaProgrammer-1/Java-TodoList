import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Основной класс приложения для управления списком задач
public class TodoApp {
    public static void main(String[] args) {
        // Инициализация списка задач и сканнера для ввода
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Основной цикл программы с меню
        while (true) {
            // Вывод меню опций
            System.out.println("Меню: 1-Добавить, 2-Отметить, 3-Удалить, 4-Вывести, 0-Выход");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера после ввода числа
                switch (choice) {
                    case 1:
                        addTask(tasks, scanner);
                        break;
                    case 2:
                        markCompleted(tasks, scanner);
                        break;
                    case 3:
                        removeTask(tasks, scanner);
                        break;
                    case 4:
                        printTasks(tasks);
                        break;
                    case 0:
                        System.out.println("Выход");
                        scanner.close(); // Закрываем сканнер при выходе
                        return;
                    default:
                        System.out.println("Неверный выбор, попробуйте снова");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите число!");
                scanner.nextLine(); // Очистка буфера при неверном вводе
            }
        }
    }

    // Метод для добавления новой задачи
    private static void addTask(ArrayList<Task> tasks, Scanner scanner) {
        System.out.println("Введите описание задачи:");
        String desc = scanner.nextLine();
        // Проверка на пустое описание
        if (desc.trim().isEmpty()) {
            System.out.println("Ошибка: Описание не может быть пустым");
            return;
        }
        tasks.add(new Task(desc));
        System.out.println("Задача добавлена");
    }

    // Метод для вывода списка задач
    private static void printTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст");
            return;
        }
        // Вывод задач с номерами (нумерация с 1 для пользователя)
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    }

    // Метод для отметки задачи как выполненной
    private static void markCompleted(ArrayList<Task> tasks, Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст");
            return;
        }
        System.out.println("Введите номер задачи:");
        try {
            int num = scanner.nextInt() - 1; // Нумерация с 1 для пользователя
            scanner.nextLine(); // Очистка буфера
            if (num >= 0 && num < tasks.size()) {
                tasks.get(num).markAsCompleted();
                System.out.println("Задача отмечена как выполненная");
            } else {
                System.out.println("Ошибка: Неверный номер задачи");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите число!");
            scanner.nextLine(); // Очистка буфера
        }
    }

    // Метод для удаления задачи
    private static void removeTask(ArrayList<Task> tasks, Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст");
            return;
        }
        System.out.println("Введите номер задачи:");
        try {
            int num = scanner.nextInt() - 1; // Нумерация с 1 для пользователя
            scanner.nextLine(); // Очистка буфера
            if (num >= 0 && num < tasks.size()) {
                tasks.remove(num); // Удаляем задачу
                System.out.println("Задача удалена");
            } else {
                System.out.println("Ошибка: Неверный номер задачи");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите число!");
            scanner.nextLine(); // Очистка буфера
        }
    }
}