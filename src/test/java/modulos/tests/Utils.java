package modulos.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Utils {

    public WebDriver abrirNavegador(WebDriver browser) {
        browser = new ChromeDriver();
        //acessar site abaixo
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        browser.manage().window().maximize();
        browser.get("https://automationexercise.com/login");
        return browser;
    }
}
