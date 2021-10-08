package application.model;

import java.util.List;

public class User {

    private long id;
    private String userName;
    private String emilAddress;
    private String pwdHash;
    private byte[] pic;

    private List<Blog> blogs;
    private List<Comment> comments;

    public User(long id, String userName, String emilAddress, String pwdHash, byte[] pic) {
        this.id = id;
        this.userName = userName;
        this.emilAddress = emilAddress;
        this.pwdHash = pwdHash;
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


}
