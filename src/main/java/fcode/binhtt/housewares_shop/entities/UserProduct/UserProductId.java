package fcode.binhtt.housewares_shop.entities.UserProduct;

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
public class UserProductId implements Serializable {
    @Column(name = "[user_id]")
    private Integer userId;
    @Column(name = "product_id")
    private Integer productId;
}
