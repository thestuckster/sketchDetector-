package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ScraperController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/scrape")
    public Scraper scraper(@RequestParam(value="url", defaultValue = "") String Url) {
        return new Scraper(counter.incrementAndGet(), Url);
    }
}
