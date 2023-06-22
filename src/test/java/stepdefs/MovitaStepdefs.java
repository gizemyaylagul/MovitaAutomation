package stepdefs;


import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.Mov_10;
import pageObjects.Move_12;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static pageObjects.Mov_10.lRaporlarMenu;
import static pageObjects.Mov_10.lVerifyMap;

public class MovitaStepdefs extends BaseMovita {

    @Given("users navigate to {string}")
    public void usersNavigateTo(String url) {
        driver.get(url);
    }

    @When("users clicked the movita logo")
    public void usersClickedTheMovitaLogo() {
        click(llogo);
    }

    @And("Mobile Vehicle Tracking System shoould be visible")
    public void mobileVehicleTrackingSystemShoouldBeVisible() {
        visible(lMobilVasıtaTurkish);
    }

    @Then("should be success")
    public void shouldBeSuccess() {
        getScreenshot("Mobil Vasıta");
    }

    @And("user clicks the english language button")
    public void userClicksTheEnglishLanguageButton() {

        //new Actions(driver).moveToElement(driver.findElement(lEnglishLangNew)).click();

        click(lEnglishLang);
    }

    @And("user String verify English → “Mobile Vehicle Tracking System” yazisini verify et")
    public void userStringVerifyEnglishMobileVehicleTrackingSystemYazisiniVerifyEt() {
        visible(lMobilVasıtaEnglish);
        getScreenshot("Mobile Vehicle Tracking System");
    }
    @Given("user clicks the enter button")
    public void userClicksTheEnterButton() {
        click(lEnterButton);
    }

    @And("user clicks the Turkish language button")
    public void userClicksTheTurkishLanguageButton() {
        click(lTurkishLang);
    }

    @And("user String verify Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et")
    public void userStringVerifyTürkceMobilVasitaIzlemeTakipSistemiYazisiniVerifyEt() {
        visible(lMobilVasıtaTurkish);
    }

    @When("user hover over the homepage title and title color should be changeable")
    public void userHoverOverTheHomepageTitleAndTitleColorShouldBeChangeable() {

        WebElement element = driver.findElement(lAnaSayfa);
        String beforeColor = element.getCssValue("color");
        hoverAll(lAnaSayfa);
        String afterColor = element.getCssValue("color");
        Assert.assertNotEquals(beforeColor, afterColor);
    }

    @And("home title should be clickable")
    public void homeTitleShouldBeClickable() {
        click(lAnaSayfa);
    }

    @When("users hover over on the {string}")
    public void usersHoverOverOnThe(String mainTitle) {
        hoverOver(homePageMenu(mainTitle));
    }

    @And("hover over the  {string}")
    public void hoverOverThe(String subTitle) {
        hoverOver(MainSubtitle(subTitle));
    }

    @And("The user {string} the subTitle")
    public void theUserTheSubTitle(String text) {
        click(MainSubtitle(text));
    }

    @And("The {string} and{string} colours should be change")
    public void theAndColoursShouldBeChange(String mainTitle, String subTitle) {

        changeColor("hoverover","color",homePageMenu(mainTitle));
        changeColor("hoverover","color",MainSubtitle(subTitle));
    }

    @Then("verify the subtitle with {string}")
    public void verifyTheSubtitleWith(String text) {
        visibleVerifyWithSubtitle(text);
    }


}