package appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NavAppointmentInterval {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
