package search;

import base.CommonAPI;
import org.testng.annotations.Test;

public class SeachItem extends CommonAPI {

    @Test
    public void searchItem () {
        typeByCssNEnter("#twotabsearchtextbox","Computers");
        getCurrentPageTitle();
        searchValidate("Amazon.com: Computers");

    }
}
