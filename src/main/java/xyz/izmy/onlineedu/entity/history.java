package xyz.izmy.onlineedu.entity;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户类
 * @author hdg
 *
 */
@Entity
@Table(name = "history")
public class history {
    public history() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private User user_id;
    @OneToOne
    private Video video_id;
    private Date time;

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setVideo_id(Video video_id) {
        this.video_id = video_id;
    }

    public int getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public User getUser_id() {
        return user_id;
    }

    public Video getVideo_id() {
        return video_id;
    }

    public history(User user_id, Video video_id, Date time) {
        this.user_id = user_id;
        this.video_id = video_id;
        this.time = time;
    }
}
