// Класс для представления одной задачи
class Task {
    // Поля: описание задачи и статус выполнения
    private String description;
    private boolean isCompleted;

    // Конструктор для создания задачи с описанием
    public Task(String description) {
        this.description = description;
        this.isCompleted = false; // По умолчанию задача не выполнена
    }

    // Геттер для описания
    public String getDescription() {
        return description;
    }

    // Геттер для статуса выполнения
    public boolean isCompleted() {
        return isCompleted;
    }

    // Метод для отметки задачи как выполненной
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Переопределение toString для удобного вывода задачи
    @Override
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + description;
    }
}