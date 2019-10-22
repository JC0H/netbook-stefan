package pl.laptopy.polizingowe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.laptopy.polizingowe.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class NotebookStefanApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotebookStefanApplication.class, args);
    }
}
