package ik.ijse.ws.instagram_clone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class ExplorePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ep_id;
    private String description;
    private String image_url;
    private Timestamp date_time;

    public ExplorePost() {
    }

    public ExplorePost(int ep_id, String description, String image_url, Timestamp date_time) {
        this.ep_id = ep_id;
        this.description = description;
        this.image_url = image_url;
        this.date_time = date_time;
    }

    public int getEp_id() {
        return ep_id;
    }

    public void setEp_id(int ep_id) {
        this.ep_id = ep_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    @Override
    public String toString() {
        return "ExplorePost{" +
                "ep_id=" + ep_id +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                ", date_time=" + date_time +
                '}';
    }
}
