import java.io.*;
import java.net.*;

public class Scraper {
  public static String httpGet(String urlStr) throws IOException {
    URL url = new URL(urlStr);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    if (conn.getResponseCode() != 200) {
      throw new IOException(conn.getResponseMessage());
    }

    // Buffer the result into a string
    BufferedReader rd = new BufferedReader(new InputStreamReader(
        conn.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      sb.append(line);
    }
    rd.close();
    conn.disconnect();
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {

    System.out.println(Scraper.httpGet(args[0]));
  }
}