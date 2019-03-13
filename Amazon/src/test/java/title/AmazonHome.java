package title;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

public class AmazonHome extends CommonAPI {

    @Test
    public void homePage() {
        getCurrentPageUrl();
        titleValidate("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }
}
