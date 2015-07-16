package hello;

/**
 * Created by stephen on 7/16/15.
 */
public class Test {
    private long id;
    private String message;

    public Test(long id) {
        this.id = id;
        this.message = "Stephen was here";
    }

    public long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }
}
