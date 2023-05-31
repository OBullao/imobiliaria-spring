package br.com.uniamerica.imobiliaria.Entity;

public enum Contrato {

    Venda("Venda"),
    Locação("Locação");
    private String type;

    Contrato(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

