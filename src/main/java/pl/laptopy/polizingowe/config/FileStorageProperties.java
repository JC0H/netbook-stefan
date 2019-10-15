package pl.laptopy.polizingowe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import pl.laptopy.polizingowe.utils.AppConstants;

@ConfigurationProperties(prefix = AppConstants.FILE_PROPERTIES_PREFIX)
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
