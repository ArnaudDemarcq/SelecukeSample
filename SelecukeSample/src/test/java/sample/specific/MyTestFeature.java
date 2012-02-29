package sample.specific;

//START:imports
import cuke4duke.annotation.I18n.EN.When;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.krohm.selecuke.generic.cucumber.Env;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.krohm.selecuke.generic.selenium.GenericSeleniumUtil;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.Pending;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//END:imports
@SuppressWarnings({"UnusedDeclaration"})
public class MyTestFeature {
//START:fields

    private static final String testPropName = "cucumber.env.data.path";
    private static final String testUrlPropName = "cucumber.env.homepage.url";
    private static final String propName = "testconf.properties";
    //  private final Properties tmpProp = Env.getProperties(propName);
    private static final Logger logger = LoggerFactory.getLogger(MyTestFeature.class);

    public MyTestFeature() throws IOException {
        logger.info("Initializing Test");
        Env.init();
    }/**/


//END:fields
//START:given
    @When("^I go to Google$")
    public void gotoGoogle() {
        String targetURL = Env.getProperties().getProperty(testUrlPropName);
        logger.info("HomePage is :<" + targetURL + ">");
        RemoteWebDriver browser = GenericSeleniumUtil.getBrowser();
        browser.navigate().to(targetURL);
        logger.info("HomePage Reached");
    }

    @When("^I enter the following query: \"([^\"]*)\"$")
    public void enterRequest(String queryString) throws InterruptedException {
        RemoteWebDriver browser = GenericSeleniumUtil.getBrowser();
        WebElement queryElement = browser.findElement(By.id("sb_form_q"));
        queryElement.sendKeys(queryString);
        WebElement validationElement = browser.findElement(By.id("sb_form_go"));
        validationElement.sendKeys("\n");

        logger.error("DAS IS QUERY ! " + queryString);
    }

    @When("^I click the first link$")
    public void clickFirstLink() throws InterruptedException {
        RemoteWebDriver browser = GenericSeleniumUtil.getBrowser();
        WebElement resultsElement = browser.findElement(By.id("results"));
        resultsElement.findElements(By.tagName("li"));
        WebElement firstLink = resultsElement.findElements(By.tagName("li")).get(0).findElement(By.tagName("a"));
        String firstLinkText = firstLink.getText();
        firstLink.click();
        logger.info("The first link has been clicked :" + firstLinkText);
    }

    @Then("I enjoy the show for \"([1-9]*)\" seconds$")
    public void iEnjoyTheShow(String sleepTime) throws InterruptedException {
        Thread.sleep(Long.parseLong(sleepTime) * 1000);
    }

    @Then("^I enjoy the show for \"([^\"]*)\" seconds$")
    public void iEnjoyTheShowFor30Seconds(String sleepTime) throws InterruptedException {
        logger.error("dude, you suck");
        Thread.sleep(Long.parseLong(sleepTime) * 1000);
    }

    @Then("^I wait the show for 30 seconds$")
    public void sleep() throws InterruptedException {
        Thread.sleep(30 * 1000);
    }

    @When("^I log in$")
    public void iLogIn() {
        String targetURL = Env.getProperties().getProperty(testUrlPropName);
        logger.error("WE ARE TRYING, BABY !" + targetURL);
        //String targetURL = Env.getProperties().getProperty(testUrlPropName);
        RemoteWebDriver browser = GenericSeleniumUtil.getBrowser();
        browser.navigate().to(targetURL);
        logger.error("WE ARE LOGGED IN, BABY !");
    }

    @When("^I log in with id \"([^\"]*)\" and password \"([^\"]*)\" $")
    public void iLogInWithParams(String login, String password) {
        String targetURL = Env.getProperties().getProperty(testUrlPropName);
        RemoteWebDriver browser = GenericSeleniumUtil.getBrowser();
        browser.navigate().to(targetURL);
        logger.error("WE ARE LOGGED IN, BABY !");
    }

    @When("^I click Menu item identified by \"([^\"]*)\" and \"([^\"]*)\"$")
    public void clickMenuItem(String menuKey, String subMenuKey) throws InterruptedException {
    }

    @When("^I am Testing ([A-z]*)$")
    public void iAmTesting(String action) throws FileNotFoundException, IOException, InterruptedException {


        logger.error("WE ARE IN THE FULL APP PAGE, BABY !");

    }

    @Then("^I verify field with critId ([1-9]*) from file ([A-z]*) label \"([^\"]*)\"$")
    public void iVerifyOneField(String critId, String fileName, String lineLabel) throws FileNotFoundException, IOException {

        logger.error("We are in the VerifyStep");
    }

    @Then("^I verify select with critId ([1-9]*) from file ([A-z]*) label \"([^\"]*)\"$")
    public void iVerifyOneSelect(String critId, String fileName, String lineLabel) throws FileNotFoundException, IOException {
        logger.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        logger.error("We are in the VerifyStep");
    }

    private static final void assertFieldValue(String expected, String actual) {
        if (expected == null || "".equals(expected)) {
            return;
        }
        Assert.assertEquals(expected, actual);
    }
}
