import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    String getDataString(String pass) throws IOException {
        //    String pass;
        URL url = new URL(pass);
        StringBuilder data = new StringBuilder();
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = urlConnection.getInputStream();
            int i;
            while ((i=inputStream.read()) != -1) {
                data.append((char)i);
            }
        }
        return data.toString();
    }
}
