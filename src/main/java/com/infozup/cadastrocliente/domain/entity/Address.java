package com.infozup.cadastrocliente.domain.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String postalCode;

    @OneToOne(mappedBy = "address")
    private Person person;

    public Address(Long id, String street, String number, String complement, String city, String state, String postalCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
}