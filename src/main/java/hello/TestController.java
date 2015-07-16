package hello;

/**
 * Created by stephen on 7/16/15.
 */

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public Test test(@RequestParam(value = "", defaultValue = "") String name) {
        return new Test(counter.incrementAndGet());
    }
}
