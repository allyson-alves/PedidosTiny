package WebAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Pedidos {

    WebDriver driver;
    public static <ClickElementWithJavaScript> void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tiny.com.br");

        // Clica no Login da página Tiny
        driver.findElement(By.id("logging-btn")).click();

        // Aguarda o carregamento durante 10 segundos
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Insere e-mail / senha e clica em ENTER para acessar a página
        driver.findElement(By.name("username")).sendKeys("equipe2@filmepvc");
        driver.findElement(By.name("senha")).sendKeys("C4r4lh00", Keys.ENTER);

        // Aguarda o carregamento durante 10 segundos
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Se o modal "Este usuário já está logado em outra máquina" for exibido
        boolean modalExibido = true;
        try {
            WebElement modalElement = driver.findElement(By.xpath("//div[contains(@class,'modal-dialog modal-md')]"));
            if (modalElement.isDisplayed()) modalExibido = false;
            else modalExibido = true;
        } catch (Exception e) {
            // O elemento do modal não foi encontrado, então o modal Exibido permanecerá como false
        }

        if (modalExibido) {
            System.out.println("Modal foi exibido.");

            // Realizar ações dentro do modal, como clicar no botão "Continuar"
            driver.findElement(By.xpath("//button[contains(.,'Continuar')]")).click();

            // Coloque aqui as ações adicionais que você deseja executar após clicar no botão "Continuar" dentro do modal
        } else {
            System.out.println("Modal não foi exibido.");
            // Coloque aqui as ações que você quer executar se o modal não estiver sendo exibido
        }

        // Clica no Menu Hamburguer
        driver.findElement(By.xpath("//div[@class='btn-sidebar-menu']")).click();

        // Clica na opção "Vendas"
        driver.findElement(By.xpath("//span[contains(.,'Vendas')]")).click();

        // Clica na opção "Pedidos no e-commerce"
        driver.findElement(By.xpath("//a[@original-title='Pedidos no e-commerce']")).click();

        // Aguarda o carregamento durante 15 segundos
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        // seleciona todos os pedidos pelo checkbox
        driver.findElement(By.cssSelector(".checkbox-datatable > .comp-placeholder")).click();

        // clica em "Receber pedidos"
        WebElement receberPedidos = driver.findElement(By.xpath("//button[contains(.,'Receber pedidos *')]"));
        receberPedidos.click();



        // Coletar informações relevantes dos pedidos da automação web
        String pedidoInfo = ""; // Exemplo: ID do pedido, preço, etc.

        // Configurar a automação de API (RestAssured)
        RestAssured.baseURI = "https://api.tiny.com.br/api2/pedidos.pesquisa.php";

        // Criar uma solicitação de API (exemplo: atualizar informações em massa)
        RequestSpecification request = RestAssured.given();

        // Adicionar parâmetros à solicitação de API
        request.param("token", "e4d1bc15eb25c907073f27a37768d2026f007f8e");
        request.param("dataInicial", "30/09/2023");
        request.param("formato", "json");

        // Configurar a solicitação de API (exemplo: adicionar cabeçalhos, corpo da solicitação, etc.)

        // Executar a solicitação de API e obter a resposta
        Response response = request.post("/endpoint_da_sua_API");
        // Tratar a resposta da API conforme necessário

        // Exemplo: Imprimir a resposta da API
        System.out.println("Resposta da API: " + response.getBody().asString());

        // Fechar o WebDriver
        driver.quit();
    }
}