package com.prestashop.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.prestashop.data.ConfigProperty.URL;

@Log4j
public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Opening browser...");
        open(URL);
        getWebDriver().manage().window().maximize();
        waitUntilFirstPageLoaded();
        switchToBaseFrame();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }

    private void waitUntilFirstPageLoaded() {
        int waitTime = 30;
        SelenideElement loadingMessage = $(byId("loadingMessage"));
        loadingMessage.shouldNotBe(Condition.visible, Duration.ofSeconds(waitTime));
    }

    /**
     * It's method need to switch to the main frame for future automation
     */
    private void switchToBaseFrame() {
        String baseFrameName = "framelive";
        switchTo().frame(baseFrameName);
    }

}
