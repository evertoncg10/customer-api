package com.everton.customerapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@Entity
@AllArgsConstructor
@Table(name = "tb_address")
public class AddressModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_address")
    private UUID idAddress;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpf")
    private CustomerModel customer;
    private int type;
    private String zipCode;
    @Column(name = "street_our_avenue")
    private String streetOurAvenue;
    private int number;
    private String complement;
    private String district;
    private String city;
    private String stade;
    private String country;
}
