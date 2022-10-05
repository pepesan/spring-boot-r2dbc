package com.cursosdedesarrolo.demor2dbc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("product")
public class ProductEntity {
    @Id
    private Long id;
    private String name;
    private String description;
    public boolean hasId() {
        return id != null;
    }
}
