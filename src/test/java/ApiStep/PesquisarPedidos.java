package ApiStep;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class PesquisarPedidos {

    public List<Pedidos> runAutomation() {

        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataAtualFormatada = dataAtual.format(formatter);

        RestAssured.baseURI = "https://api.tiny.com.br/api2/pedidos.pesquisa.php";

        // Defina os parâmetros necessários para obter a lista de preços desejada
        Response response = RestAssured.given()
                .param("token", "e4d1bc15eb25c907073f27a37768d2026f007f8e")
                .param("formato", "json")
                .param("status_processamento", "3")
                //.param("situacao", "em_aberto")
                .param("dataInicial", dataAtualFormatada)
                .param("dataFinal", "")
                .get();


        // Processar a resposta da pesquisa de pedidos
        String responseBody = response.getBody().asString();

        // Exemplo: Imprimir a resposta da API
        System.out.println("Resposta da API: " + response.getBody().asString());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, Pedidos.class);
            List<Pedidos> pedidos = objectMapper.readValue(responseBody, collectionType);

            // Agora, você tem a lista de pedidos obtida da resposta JSON da API
            return pedidos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}