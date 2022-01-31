import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class Create {

    static WebDriver browser;
    public static final String browserGet = "http://kitm.epizy.com/filmai.php?i=1";
    public static final String createXpatchName = "//input[@name='pavadinimas']";
    public static final String createXpatchGenre = "//input[@name='zanras']";
    public static final String createXpatchActors = "//input[@name='aktoriai']";
    public static final String createXpatchDirector = "//input[@name='rezisierius']";
    public static final String createXpatchDuration = "//input[@name='trukme']";
    public static final String createXpatchButton = "//button[@name='insert']";
    public static final String trueClass = "msg-good";

    public static void createSetup() {

        // sync webdrivers with selenium code
        System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver97.exe");
        //susikuriame narsykels objekta pagal atitinkamai atsisiustus driverius
        browser = new ChromeDriver();
        // browser url
        browser.get(browserGet);
    }

    public static void createFiller(String name, String genre, String actor, String director, int duration) {
        //Path to filler
        WebElement nameField = browser.findElement(By.xpath(createXpatchName));
        //Sends desired text
        nameField.sendKeys(name);
        //Patch to filler
        WebElement genderField = browser.findElement(By.xpath(createXpatchGenre));
        //Sends desired text
        genderField.sendKeys(genre);
        //Patch to filler
        WebElement actorsField = browser.findElement(By.xpath(createXpatchActors));
        //Sends desired text
        actorsField.sendKeys(actor);
        //Patch to filler
        WebElement directorField = browser.findElement(By.xpath(createXpatchDirector));
        //Sends desired text
        directorField.sendKeys(director);
        //Patch to filler
        WebElement durationField = browser.findElement(By.xpath(createXpatchDuration));
        //Sends desired text
        durationField.sendKeys(Integer.toString(duration));
    }

    public static boolean createButton() {
        //Patch to button "Siusti"
        WebElement button = browser.findElement(By.xpath(createXpatchButton));
        //Clicks on it with javaScript
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].click();", button);
        return createTrueFalse();
    }


    public static boolean createTrueFalse() {
        boolean success;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        try {
            browser.findElement(By.className(trueClass));
            success = true;
        } catch (NoSuchElementException e) {
            success = false;
        }
        return success;
    }

    public static void createBrowserClose() {
        browser.close();
    }

}
