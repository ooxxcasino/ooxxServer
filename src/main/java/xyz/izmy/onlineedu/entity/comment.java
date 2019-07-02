package xyz.izmy.onlineedu.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 * @author hdg
 *
 */
@Entity
@Table(name = "comment")
public class comment implements Serializable {
    public comment() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private User user_id;

    @OneToOne
    private Video video_id;

    @OneToOne
    private User to;

    private String content;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Video getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Video video_id) {
        this.video_id = video_id;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public comment(User user_id, Video video_id, User to, String content, Date date) {
        this.user_id = user_id;
        this.video_id = video_id;
        this.to = to;
        this.content = content;
        this.date = date;
    }
}
