import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetRequest {
    private final HttpURLConnection connection;

    public HttpGetRequest(String urlString) throws IOException {
        HttpURLConnection connection = openConnection(urlString);
        this.connection = connection;
        sendRequest(connection);
    }

    public String get() throws IOException {
        return receiveResponse(this.connection);
    }

    private HttpURLConnection openConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        return connection;
    }

    private String receiveResponse(HttpURLConnection connection) throws IOException {
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }

    private void sendRequest(HttpURLConnection connection) throws IOException {
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.close();
    }
}
