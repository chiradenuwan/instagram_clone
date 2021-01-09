package lk.ijse.ws.instagram.instagram_clone.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class React {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User reactor;
    @ManyToOne
    private Post post;
    private String reaction;
    private Date time;
}
