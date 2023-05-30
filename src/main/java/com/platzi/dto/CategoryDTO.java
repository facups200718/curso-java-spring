package com.platzi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    //Se crean los DTO y no se usan los entity por el patron Data Mapper
    //Beneficios del Data Mapper:
    //1) Al separarse los objetos del dominio de los de la persistencia, si se cambia la bd o la table, solo hay que
    //hacer cambios en el lado de la persistencia, dejando el dominio intacto y no modificando la lógica de negocio.
    //2) Es más seguro porque podemos mantener en los entities los nombres de cada columna de la base de datos,
    //evitando usar la annotation @Column(name = ""). Podemos usar en las clases Entity propiedades en español
    //(si es que los nombres de los campos de la bd están en español) ya que en la parte de la lógica que es lo que va
    //a ver principalmente un desarrollador va a estar en inglés.
    private Integer categoryId;
    private String category;
    private Boolean active;
}
