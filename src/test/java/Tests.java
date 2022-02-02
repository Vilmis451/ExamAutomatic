import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
    int idField;
    String nameField;
    String genreField;
    String actorField;
    String directorField;
    int durationField;

    @BeforeMethod(onlyForGroups = "createMovie")
    public void createSetup() {
        nameField = "VilhelmoFilmas";
        genreField = "Cool";
        actorField = "Vilhelmas";
        directorField = "Vilhelmas";
        durationField = 421;
        Create.createSetup();
    }

    @BeforeMethod(onlyForGroups = "deleteMovie")
    public void deleteSetup() {
        idField = 15; //Change to id you want to delete
        nameField = "VilhelmoFilmas";
        genreField = "Cool";
        actorField = "Vilhelmas";
        directorField = "Vilhelmas";
        durationField = 421;
        Delete.deleteSetup();
    }

    @BeforeMethod(onlyForGroups = "editMovie")
    public void editSetup() {
        idField = 5; //Change to id you want to edit
        nameField = "VilhelmoFilmas";
        genreField = "Cool";
        actorField = "Vilhelmas";
        directorField = "Vilhelmas";
        durationField = 421;
        Edit.editSetup();
    }

    @AfterMethod(onlyForGroups = "deleteMovie")
    public void deleteClose() {
        Delete.deleteBrowserClose();
    }

    @AfterMethod(onlyForGroups = "createMovie")
    public void createClose() {
        Create.createBrowserClose();
    }

    @AfterMethod(onlyForGroups = "editMovie")
    public void editClose() {
        Edit.editBrowserClose();
    }

    @Test(priority = 1, groups = "createMovie")
    public void positiveTest() {
        Create.createFiller(nameField, genreField, actorField, directorField, durationField);
        Assert.assertEquals(Create.createButton(), true);
    }

    @Test(priority = 0, groups = "createMovie")
    public void negativeTest() {
        genreField = "co";
        Create.createFiller(nameField, genreField, actorField, directorField, durationField);
        Assert.assertNotEquals(Create.createButton(), false);
    }

    @Test(priority = 2, groups = "deleteMovie")
    public void positiveDeleteTest() {
        Delete.deleteFiller(idField, nameField, genreField, actorField, directorField, durationField);
        Assert.assertEquals(Delete.deleteButton(), true);
    }

    @Test(priority = 3, groups = "deleteMovie")
    public void negativeDeleteTest() {
        genreField = "co";
        Delete.deleteFiller(idField, nameField, genreField, actorField, directorField, durationField);
        Assert.assertNotEquals(Delete.deleteButton(), false);
    }

    @Test(priority = 5, groups = "editMovie")
    public void positiveEditTest() {
        Edit.editFiller(idField, nameField, genreField, actorField, directorField, durationField);
        Assert.assertEquals(Edit.editButton(), true);
    }

    @Test(priority = 4, groups = "editMovie")
    public void negativeEditTest() {
        genreField = "co";
        Edit.editFiller(idField, nameField, genreField, actorField, directorField, durationField);
        Assert.assertNotEquals(Edit.editButton(), false);
    }
}
