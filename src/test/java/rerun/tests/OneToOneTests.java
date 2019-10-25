package rerun.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OneToOneTests {

    @Test
    public void OneToOneTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void OneToOneFalse() {
        Assert.assertTrue(false);
    }

}
