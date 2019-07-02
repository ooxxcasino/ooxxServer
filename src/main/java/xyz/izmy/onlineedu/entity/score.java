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
    @OneToOne
    private User user_id;
    @OneToOne
    private Video video_id;
    private int score;

    public score(User user_id, Video video_id, int score) {
        this.user_id = user_id;
        this.video_id = video_id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
