package fcode.binhtt.housewares_shop.entities.cart;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fcode.binhtt.housewares_shop.entities.user.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", insertable = false, nullable = false, unique = true)
    private Integer cartId;
    @Column(name = "created_time", nullable = false)
    private Date createdTime;
    @Column(name = "isPaid")
    private Integer isPaid;
    @ManyToOne
    @JoinColumn(name = "[user_id]", nullable = false)
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy = "product")
    private List<CartDetail> products;
}
