package com.demoqa.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Employee {
    String firstName;
    String lastName;
    int age;
    String email;
    int salary;
    String department;
}
