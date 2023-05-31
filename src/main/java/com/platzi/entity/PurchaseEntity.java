package com.platzi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer purchaseId;

    @Column(name = "id_cliente")
    private String clientId;

    @Column(name = "fecha")
    private LocalDateTime dateTime;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @Column(name = "comentario")
    private String observations;

    @Column(name = "estado")
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private ClientEntity client;

    //Con el cascade = CascadeType.ALL estamos indicando que si hacemos una modificacion a un elemento de la lista
    //de productos del PurchaseEntity (entidad padre), se van a afectar las tablas que representadas por las
    //entidades hijas ProductPurchaseEntity, como si fuera una estructura jerarquica en "cascada"
    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<ProductPurchaseEntity> products;
}
