import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Notepad {
    public static Scanner input = new Scanner(System.in);

    private static List<Task> tasksList = new ArrayList<>();

    public List<Task> getTasksList() {
        return tasksList;
    }
    public static void addTask(Task task){
        tasksList.add(task);
    }

    public static void menu() throws IOException, ClassNotFoundException {
        boolean flag = true;
        while (flag) {
            Notepad.ShowInfo();
            int num = Notepad.UserIn();

            switch (num) {
                case 1:
                    Task newTask = new Task();
                    newTask = Notepad.createTask();
                    Notepad.addTask(newTask);
                    flag = false;

                case 2:
                    Notepad.ShowTaskManager();
                    flag = false;
                case 3:
                    Import.doImport();
                    flag = false;
                case 4:
                    Export.doExport();
                    flag = false;
                case 5:
                    System.exit(0);

            }
        }
    }
    public static int UserIn() {

        int x = 0;
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> intList = new ArrayList<>(Arrays.asList(nums));
        while (true) {
            System.out.println("Введите число от 1 до 5" +
                    ">> ");
            x = input.nextInt();
            if (intList.contains(x)) {
                break;
            }
        }
        return x;
    }

    public static Task createTask() {
        Task newTask = new Task();
        System.out.println("Давайте создадим новое задание.");
        System.out.println("Что нужно сделать? " +
                ">> ");
        String whatToDo = input.next();
        newTask.setWhatToDo(whatToDo);

        System.out.println("Как срочно это нужно сделать? \nУстановим приоритет. \n" +
                "1 - немедленное выполнение, 2 - средний приоритет, 3 - низкий приоритет\n"  +
                " Введите целое число от 1 до 3 \n" +
                ">> ");
        int priority = input.nextInt();
        newTask.setPriority(priority);

        System.out.println("К какому дню нужно выполнить задание? Напишите день недели и/или дату" +
                ">> ");
        String deadline = input.next();
        newTask.setDeadLine(deadline);

        System.out.println("Укажите автора задания \n" +
                ">>");

        String author = input.next();
        newTask.setAuthor(author);
        tasksList.add(newTask);

        return newTask;
    }


    public static void ShowInfo(){
        System.out.println("Добро пожаловать в меню!");
        System.out.println("1. Создать задание" +
                "\n 2. Посмотреть имеющиеся задания" +
                "\n 3. Импорт заданий" +
                "\n 4. Экспорт заданий" +
                "\n 5. Выход \n");
    }




    public static void ShowTaskManager() {
        System.out.println("Какие задания показать? \n (1 - Немедленное выполнение, 2 - Средний приоритет, " +
                "3 - не к спеху :), 4 - Показать все задания.");

        int x = UserIn();

        switch (x) {
            case (1):
                printTasks(tasksList, x);

            case (2):
                printTasks(tasksList, x);

            case (3):
                printTasks(tasksList, x);

            case (4):
                for (Task elem : tasksList) {System.out.println(elem);}

        }
    }

    public static void printTasks(List<Task> tasksList, int x) {
        for (var elem : tasksList) {
            if (elem.getPriority() == x) {System.out.println(elem);}
        }
    }
}
