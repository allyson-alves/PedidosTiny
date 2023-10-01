package ApiStep;

import com.google.gson.annotations.SerializedName;

public class Pedidos {
    @SerializedName("id")
    private String id;

    @SerializedName("valor")
    private double valor;

    public String getId() {
        return id;
    }

    public double getValorOriginal() {
        return valor;
    }

    public void atualizaValor(double valor) {
        this.valor = valor;
    }

    // Outros campos e métodos, se necessário
}
