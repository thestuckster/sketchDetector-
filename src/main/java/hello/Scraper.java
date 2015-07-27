package hello;

import java.io.*;
import java.net.*;

public class Scraper {
    private final long id;
    private final String url;
    private String source;
    private boolean containsEval = false;
    private boolean containsDocumentWrite = false;
    private boolean containsIFrame = false;

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

    public String getSource() {
        scrape();
        return this.source;
    }

    public boolean getContainsEval() {
        return this.containsEval;
    }

    public boolean getContainsDocumentWrite() {
        return this.containsDocumentWrite;
    }

    public boolean getContainsIFrame() {
        return this.containsIFrame;
    }

    private void checkForFlags(String src) {
        String ev  = "eval(";
        String dw  = "document.write(";
        String ifr = "<iframe";

        this.containsEval = src.contains(ev);
        this.containsDocumentWrite = src.contains(dw);
        this.containsIFrame = src.contains(ifr);
    }

    private void scrape() {
        String line;

        try {
            URL url = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if (conn.getResponseCode() != 200) {
                this.source = "bad connection to site";
                return;
            }

            //buffer result into a String
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();

            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

            rd.close();
            conn.disconnect();

            checkForFlags(sb.toString());
            this.source = sb.toString();

        } catch (MalformedURLException e) {
            if(this.url.equals("")) {
                this.source = "No URL Given";
                e.printStackTrace();
                return;
            } else {
                this.source = "Malformed URL";
                e.printStackTrace();
                return;
            }
            
        } catch (IOException e) {
            this.source = "IO Exception";
            e.printStackTrace();
            return;
        }

    }
}
