package com.platzi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEntity {
    @Id
    private String id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String surnames;

    @Column(name = "celular")
    private Long phoneNumber;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<PurchaseEntity> purchases;
}
