package seminar5HW.sem5.module;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "short_description", nullable = false)
    private String shortDesc;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private TaskStatus status;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime createTaskDate;

}
