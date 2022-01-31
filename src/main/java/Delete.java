import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class Delete {

    static WebDriver browser;
    public static final String browserGet = "http://kitm.epizy.com/filmai.php?i=1";
    public static final String deleteXpatchId = "/html/body/div[1]/form/input[1]";
    public static final String deleteXpatchName = "//input[@name='pavadinimas']";
    public static final String deleteXpatchGenre = "//input[@name='zanras']";
    public static final String deleteXpatchActors = "//input[@name='aktoriai']";
    public static final String deleteXpatchDirector = "//input[@name='rezisierius']";
    public static final String deleteXpatchDuration = "//input[@name='trukme']";
    public static final String deleteXpatchButton = "//button[@name='delete']";
    public static final String trueClass = "msg-good";

    public static void deleteSetup() {

        // sync webdrivers with selenium code
        System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver97.exe");
        //susikuriame narsykels objekta pagal atitinkamai atsisiustus driverius
        browser = new ChromeDriver();
        // browser url
        browser.get(browserGet);
    }

    public static void deleteFiller(int id, String name, String genre, String actor, String director, int duration) {
        //Path to filler
        WebElement idField = browser.findElement(By.xpath(deleteXpatchId));
        idField.sendKeys(Integer.toString(id));
        //Path to filler
        WebElement nameField = browser.findElement(By.xpath(deleteXpatchName));
        //Sends desired text
        nameField.sendKeys(name);
        //Patch to filler
        WebElement genderField = browser.findElement(By.xpath(deleteXpatchGenre));
        //Sends desired text
        genderField.sendKeys(genre);
        //Patch to filler
        WebElement actorsField = browser.findElement(By.xpath(deleteXpatchActors));
        //Sends desired text
        actorsField.sendKeys(actor);
        //Patch to filler
        WebElement directorField = browser.findElement(By.xpath(deleteXpatchDirector));
        //Sends desired text
        directorField.sendKeys(director);
        //Patch to filler
        WebElement durationField = browser.findElement(By.xpath(deleteXpatchDuration));
        //Sends desired text
        durationField.sendKeys(Integer.toString(duration));
    }

    public static boolean deleteButton() {
        //Patch to button "Trinti"
        WebElement button = browser.findElement(By.xpath(deleteXpatchButton));
        //Clicks on it with javaScript
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].click();", button);
        return deleteTrueFalse();
    }

    public static boolean deleteTrueFalse() {
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

    public static void deleteBrowserClose() {
        browser.close();
    }
}
