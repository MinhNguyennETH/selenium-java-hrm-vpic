package tests;

import base.BaseTest;
import helpers.ExcelHelpers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertiesFile;

public class SigninTest extends BaseTest {
    private LoginPage loginPage;
    private ExcelHelpers excel;

    @BeforeClass
    public void setUp() {
        excel = new ExcelHelpers();
        PropertiesFile.setPropertiesFile();
    }

    @Test
    public void signInPage() throws Exception {

        loginPage = new LoginPage(driver);

        loginPage.login(PropertiesFile.getPropValue("username"),PropertiesFile.getPropValue("password"));

            loginPage.login(excel.getCellData("username", 1), excel.getCellData("password", 1));
            Thread.sleep(3000);

        // Ghi data vao file excel 
        //excel.setCellData("Pass", 1, 2);
    } 
}
