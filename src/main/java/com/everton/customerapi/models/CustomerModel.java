package com.everton.customerapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@Entity
@AllArgsConstructor
@Table(name = "tb_customers")
public class CustomerModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private String cpf;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "social_name")
    private String socialName;
    @Column(name = "birth_date")
    private String birthDate;
    @OneToMany(mappedBy = "customer")
    private List<AddressModel> adresses;
    @OneToMany(mappedBy = "customer")
    private List<PhoneModel> phones;
    private String email;
}