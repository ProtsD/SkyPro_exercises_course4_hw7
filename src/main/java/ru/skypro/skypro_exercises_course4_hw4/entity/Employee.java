package ru.skypro.skypro_exercises_course4_hw4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;

import java.util.Objects;


@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
