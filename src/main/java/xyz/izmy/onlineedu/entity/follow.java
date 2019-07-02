package xyz.izmy.onlineedu.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户类
 * @author hdg
 *
 */
@Entity
@Table(name = "follow")
public class follow implements Serializable {
    public follow(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private  User from_id;
    @OneToOne
    private User to_id;

    public void setId(int id) {
        this.id = id;
    }

    public void setFrom_id(User from_id) {
        this.from_id = from_id;
    }

    public void setTo_id(User to_id) {
        this.to_id = to_id;
    }

    public int getId() {
        return id;
    }

    public User getFrom_id() {
        return from_id;
    }

    public User getTo_id() {
        return to_id;
    }

    public follow(User from_id, User to_id) {
        this.from_id = from_id;
        this.to_id = to_id;
    }
}
