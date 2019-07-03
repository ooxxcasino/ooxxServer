package xyz.izmy.onlineedu.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * video entity
 * @author SEEDzy
 *
 */

@Entity
@Table(name = "video")
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Long id;

    @Column(name="video_name")
    private String name;

    //视频介绍
    @Column(name="video_info")
    private String info;

    //价格
    @Column(name="video_price")
    private int price;

    //图片链接
    @Column(name="video_image_url")
    private String imageUrl;

    //视频链接
    @Column(name="video_url")
    private String url;

    //观看次数
    @Column(name="video_times")
    private int times;

    //视频类型
    @Column(name="video_type")
    private String type;

    //视频下面的评论
    @OneToMany(
            mappedBy = "video",
            cascade = CascadeType.ALL
    )
    private List<comment> videoCommnets = new ArrayList<>();

    //每个人给视频打分
    @OneToMany
    private List<score> videoScores;


    public List<comment> getVideoCommnets() {
        return videoCommnets;
    }

    public void setVideoCommnets(List<comment> videoCommnets) {
        this.videoCommnets = videoCommnets;
    }

    protected Video() {
    }

    public Video(String name, String info, int price, String imageUrl, String url, int times, String type) {
        this.name = name;
        this.info = info;
        this.price = price;
        this.imageUrl = imageUrl;
        this.url = url;
        this.times = times;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}