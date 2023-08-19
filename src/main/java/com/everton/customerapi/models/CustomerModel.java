package com.everton.customerapi.models;

import com.everton.customerapi.dto.AddressRecord;
import com.everton.customerapi.dto.PhoneRecord;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "tb_customers")
public class CustomerModel implements Serializable {
    @Id
    private String cpf;
    private String fullName;
    private String socialName;
    private String birthDate;
    private List<AddressRecord> adresses;
    private List<PhoneRecord> phones;
    private String email;
}
