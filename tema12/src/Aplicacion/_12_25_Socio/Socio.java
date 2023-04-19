package Aplicacion._12_25_Socio;

import java.io.Serializable;
import java.time.LocalDate;

public class Socio implements Serializable {

    private final String nickname;
    private String name;
    private LocalDate date;

    public Socio(String nickname, String name, LocalDate date) {
        this.nickname = nickname;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Nickname: " +nickname+ ", name: " +name+ ", admission date: " +date;
    }
    public String getNickname() {
        return nickname;
    }
    public LocalDate getDate() {
        return date;
    }
}

