package cn.itcast.timtim.entity;

public class SendCodeEntity {

    private String email;
    private String nickname;
    private String avatar;
    private String sex;
    private String birthday;
    private String phone;
    private String token;

    public SendCodeEntity(String email, String nickname,
                          String avatar, String sex, String birthday,
                          String phone, String token) {
        this.email = email;
        this.nickname = nickname;
        this.avatar = avatar;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



}
