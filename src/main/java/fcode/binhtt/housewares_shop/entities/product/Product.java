package fcode.binhtt.housewares_shop.entities.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fcode.binhtt.housewares_shop.entities.brand.Brand;
import fcode.binhtt.housewares_shop.entities.cart.CartDetail;
import fcode.binhtt.housewares_shop.entities.category.Category;
import fcode.binhtt.housewares_shop.entities.comment.Comment;
import fcode.binhtt.housewares_shop.entities.imgproduct.ImageProduct;
import fcode.binhtt.housewares_shop.entities.rate.Rate;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {
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
    @Column(name = "origin",nullable = false)
    private String origin;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "size")
    private String size;
    @Column(name = "status_id", nullable = false)
    private Integer statusId;
    @OneToMany(mappedBy="product")
    @JsonBackReference
    private List<ImageProduct> imageUrl;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "last_updated")
    private Date lastUpdated;
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    @JsonManagedReference
    private Category category;
    @ManyToOne
    @JoinColumn(name="brand_id", nullable=false)
    @JsonManagedReference
    private Brand brand;

    @OneToMany(mappedBy = "user")
    private List<Rate> users;
    @OneToMany(mappedBy = "user")
    private List<Comment> userList;

    @OneToMany(mappedBy = "cart")
    private List<CartDetail> carts;
}
