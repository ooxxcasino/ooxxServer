package xyz.izmy.onlineedu.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "userScore")
public class UserScore implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;

    @Column(name = "userAccount")
    private String userAccount;

    @Column(name = "videoId")
    private Long videoId;

    public UserScore(String userAccount, Long videoId) {
        this.userAccount = userAccount;
        this.videoId = videoId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public UserScore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}