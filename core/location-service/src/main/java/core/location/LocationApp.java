package core.location;

import core.api.client.FeignClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@EnableDiscoveryClient
@Import({FeignClientConfig.class})
public class LocationApp {
    public static void main(String[] args) {
        SpringApplication.run(LocationApp.class, args);
    }
}
