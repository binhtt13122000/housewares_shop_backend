package fcode.binhtt.housewares_shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", insertable = false, unique = true, nullable = false)
    private Integer brandId;
    @Column(name = "brand_name", nullable = false)
    private String brandName;
    @JsonBackReference
    @OneToMany(mappedBy="brand")
    private List<Product> productList;
}

