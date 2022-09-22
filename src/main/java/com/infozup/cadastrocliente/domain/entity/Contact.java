package com.infozup.cadastrocliente.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cellphone;
    private String secondaryCellphone;
    private String email;

    @JsonIgnore
    @OneToOne(mappedBy = "contact")
    private Person person;

    public Contact(Long id, String cellphone, String secondaryCellphone, String email) {
        this.id = id;
        this.cellphone = cellphone;
        this.secondaryCellphone = secondaryCellphone;
        this.email = email;
    }
}