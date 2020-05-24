package fcode.binhtt.housewares_shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "", nullable = false, unique = true)
    private Integer userId;

    private String username;

    private String password;

    private String lastName;

    private String firstName;

    private String email;

    private String phone;

    private Date birthDay;

    private String avtUrl;

    private Integer statusId;

    private Integer roleId;

    private Date createdTime;
}
