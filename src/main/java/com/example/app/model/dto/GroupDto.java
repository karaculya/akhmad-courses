package com.example.app.model.dto;

import com.example.app.model.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private Long id;
    private String groupName;
    private List<Student> students;
}
