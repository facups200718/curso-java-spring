package com.platzi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPurchasePK implements Serializable {
    @Column(name = "id_compra")
    private Integer purchaseId;

    @Column(name = "id_producto")
    private Integer productId;
}
