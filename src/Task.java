import java.util.Scanner;

public class Task extends AbstractTask {

    private int priority;
    private String whatToDo;
    private String deadLine;
    private String author;



    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority(int prior) {
        this.priority = prior;

    }

    @Override
    public String getWhatToDo() {
        return whatToDo;
    }

    @Override
    public void setWhatToDo(String toDo) {
        this.whatToDo = toDo;

    }

    @Override
    public String getDeadLine() {
        return deadLine;
    }

    @Override
    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;

    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;

    }


    @Override
    public String toString() {
        String str = "Текущая задача: " + whatToDo + "Приоритет задачи: " + priority + "Дедлайн: " + deadLine + "Автор задачи: " + author;
        return str;
    }



}
