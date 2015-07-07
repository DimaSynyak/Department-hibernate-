package ua.synyak.dima.project2.department;

import javax.persistence.Embeddable;

/**
 * Created by root on 7/6/15.
 */
@Embeddable
public class Card {

    private long cardNum;

    public long getCardNum() {
        return cardNum;
    }

    public void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }
}
