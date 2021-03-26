package misterdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MisterDataApp {

    public static void main(String[] args) {
        SpringApplication.run(MisterDataApp.class, args);
    }

}
