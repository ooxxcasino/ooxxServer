package xyz.izmy.onlineedu.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name="comment_user_id",nullable = false)
    private Long userId;

    @Column(name = "comment_user_name",nullable = false)
    private String userName;

    @Column(name = "comment_content")
    private String content;

    @Column(name = "comment_date")
    private Date date;

    //回复人的id
    @Column(name = "comment_toUserName")
    private String toUserName;

    //回复主题的id
    @Column(name = "comment_toCommentId")
    private Long toCommentId;

    public Comment() {
    }

    public Comment(Long userId, String userName, String content, Date date, String toUserName, Long toCommentId) {
        this.userId = userId;
        this.userName = userName;
        this.content = content;
        this.date = date;
        this.toUserName = toUserName;
        this.toCommentId = toCommentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public Long getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(Long toCommentId) {
        this.toCommentId = toCommentId;
    }
}
