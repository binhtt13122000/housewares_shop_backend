package fcode.binhtt.housewares_shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", insertable = false, unique = true, nullable = false)
    private Integer categoryId;
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @OneToMany(mappedBy="category")
    @JsonBackReference
    private List<Product> productList;
}
