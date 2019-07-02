package xyz.izmy.onlineedu.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "video")
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



}
