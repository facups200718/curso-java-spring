package com.platzi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPurchaseEntity {
    @EmbeddedId
    private ProductPurchasePK id;

    @Column(name = "cantidad")
    private Integer amount;

    private Double total;

    @Column(name = "esado")
    private Boolean state;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private PurchaseEntity purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductEntity product;
}
