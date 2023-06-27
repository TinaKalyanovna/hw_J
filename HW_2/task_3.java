// х








import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_3 {
    private static Scanner scaner = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(task_3.class.getName());
    private static SimpleFormatter simple_formatter = new SimpleFormatter();

    public static void main(String[] args) {
        try {
            FileHandler fileH = new FileHandler("sem2_log.log", true);
            fileH.setFormatter(simple_formatter);
            logger.addHandler(fileH);
            // task3();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public static void task3() {
    int i;
    String[] word = {"Студент", " получил", " по предмету"};
    StringBuilder strbld = new StringBuilder();
    try {
        String[] objs = FileReader("task3.data", StandardCharsets.UTF_8).replace("[", "")
                                                                        .replace("]", "")
                                                                        .split("},");
        for (String obj: objs) {
            String[] fields = obj.replaceAll("[{}\"]", "")
                                    .split(",");
            i = 0;
            for (String field: fields) {
                strbld.append(word[i]);
                i++;
                strbld.append(" " + field.split(":")[1]);
            }
            System.out.println(strbld.toString());
            strbld.delete(0, strbld.length());
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}

public static String FileReader(String path, Charset encoding) throws IOException {
    File file = new File(path);
    InputStream inStream = new FileInputStream(file);
    byte[] bytes = new byte[(int)file.length()];

    int offset = 0;
    while (offset < bytes.length) {
        int result = inStream.read(bytes, offset, bytes.length - offset);
        if (result == -1) {
            break;
        }
        offset += result;
    }
    inStream.close();
    return new String(bytes, encoding);
}