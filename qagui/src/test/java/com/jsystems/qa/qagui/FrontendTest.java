package com.jsystems.qa.qagui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("FrontTest")
public class FrontendTest extends ConfigFrontend {

    @Test
    public void frontTest() {

        driver.get(Configuration.BASE_URL);

        WebElement textElement_1 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(1)"));
        String text1 = textElement_1.getText();
        assertTrue(text1.equals("WordPress powers"));

        WebElement textElement_2 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(2)"));
        String text2 = textElement_2.getText();
        assertTrue(text2.contains("% of the internet."));
        assertThat(text2).matches("\\d+(% of the internet.)");
    }

    //    skopiowane od Pawła po poprawkach 2:
    @Test
    public void loginTest() {

//        driver.navigate().to("https://www.wordpress.com/");
        driver.navigate().to(Configuration.BASE_URL);

        String loginIconSelector = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in";
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginIconSelector)));

        WebElement loginIcon = driver.findElement(By.cssSelector(loginIconSelector));
        wait.until(ExpectedConditions.elementToBeClickable(loginIcon));

        loginIcon.click();

        String usernameOrEmailSelector = "usernameOrEmail";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameOrEmailSelector)));

        WebElement usernameInput = driver.findElement(By.id(usernameOrEmailSelector));

        usernameInput.clear();
        usernameInput.sendKeys(Configuration.LOGIN);

        String primaryButtonSelector = ".button.form-button.is-primary";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        WebElement usernameButton = driver.findElement(By.cssSelector(primaryButtonSelector));
        usernameButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        WebElement inputPassword = driver.findElement(By.id("password"));

        inputPassword.clear();
        inputPassword.sendKeys(Configuration.PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        WebElement buttonPassword = driver.findElement(By.cssSelector(primaryButtonSelector));
        usernameButton.click();

        String userAvatarSelector = ".masterbar__item.masterbar__item-me";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(userAvatarSelector)));

        WebElement userAvatar = driver.findElement(By.cssSelector(userAvatarSelector));
        userAvatar.click();

        String userDisplayNameSelector = ".profile-gravatar__user-display-name";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userDisplayNameSelector)));

        WebElement userDisplayName = driver.findElement(By.cssSelector(userDisplayNameSelector));
        String userDisplayNameText = userDisplayName.getText();

        assertThat(userDisplayNameText).isEqualTo("testautomation112019");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(primaryButtonSelector)));
        WebElement saveUserDetailsButton = driver.findElement(By.cssSelector(primaryButtonSelector));

        assertTrue(saveUserDetailsButton.isDisplayed());
        assertFalse(saveUserDetailsButton.isEnabled());

//        assertThat(userDisplayName.isDisplayed());
//        assertThat(userDisplayName.isEnabled());
//        assertThat(userDisplayName.isSelected());

    }

}


//    // skopiowane od Pawła po poprawkach:
//    @Test
//    public void loginTest() {
//
//        driver.get("https://www.wordpress.com/");
//
//        WebElement loginIcon = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in"));
//
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.elementToBeClickable(loginIcon));
//
//        loginIcon.click();
//
//        String usernameOrEmailSelector = "usernameOrEmail";
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameOrEmailSelector)));
//
//        WebElement usernameInput = driver.findElement(By.id(usernameOrEmailSelector));
//
//        usernameInput.clear();
//        usernameInput.sendKeys("testautomation112019@wp.pl");
//
//        String primaryButtonSelector = ".button.form-button.is-primary";
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
//        WebElement usernameButton = driver.findElement(By.cssSelector(primaryButtonSelector));
//        usernameButton.click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
//        WebElement inputPassword = driver.findElement(By.id("password"));
//
//        inputPassword.clear();
//        inputPassword.sendKeys("testautomation");
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
//        WebElement buttonPassword = driver.findElement(By.cssSelector(primaryButtonSelector));
//        usernameButton.click();
//
//        String userAvatarSelector = ".masterbar__item.masterbar__item-me";
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(userAvatarSelector)));
//
//        WebElement userAvatar = driver.findElement(By.cssSelector(userAvatarSelector));
//        userAvatar.click();
//
//        String userDisplayNameSelector = ".profile-gravatar__user-display-name";
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userDisplayNameSelector)));
//
//        WebElement userDisplayName = driver.findElement(By.cssSelector(userDisplayNameSelector));
//        String userDisplayNameText = userDisplayName.getText();
//
//        assertThat(userDisplayNameText).isEqualTo("testautomation112019");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(primaryButtonSelector)));
//        WebElement saveUserDetailsButton = driver.findElement(By.cssSelector(primaryButtonSelector));
//        assertThat(!saveUserDetailsButton.isDisplayed());
//    }

//    @Test
//    public void loginTest() {
//        driver.get("https://www.wordpress.com/");
////        WebElement login = driver.findElement(By.cssSelector(".x-menu-grid.x-menu-grid--logged-out a[title=\"Log In\"]"));
//        WebElement login = driver.findElement(By.xpath("//*[@id=\"lpc-header-nav\"]/div/div/div[1]/header/nav/ul[2]/li[1]/a"));
//        try {
//            sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        assertTrue(login.isDisplayed());
//        login.click();
//
//        try {
//            sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        WebElement login2 = driver.findElement(By.id("usernameOrEmail"));
//        WebElement button = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div[1]/div/form/div[1]/div[2]/button"));
//
//        try {
//            sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        login2.sendKeys("testautomation112019@wp.pl");
//        button.click();
//
//    }

