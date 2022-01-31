import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class Edit {

    static WebDriver browser;
    public static final String browserGet = "http://kitm.epizy.com/filmai.php?i=1";
    public static final String editXpatchId = "/html/body/div[1]/form/input[1]";
    public static final String editXpatchName = "//input[@name='pavadinimas']";
    public static final String editXpatchGenre = "//input[@name='zanras']";
    public static final String editXpatchActors = "//input[@name='aktoriai']";
    public static final String editXpatchDirector = "//input[@name='rezisierius']";
    public static final String editXpatchDuration = "//input[@name='trukme']";
    public static final String editXpatchButton = "//button[@name='update']";
    public static final String trueClass = "msg-good";

    public static void editSetup() {

        // sync webdrivers with selenium code
        System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver97.exe");
        //susikuriame narsykels objekta pagal atitinkamai atsisiustus driverius
        browser = new ChromeDriver();
        // browser url
        browser.get(browserGet);
    }

    public static void editFiller(int id, String name, String genre, String actor, String director, int duration) {
        //Path to filler
        WebElement idField = browser.findElement(By.xpath(editXpatchId));
        idField.sendKeys(Integer.toString(id));
        //Path to filler
        WebElement nameField = browser.findElement(By.xpath(editXpatchName));
        //Sends desired text
        nameField.sendKeys(name);
        //Patch to filler
        WebElement genderField = browser.findElement(By.xpath(editXpatchGenre));
        //Sends desired text
        genderField.sendKeys(genre);
        //Patch to filler
        WebElement actorsField = browser.findElement(By.xpath(editXpatchActors));
        //Sends desired text
        actorsField.sendKeys(actor);
        //Patch to filler
        WebElement directorField = browser.findElement(By.xpath(editXpatchDirector));
        //Sends desired text
        directorField.sendKeys(director);
        //Patch to filler
        WebElement durationField = browser.findElement(By.xpath(editXpatchDuration));
        //Sends desired text
        durationField.sendKeys(Integer.toString(duration));
    }

    public static boolean editButton() {
        //Patch to button "Trinti"
        WebElement button = browser.findElement(By.xpath(editXpatchButton));
        //Clicks on it with javaScript
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].click();", button);
        return editTrueFalse();
    }

    public static boolean editTrueFalse() {
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

    public static void editBrowserClose() {
        browser.close();
    }
}
