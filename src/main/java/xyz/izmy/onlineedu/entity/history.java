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
    private Video video_id;
    private Date time;

    public history(Video video_id, Date time) {
        this.video_id = video_id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Video getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Video video_id) {
        this.video_id = video_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
