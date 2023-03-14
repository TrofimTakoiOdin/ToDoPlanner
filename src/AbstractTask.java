import java.io.Serializable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractTask implements Serializable {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private final int ID;
    private final String DAY;
    private final String TIME_OF_CREATION;
    private int priority;
    private String whatToDo;
    private String deadLine;
    private String author;

    public AbstractTask() {
        ID = COUNTER.getAndIncrement();
        DAY = setDay();
        TIME_OF_CREATION = setTIME_OF_CREATION();

    }
    public int getId() {
        return ID;
    }
    public String getDay() {
        return DAY;
    }
    public String getTIME_OF_CREATION() {
        return TIME_OF_CREATION;
    }
    public String setDay() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE - d MMM uuuu");
        String day = localDate.format(dateTimeFormatter);
        return day;
    }

    public String setTIME_OF_CREATION() {
        String time = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond();
        return time;
    }


    public abstract int getPriority();

    public abstract void setPriority(int prior);

    public abstract String getWhatToDo();

    public abstract void setWhatToDo(String toDo);

    public abstract String getDeadLine();

    public abstract void setDeadLine(String deadLine);

    public abstract String getAuthor();

    public abstract void setAuthor(String author);


    public abstract String toString();
}
