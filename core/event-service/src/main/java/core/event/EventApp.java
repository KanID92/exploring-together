package core.event;

import core.api.client.FeignClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@ComponentScan(basePackages = {"core.event", "stats.client"})
@Import({FeignClientConfig.class})
public class EventApp {

    public static void main(String[] args) {
        SpringApplication.run(EventApp.class, args);

    }
}
