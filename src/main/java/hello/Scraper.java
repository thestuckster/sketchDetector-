package hello;

import java.io.*;
import java.net.*;

public class Scraper {
    private final long id;
    private final String url;
    private String source;

    public Scraper(long id, String url) {
        this.id = id;
        this.url = url;
    }

    public long getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public String scrape() {
        String line;

        if(this.url.equals("")) {
            this.source = "no url given";
            return this.source;
        }

        try {
            URL url = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if (conn.getResponseCode() != 200) {
                this.source = "bad connection to site";
            }

            //buffer result into a String
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();

            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

            rd.close();
            conn.disconnect();

            this.source = sb.toString();

        } catch (MalformedURLException e) {
            this.source = "Malformed URL";
            e.printStackTrace();
        } catch (IOException e) {
            this.source = "IO Exception";
            e.printStackTrace();
        }

        return this.source;
    }
}