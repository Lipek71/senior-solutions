package locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLocationCommand {

    @NotBlank(message = "Name can't be empty")
    private String name;
    @DecimalMin(value = "-90.00") @DecimalMax(value = "90.00")
    private double lat;
    @DecimalMin(value = "-180.00") @DecimalMax(value = "180.00")
    private double lon;
}
