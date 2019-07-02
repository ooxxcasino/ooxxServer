package xyz.izmy.onlineedu.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户类
 * @author hdg
 *
 */
@Entity
@Table(name = "score")
public class score implements Serializable {
    public score() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private int score;

    public score(Long userId, int score) {
        this.userId = userId;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}