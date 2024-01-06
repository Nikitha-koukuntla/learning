package com.nikki.learning.entity;

import com.nikki.learning.enums.Role;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Employee {
    private int id;
    private String name;
    private Role role;
}
