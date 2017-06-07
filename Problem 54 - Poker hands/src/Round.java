import java.util.ArrayList;

class Round {
    private final Hand mPlayerOne;
    private final Hand mPlayerTwo;

    Round(ArrayList<Card> cardList) {
        ArrayList<Card> firstCards = new ArrayList<>(cardList.subList(0, 5));
        this.mPlayerOne = new Hand(firstCards);
        ArrayList<Card> secondCards = new ArrayList<>(cardList.subList(5, 10));
        this.mPlayerTwo = new Hand(secondCards);
    }

    boolean isPlayerOneWinning() {
        return mPlayerOne.compareTo(mPlayerTwo) > 0;
    }
}
