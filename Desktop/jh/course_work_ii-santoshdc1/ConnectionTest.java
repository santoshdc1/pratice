package cw2;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.Statement;

public class ConnectionTest {

            @Test
            public void test(){
                DbConnect db = new DbConnect();
                Statement result =db.connection();
                Assert.assertNotEquals(null,result);
            }




}


