package pl.laptopy.polizingowe.model;

import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Provide receivers.")
    @ElementCollection
    private List<String> receivers;

    @NotEmpty(message = "Provide message")
    private String message;

    @NotEmpty(message = "Provide subject of Your message.")
    private String subject;

    @Nullable
    @ElementCollection
    private List<String> pathToAttachment;

}
