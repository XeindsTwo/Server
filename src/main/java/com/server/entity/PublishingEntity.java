package com.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "publishings")
public class PublishingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String publishingName;
    private String city;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publishing")
    private List<BookEntity> books;
}
