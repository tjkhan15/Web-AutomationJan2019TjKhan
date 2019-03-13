package login;

import base.CommonAPI;
import org.testng.annotations.Test;

public class LogIn extends CommonAPI {

    @Test
    public void logInSalesforce() {
        getToURL("https://login.salesforce.com/");
        typeOnInputBox("#username","username","username","Hello, SalesForce!");
        typeOnInputBox("#password","pw","password","1234password");
        clickOnXPath("//*[@id='Login']");
        getErrorMessage("div#error.loginError");

    }
}
