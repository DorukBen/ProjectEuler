import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand>{

    private ArrayList<Card> mCards;
    private Rank mRank;

    Hand(ArrayList<Card> cards){
        ArrayList<Card> temp = new ArrayList<>(cards);
        temp.add(new Card(Card.Value.NULL, Card.Suit.NULL));
        Collections.sort(temp);
        mCards = temp;

        mRank = calculateRank();
    }

    @NotNull
    private Rank calculateRank() {
        if(isStraight() && isFlush()) {
            return new Rank(Rank.HandRank.STRAIGHT_FLUSH, mCards.get(4).getValue(), Card.Value.NULL, new ArrayList<>());
        } else if(isFlush()) {
            ArrayList<Card.Value> highestValues = new ArrayList<>();
            highestValues.add(mCards.get(2).getValue());
            highestValues.add(mCards.get(1).getValue());
            highestValues.add(mCards.get(0).getValue());

            return new Rank(Rank.HandRank.FLUSH, mCards.get(3).getValue(), mCards.get(4).getValue(), highestValues);
        } else if(isStraight()) {
            return new Rank(Rank.HandRank.STRAIGHT, mCards.get(4).getValue(), Card.Value.NULL, new ArrayList<>());
        }
        return pairRank();
    }

    @NotNull
    private Rank pairRank() {
        Card.Value v = null;
        int counter = 0;
        int pair = 0, trips = 0, quads = 0;

        Card.Value primary = null;
        Card.Value secondary = null;
        ArrayList<Card.Value> highestValues = new ArrayList<>();

        for(Card c : mCards) {
            Card.Value current = c.getValue();
            if(v != current) {
                switch(counter) {
                    case 2:
                        pair++;
                        if(primary == null) {
                            primary = v;
                        } else if(trips > 0 || primary.compareTo(current) > 0) {
                            secondary = current;
                        } else {
                            secondary = primary;
                            primary = v;
                        }
                        break;
                    case 3:
                        trips++;
                        secondary = primary;
                        primary = v;
                        break;
                    case 4:
                        quads++;
                        primary = v;
                        break;
                    default:
                        if(v != null) highestValues.add(v);
                }
                v = current;
                counter = 1;
            } else {
                counter++;
            }
        }

        if (primary == null){
            primary = Card.Value.NULL;
        }
        if (secondary == null){
            secondary = Card.Value.NULL;
        }

        if(quads > 0) {
            return new Rank(Rank.HandRank.FOUR_OF_A_KIND, primary, secondary, highestValues);
        } else if(trips > 0) {
            if(pair > 0) {
                return new Rank(Rank.HandRank.FULL_HOUSE, primary, secondary, highestValues);
            } else {
                return new Rank(Rank.HandRank.THREE_OF_A_KIND, primary, secondary, highestValues);
            }
        } else if(pair == 2) {
            return new Rank(Rank.HandRank.TWO_PAIR, primary, secondary, highestValues);
        } else if(pair == 1) {
            return new Rank(Rank.HandRank.ONE_PAIR, primary, secondary, highestValues);
        } else {
            return new Rank(Rank.HandRank.HIGH_CARD, primary, secondary, highestValues);
        }
    }

    private boolean isStraight() {
        for(int i = 0; i < 4; i++) {
            if(mCards.get(i).getValue().ordinal() + 1 != mCards.get(i+1).getValue().ordinal()){
                return false;
            }
        }
        return true;
    }

    private boolean isFlush() {
        for(int i = 0; i < 4; i++) {
            if(mCards.get(i).getSuit() != mCards.get(i+1).getSuit()){
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Hand o) {
        return mRank.compareTo(o.mRank);
    }
}
