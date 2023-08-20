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
@NoArgsConstructor
@Table(name = "tb_phone")
public class PhoneModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_phone", updatable = false, unique = true, nullable = false)
    private UUID idPhone;
    @ManyToOne
    private CustomerModel customer;
    private int type;
    private String number;
    private String ddd;
    private String ddi;
    @Column(name = "branch_line")
    private String branchLine;
}
