package application.model;

import java.time.LocalDate;

public class Påfyldning {
    private LocalDate dato;
    private Pourable fra;
    private Fad til;

    public Påfyldning(Pourable fra, Fad til, LocalDate dato) {
        this.fra = fra;
        this.til = til;
        this.dato = dato;
    }


}
