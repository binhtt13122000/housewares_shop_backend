package fcode.binhtt.housewares_shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, insertable = false, unique = true)
    private Integer productId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "product_price", nullable = false)
    private Integer price;
    @Column(name = "promotion")
    private Integer promotion;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "origin")
    private String origin;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "size")
    private String size;
    @OneToMany(mappedBy="product")
    @JsonBackReference
    private List<ImageProduct> imageUrl;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "last_updated")
    private Date lastUpdated;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false)
    @JsonManagedReference
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="brand_id", nullable=false)
    @JsonManagedReference
    private Brand brand;
}
