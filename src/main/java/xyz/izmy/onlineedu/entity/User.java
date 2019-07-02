package xyz.izmy.onlineedu.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import xyz.izmy.onlineedu.pojo.Gender;
/**
 * 用户类
 * @author iYmz
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;

    @Column(nullable = false)
    private String account;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    //用户密码
    @Column(nullable = false)
    private String pwd;


    @Column(nullable = false)
    private int type;

    //用户头像url地址
    @Column(nullable = false)
    private String header;


    @Column(nullable = false)
    private int age;

    //用户教育水平
    @Column(nullable = false)
    private String education;

    //用户个人说明

    @Column(nullable = false)
    private String label;

    //我的视频
    @OneToMany
    private List<Video> myVideos;

    public User() {
    }

    public User(String account, Gender gender, String pwd, int type, String header, int age, String education, String label) {
        this.account = account;
        this.gender = gender;
        this.pwd = pwd;
        this.type = type;
        this.header = header;
        this.age = age;
        this.education = education;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
