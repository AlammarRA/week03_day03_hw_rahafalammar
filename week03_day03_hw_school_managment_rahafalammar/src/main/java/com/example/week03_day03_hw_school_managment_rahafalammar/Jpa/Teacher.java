package com.example.week03_day03_hw_school_managment_rahafalammar.Jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Teacher {
    @Id
    @NotNull(message = "id can't be empty")
    private Long id;
    @NotEmpty(message = "name can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "salary can't be empty")
    private Integer salary;

}
