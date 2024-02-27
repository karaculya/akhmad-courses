package com.example.app.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@NamedEntityGraph(
        name = "professor-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("courses")
        }
)
@Entity
@Getter
@Setter
@Table
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private String email;
    private String login;
    private String password;
    @OneToMany(mappedBy = "professor")
    @Fetch(FetchMode.SUBSELECT)
    private List<Course> courses;
}