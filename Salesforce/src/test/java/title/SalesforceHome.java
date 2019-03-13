package title;

import base.CommonAPI;
import org.testng.annotations.Test;

public class SalesforceHome extends CommonAPI {

    @Test
    public void homePage() {
        getCurrentPageUrl();
        titleValidate("Salesforce.com: The Customer Success Platform To Grow Your Business");
    }
}
