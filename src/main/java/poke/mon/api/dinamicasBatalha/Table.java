package poke.mon.api.dinamicasBatalha;

import lombok.Getter;
import poke.mon.api.model.Pokemon;

import java.util.ArrayList;
@Getter
public class Table {
    private Pokemon cardPlayer1;
    private Pokemon cardPlayer2;
    private boolean isActive;

    public void setCardPlayer1(Pokemon cardPlayer1) {
        this.cardPlayer1 = cardPlayer1;
    }

    public void setCardPlayer2(Pokemon cardPlayer2) {
        this.cardPlayer2 = cardPlayer2;
    }
}
