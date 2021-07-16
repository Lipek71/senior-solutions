package appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NavAppointment {
    @TaxIdValidation
    private String taxId;
    private NavCaseType caseType;
    private NavAppointmentInterval interval;
}
