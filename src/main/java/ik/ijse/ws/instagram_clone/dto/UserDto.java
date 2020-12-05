package ik.ijse.ws.instagram_clone.dto;

public class UserDto {
    private String name;
    private String username;
    private String password;
    private String pro_pic;


    public UserDto() {
    }

    public UserDto(String name, String username, String password, String pro_pic) {
        this.name = name;
        this.username = username;
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

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pro_pic='" + pro_pic + '\'' +
                '}';
    }
}
