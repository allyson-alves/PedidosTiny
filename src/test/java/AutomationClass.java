import ApiStep.ListaPrecos;
import ApiStep.Pedidos;
import ApiStep.PesquisarPedidos;
import WebStep.ReceberPedidos;

import java.util.List;

public class AutomationClass {
    public static <ListaPreco> void main(String[] args) {
        // Criar instâncias das classes de automação web
        ReceberPedidos webAutomation1 = new ReceberPedidos();

        // Executar as automações web
        webAutomation1.runAutomation();

        // Criar instâncias das classes de automação de API
        PesquisarPedidos apiAutomation1 = new PesquisarPedidos();
        ListaPrecos apiAutomation2 = new ListaPrecos();

        // Executar as automações de API
        List<Pedidos> pedidos = apiAutomation1.runAutomation();
        //List<ListaPrecos> listasPrecos = apiAutomation2.runAutomation();

        // Agora, você pode aplicar as atualizações de preços aos pedidos com base nas listas de preços
        double descontoListaPrecos = -35; // Obtém o desconto da lista de preços

        for (Pedidos pedido : pedidos) {
            double novoValor = pedido.getValorOriginal() * (1 + (descontoListaPrecos / 100.0));
            pedido.atualizaValor(novoValor);
        }

        // Opcionalmente, você pode salvar ou enviar os pedidos atualizados para algum destino.

        // Exemplo: Imprimir os pedidos atualizados
        for (Pedidos pedido : pedidos) {
            System.out.println("ID do Pedido: " + pedido.getId());
            System.out.println("Novo Valor: " + pedido.getValorOriginal());
        }
    }
}



//import ApiStep.Pedidos;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import com.google.gson.Gson;
//
//public class AutomationClass {
//    public static void main(String[] args) {
//        try {
//            // Criar um cliente HTTP
//            HttpClient httpClient = HttpClients.createDefault();
//
//            // Criar uma solicitação GET para a URL da API
//            HttpGet httpGet = new HttpGet("https://api.example.com/seu-endpoint-de-pedidos");
//
//            // Enviar a solicitação e obter a resposta
//            HttpResponse response = httpClient.execute(httpGet);
//
//            // Verificar o código de resposta (200 significa sucesso)
//            if (response.getStatusLine().getStatusCode() == 200) {
//                // Obter a resposta da API como uma string
//                String responseBody = EntityUtils.toString(response.getEntity());
//
//                // Processar o JSON usando o Gson
//                Gson gson = new Gson();
//                Pedidos[] pedidos = gson.fromJson(responseBody, Pedidos[].class);
//
//                // Iterar sobre os pedidos e atualizar os valores
//                for (Pedidos pedido : pedidos) {
//                    pedido.atualizaValor(pedido.getValorOriginal() * 0.65); // Atualize o valor para valor * 0.65
//                }
//
//                // Agora, você pode usar os pedidos atualizados conforme necessário em sua automação
//                for (Pedidos pedido : pedidos) {
//                    System.out.println("ID: " + pedido.getId() + ", Novo Valor: " + pedido.getValorOriginal());
//                }
//            } else {
//                System.out.println("Erro na solicitação à API. Código de resposta: " + response.getStatusLine().getStatusCode());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}