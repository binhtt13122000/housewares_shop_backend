package fcode.binhtt.housewares_shop.entities.imgproduct;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fcode.binhtt.housewares_shop.entities.product.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "image_product")
public class ImageProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;
    @Column(name = "image_url")
    private String imageUrl;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false)
    @JsonManagedReference
    private Product product;
}
