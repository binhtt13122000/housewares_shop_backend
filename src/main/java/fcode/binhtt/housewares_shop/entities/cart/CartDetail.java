package fcode.binhtt.housewares_shop.entities.cart;

import fcode.binhtt.housewares_shop.entities.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "cart_detail")
public class CartDetail implements Serializable {
    @EmbeddedId
    private CartProductFK cartProductFK;
    @ManyToOne
    @MapsId("cartId")
    private Cart cart;
    @ManyToOne
    @MapsId("productId")
    private Product product;
}
