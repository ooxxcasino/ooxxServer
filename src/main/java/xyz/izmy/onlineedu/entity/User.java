package xyz.izmy.onlineedu.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户类
 * @author iYmz
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
