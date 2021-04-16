package cw2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestGetBooks {


        @Test
        void test() throws SQLException {

            MainApp ltest =new MainApp();
            ResultSet result=ltest.getBookDetail("ii");
            Assert.assertNotEquals(null,result);
        }







}
