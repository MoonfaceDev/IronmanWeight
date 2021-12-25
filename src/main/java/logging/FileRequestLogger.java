package logging;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileRequestLogger implements IRequestLogger {

    private final OutputStream stream;

    public FileRequestLogger(String filePath) throws FileNotFoundException {
        this.stream = new FileOutputStream(filePath);
    }

    @Override
    public void log(String data) {
        try {
            this.stream.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
