package Movie;

import java.io.BufferedReader;
import java.io.FileReader;

public class TextFileReader {
    public static String readTextFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "파일을 읽을 수 없습니다.";
        }
        return content.toString();
    }
}