package ik.ijse.ws.instagram_clone.dto;

import java.sql.Timestamp;

public class ExploreDto {
    private String description;
    private String image_url;
    private Timestamp date_time;

    public ExploreDto() {
    }

    public ExploreDto(String description, String image_url, Timestamp date_time) {
        this.description = description;
        this.image_url = image_url;
        this.date_time = date_time;
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
        return "ExploreDto{" +
                "description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                ", date_time='" + date_time + '\'' +
                '}';
    }
}
