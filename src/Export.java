import java.io.*;

public class Export implements Serializable {
    public static void doExport() {
    }

    public void doExsport(Notepad np) throws IOException {
        FileOutputStream fos = new FileOutputStream("MyNotePad.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(np);
        oos.flush();
        oos.close();
    }
}