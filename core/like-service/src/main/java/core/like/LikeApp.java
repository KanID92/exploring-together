package core.like;

import core.api.client.FeignClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@ComponentScan(basePackages = {"core.like", "stats.client"})
@Import({FeignClientConfig.class})
public class LikeApp {
    public static void main(String[] args) {
        SpringApplication.run(LikeApp.class, args);
    }
}
