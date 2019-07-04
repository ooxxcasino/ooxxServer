package xyz.izmy.onlineedu.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

   // @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false,unique = true)
    private String account;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    //用户密码
    @Column(nullable = false)
    private String pwd;


   // @Column(nullable = false)
    private int type;

    //用户头像url地址
    //@Column(nullable = false)
    private String header;


    //@Column(nullable = false)
    private int age;

    //用户教育水平
   // @Column(nullable = false)
    private String education;

    //用户个人说明

   // @Column(nullable = false)
    private String label;


    private String email;
    private String phone;
    private Date birthday;


    @OneToMany
    private List<Video> myVideos;

   @OneToMany
   private List<history> watchedHistory;


    public User() {
    }

    public User(String name, String account, Gender gender, String pwd, int type, String header, int age, String education, String label, String email, String phone, Date birthday, List<Video> myVideos, List<history> watchedHistory) {
        this.name = name;
        this.account = account;
        this.gender = gender;
        this.pwd = pwd;
        this.type = type;
        this.header = header;
        this.age = age;
        this.education = education;
        this.label = label;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.myVideos = myVideos;
        this.watchedHistory = watchedHistory;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Video> getMyVideos() {
        return myVideos;
    }

    public void setMyVideos(List<Video> myVideos) {
        this.myVideos = myVideos;
    }

    public List<history> getWatchedHistory() {
        return watchedHistory;
    }

    public void setWatchedHistory(List<history> watchedHistory) {
        this.watchedHistory = watchedHistory;
    }
}
