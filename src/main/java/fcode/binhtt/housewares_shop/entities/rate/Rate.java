package fcode.binhtt.housewares_shop.entities.rate;

import fcode.binhtt.housewares_shop.entities.UserProduct.UserProductId;
import fcode.binhtt.housewares_shop.entities.product.Product;
import fcode.binhtt.housewares_shop.entities.user.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "rate")
public class Rate implements Serializable {
    @EmbeddedId
    private UserProductId userProductId;
    @ManyToOne
    @MapsId("userId")
    private User user;
    @ManyToOne
    @MapsId("productId")
    private Product product;

    @Column(name = "created_time", nullable = false)
    private Date createdTime;
    @Column(name = "last_update", nullable = false)
    private Date lastUpdate;
    @Column(name = "rate", nullable = false)
    private Integer rate;
}
