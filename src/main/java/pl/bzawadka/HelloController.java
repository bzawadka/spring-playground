package pl.bzawadka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.bzawadka.data.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private static final String HELLO = "Greetings from Spring Boot!";
    private static final String HELLO_TEMPLATE = "Hello, my dearest friend %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String index() {
        return HELLO;
    }

    @RequestMapping("/resource")
    public MyResource resource() {
        return new MyResource(1, "myValue");
    }

    // The @ResponseBody annotation tells Spring MVC not to render a model into a view, but rather to write the returned object into the response body
    // Because Jackson 2 is in the classpath, this means that MappingJackson2HttpMessageConverter will handle the conversion of Greeting to JSON if the request’s Accept header specifies that JSON should be returned
    @RequestMapping("/hello")
    @ResponseBody public Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        String greeting = String.format(HELLO_TEMPLATE, name);
        return new Greeting(counter.incrementAndGet(), greeting);
    }
}
