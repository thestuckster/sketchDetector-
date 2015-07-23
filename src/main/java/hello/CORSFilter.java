package hello;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
    throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) res;
    HttpServletRequest request = (HttpServletRequest)req;

    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
    response.setHeader("Access-Control-Allow-Methods", 
        request.getHeader("Access-Control-Request-Method"));
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", 
        request.getHeader("Access-Control-Request-Headers"));
    chain.doFilter(req, res);
}

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}
