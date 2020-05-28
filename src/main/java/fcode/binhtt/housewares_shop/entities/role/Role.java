package fcode.binhtt.housewares_shop.entities.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fcode.binhtt.housewares_shop.entities.user.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "[role]")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false, insertable = false, unique = true)
    private Integer roleId;
    @Column(name = "role_name", nullable = false)
    private String roleName;
    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private List<User> userList;
}
