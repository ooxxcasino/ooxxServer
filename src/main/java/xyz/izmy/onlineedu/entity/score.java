package xyz.izmy.onlineedu.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

/*    @Column(nullable = false, name = "user_id")
    private Long userId;*/

    @Column(nullable = false)
    private int score;

    private int scoreTimes;

    @OneToMany
    private List<UserScore> userScoreList;

    public score(int score, int scoreTimes, List<UserScore> userScoreList) {
        this.score = score;
        this.scoreTimes = scoreTimes;
        this.userScoreList = userScoreList;
    }

    public List<UserScore> getUserScoreList() {
        return userScoreList;
    }

    public void setUserScoreList(List<UserScore> userScoreList) {
        this.userScoreList = userScoreList;
    }

    public int getScoreTimes() {
        return scoreTimes;
    }

    public void setScoreTimes(int scoreTimes) {
        this.scoreTimes = scoreTimes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

/*    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }*/

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}