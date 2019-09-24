package pl.laptopy.polizingowe.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "properties")
@PropertySource("classpath:/config-properties/stefan-app.properties")
@Getter
@Setter
public class PropertiesConfig {
    private String mail;
    private String mailPassword;
    private String securityUsername;
    private String securityPassword;
}
