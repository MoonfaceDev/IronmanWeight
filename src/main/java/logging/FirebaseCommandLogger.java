package logging;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class FirebaseCommandLogger implements ICommandLogger {

    DatabaseReference logsReference;

    public FirebaseCommandLogger() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("google-credentials.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://ironman-weight-default-rtdb.firebaseio.com/")
                        .build();

        FirebaseApp.initializeApp(options);
        this.logsReference = FirebaseDatabase.getInstance()
                .getReference("logs");
    }

    @Override
    public void log(Map<String, Object> data) {
        this.logsReference.push().setValueAsync(data);
    }
}
