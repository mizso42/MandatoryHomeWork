package application.database;

import application.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.print.MultiDocPrintService;

import static org.junit.jupiter.api.Assertions.*;

class DBEngineTest {

    @Test
    public void authTest_noSuchUser() {
        DBEngine engine = new DBEngine();
        User expected = new User(-1);
        User actual = engine.auth("mizso", "pwd");
        Assertions.assertEquals(expected.getUserName(), actual.getUserName());
    }

    @Test
    public void createDBTest() {
        DBEngine engine = new DBEngine();
    }
}