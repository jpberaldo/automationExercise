package modulos.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import paginas.HomePage;
import service.ServiceTest;

public class HomeTest {

    private final String CHROME_EXECUTAVEL = "webdriver.chrome.driver";
    private final String CAMINHO_CHROME_PATH = "C:\\drivers\\chromedriver.exe";
    private WebDriver browser;

    @BeforeEach
    @DisplayName("Executa toda vez antes de cada teste")
    public void beforeEach() {
        System.setProperty(CHROME_EXECUTAVEL, CAMINHO_CHROME_PATH);
        ServiceTest util = new ServiceTest();
        this.browser = util.abrirNavegador(browser, "https://automationexercise.com/");

    }

    @Test
    @DisplayName("Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void verificarScrollUpUtilizandoOBotaoSeta() {

        new HomePage(browser)
                .rolarPaginaParaBaixo("7500")
                .scrollUp();

        WebElement elemento = browser.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']"));
        String actual = elemento.getText();
        String expected = "Full-Fledged practice website for Automation Engineers";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    public void verificarScrollDownUtilizandoOBotaoSeta() {

        new HomePage(browser)
                .rolarPaginaParaBaixo("7500")
                .rolarPaginaParaBaixo("-7500");

        WebElement elemento = browser.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']"));
        String actual = elemento.getText();
        String expected = "Full-Fledged practice website for Automation Engineers";
        Assertions.assertEquals(expected, actual);

    }

    @AfterEach
    @DisplayName("Executa toda vez, depois cada teste")
    public void afterEach() {
        browser.close();
    }

}
