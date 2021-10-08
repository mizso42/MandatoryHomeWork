package application.model;

public class Admin extends Moderator{

    public Admin(long id, String userName, String emilAddress, String pwdHash, byte[] pic) {
        super(id, userName, emilAddress, pwdHash, pic);
    }
}
