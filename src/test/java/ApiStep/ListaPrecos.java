package ApiStep;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class ListaPrecos {
    public List<ListaPrecos> runAutomation() {
        RestAssured.baseURI = "https://api.tiny.com.br/api2/listas.precos.pesquisa.php";

        // Defina os parâmetros necessários para obter a lista de preços desejada
        Response response = RestAssured.given()
                .param("token", "e4d1bc15eb25c907073f27a37768d2026f007f8e")
                .param("formato", "json")
                .post();

        // Processar a resposta para obter a lista de preços específica
        String listaDePreco = response.getBody().asString();

        // Exemplo: Imprimir a resposta da API
        System.out.println("Resposta da API: " + response.getBody().asString());

        return null;
    }
}
