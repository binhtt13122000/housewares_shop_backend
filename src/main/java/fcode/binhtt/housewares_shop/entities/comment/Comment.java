package fcode.binhtt.housewares_shop.entities.comment;

import fcode.binhtt.housewares_shop.entities.userproduct.UserProductId;
import fcode.binhtt.housewares_shop.entities.product.Product;
import fcode.binhtt.housewares_shop.entities.user.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", insertable = false, nullable = false, unique = true)
    private Integer commentId;
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
    @Column(name = "comment", nullable = false)
    private String comment;
    @Column(name = "parent_id", nullable = false)
    private Integer parentId;
}
