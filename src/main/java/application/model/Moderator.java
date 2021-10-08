package application.model;

public class Moderator extends User{

    public Moderator(long id, String userName, String emilAddress, String pwdHash, byte[] pic) {
        super(id, userName, emilAddress, pwdHash, pic);
    }
}
