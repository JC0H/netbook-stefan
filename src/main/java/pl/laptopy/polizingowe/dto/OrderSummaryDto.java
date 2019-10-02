package pl.laptopy.polizingowe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.laptopy.polizingowe.utils.CustomConstants;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderSummaryDto {
    private Long id;

    @NotEmpty
    private Date orderDate;

    @NotEmpty(message = "No products added into order.")
    private List<ProductDto> products;

    @NotEmpty(message = "Provide username.")
    private String customerName;

    @NotEmpty(message = "Provide mail.")
    private String customerEmail;

    private String customerPhoneNumber = CustomConstants.DEFAULT_NUMBER;

    private final String uuid = generateUuid();

    private String generateUuid() {
        return UUID.randomUUID().toString();
    }

}
