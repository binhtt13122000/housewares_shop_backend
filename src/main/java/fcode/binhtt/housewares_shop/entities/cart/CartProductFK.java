package fcode.binhtt.housewares_shop.entities.cart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductFK implements Serializable {
    @Column(name = "cart_id")
    private Integer cartId;
    @Column(name = "product_id")
    private Integer productId;
}
