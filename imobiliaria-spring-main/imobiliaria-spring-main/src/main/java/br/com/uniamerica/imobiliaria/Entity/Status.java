package br.com.uniamerica.imobiliaria.Entity;

public enum Status {

    Venda("Vendido"),
    Listado("Listado"),
    Reservado("Reservado"),
   Alugado("Alugado");
    private String type;

    Status(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
