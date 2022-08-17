package com.example.week03_day03_hw_school_managment_rahafalammar.Jpa;

//import com.example.week03_day03_hw_school_managment_rahafalammar.Enum.Major;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id @NotNull(message = "id can't be empty")
    private Long id;
    @NotEmpty(message = "name can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "age can't be empty")
    private Integer age;
    @NotEmpty(message = "major can't be empty")
    //@Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) check (major='CS' or major='MATH' or major='Engineer')")
    private String major;
}
