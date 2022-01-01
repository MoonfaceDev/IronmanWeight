package logging;

import java.util.Map;

public interface IRequestLogger {
    void log(Map<String, Object> data);
}
