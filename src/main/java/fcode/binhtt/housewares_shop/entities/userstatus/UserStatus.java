package fcode.binhtt.housewares_shop.entities.userstatus;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fcode.binhtt.housewares_shop.entities.user.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "user_status")
public class UserStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", insertable = false, unique = true, nullable = false)
    private Integer statusId;
    @Column(name = "status_name", nullable = false)
    private String statusName;

    @OneToMany(mappedBy = "userStatus")
    @JsonBackReference
    private List<User> userList;
}
