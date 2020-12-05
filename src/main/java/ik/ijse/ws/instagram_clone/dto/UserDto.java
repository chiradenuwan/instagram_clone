package ik.ijse.ws.instagram_clone.dto;

public class UserDto {
    private String name;
    private String email;
    private String password;
    private String pro_pic;


    public UserDto() {
    }

    public UserDto(String name, String email, String password, String pro_pic) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.pro_pic = pro_pic;
    }

    public String getPro_pic() {
        return pro_pic;
    }

    public void setPro_pic(String pro_pic) {
        this.pro_pic = pro_pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", pro_pic='" + pro_pic + '\'' +
                '}';
    }
}
