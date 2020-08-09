package tech.fertavora.pageobjects;

public interface IPage {

    /**
     * Makes sure the page object is in the expected state
     * @return BasePage the page object that is ready
     */
    BasePage isReady();

    /**
     * Loads the page object by going to its URL
     * @return BasePage the page object loaded
     */
    BasePage goToPage();
}
