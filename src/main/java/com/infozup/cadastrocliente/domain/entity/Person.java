package com.infozup.cadastrocliente.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String cpf;
    private String socialName;
    private LocalDate birthDate;
    private LocalDate registerDate;

    public Person(Integer id, String name, String cpf, String socialName, LocalDate birthDate, LocalDate registerDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.socialName = socialName;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
    }

    @OneToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
