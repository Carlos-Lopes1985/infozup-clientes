package com.infozup.cadastrocliente.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cellphone;
    private String secondaryCellphone;
    private String email;

    @OneToOne(mappedBy = "contact")
    private Person person;

    public Contact(Long id, String cellphone, String secondaryCellphone, String email) {
        this.id = id;
        this.cellphone = cellphone;
        this.secondaryCellphone = secondaryCellphone;
        this.email = email;
    }
}