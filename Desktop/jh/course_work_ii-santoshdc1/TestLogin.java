package cw2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class TestLogin {

    @Test
    void test() {
        JFrame f = new JFrame("Oriental Book House");
        Login ltest =new Login();
        int result=ltest.auth("bipinon","rollon", f);
        Assert.assertEquals(1,result);
    }


}
