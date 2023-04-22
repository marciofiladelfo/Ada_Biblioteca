package com.ada.emprestimo.util;

public enum Status {
    EMPRESTADO("Emprestado"),
    DEVOLVIDO("Devolvido");

    private final String status;

    Status(final String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
