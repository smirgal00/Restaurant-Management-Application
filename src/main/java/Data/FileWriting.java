package Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {
    FileWriter fw;
    BufferedWriter wr;

    public FileWriting() {
        fw = null;
        wr = null;
    }

    public void generateBill(String title, String content) {
        try {
            fw = new FileWriter(title);
            wr = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assert wr != null;

            wr.write(content);
            wr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
