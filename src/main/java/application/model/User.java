package application.model;

import java.util.List;

public class User {

    private long id;
    private String userName;
    private String emilAddress;
    private String pwdHash;
    private byte[] pic = new byte[] {};

    private List<Blog> blogs;
    private List<Comment> comments;

    public User() {
        id = 0;
        userName = "dummy";
    }

    public User(int negative) {
        id = negative;
        switch (negative) {
            case -1 -> userName = "No such user!";
            case -2 -> userName = "Wrong password!";
        }
    }

    protected User (User user) {
        this.id = user.id;
        this.userName = user.userName;
        this.emilAddress = user.emilAddress;
        this.pwdHash = user.pwdHash;
        this.pic = user.pic;
        this.blogs = user.blogs;
        this.comments = user.comments;
    }

    public User(long id, String userName, String emilAddress, String pwdHash) {
        this.id = id;
        this.userName = userName;
        this.emilAddress = emilAddress;
        this.pwdHash = pwdHash;
    }

    public User(long id, String userName, String emilAddress, String pwdHash, byte[] pic) {
        this(id, userName, emilAddress, pwdHash);
        this.pic = pic;
    }

    public String getUserName() {
        return userName;
    }

    protected String getEmilAddress() {
        return emilAddress;
    }

    public byte[] getPic() {
        return pic;
    }

    protected void setUserName(String userName) {
        this.userName = userName;
    }

    private void setEmilAddress(String emilAddress) {
        this.emilAddress = emilAddress;
    }

    private void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }

    protected void setPic(byte[] pic) {
        this.pic = pic;
    }


    public long getId() {
        return id;
    }
}
