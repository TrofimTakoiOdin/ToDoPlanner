import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Import implements Serializable {
    public static void doImport() throws IOException, ClassNotFoundException {
        Notepad npExport = new Notepad();
        FileInputStream fis = new FileInputStream("MyNotePad.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        npExport = (Notepad) oin.readObject();
    }
}