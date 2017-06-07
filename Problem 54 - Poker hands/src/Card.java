public class Card implements Comparable<Card> {

    private static final int VALUE_INDEX = 0;
    private static final int SUIT_INDEX = 1;

    public enum Suit {
        HEART('H'),
        DIAMOND('D'),
        SPADE('S'),
        CLUB('C'),
        NULL('0');

        private final char suitChar;

        Suit(char cardString) {
            this.suitChar = cardString;
        }

        public char getChar() {
            return suitChar;
        }

        public static Suit getSuit(char value) {
            int index = -1;
            for (int i = 0; i < Suit.values().length; i++){
                if (value == Suit.values()[i].getChar()){
                    index = i;
                }
            }
            if(index < 0) return NULL;
            return Suit.values()[index];
        }
    }

    public enum Value {
        TWO ('2'),
        THREE ('3'),
        FOUR ('4'),
        FIVE ('5'),
        SIX ('6'),
        SEVEN ('7'),
        EIGHT ('8'),
        NINE ('9'),
        TEN ('T'),
        JACK ('J'),
        QUEEN ('Q'),
        KING ('K'),
        ACE ('A'),
        NULL ('0');

        private final char valueChar;

        Value(char cardString) {
            this.valueChar = cardString;
        }

        public char getChar() {
            return valueChar;
        }

        public static Value getValue(char value) {
            int index = -1;
            for (int i = 0; i < Value.values().length; i++){
                if (value == Value.values()[i].getChar()){
                    index = i;
                }
            }
            if(index < 0) return NULL;
            return Value.values()[index];
        }
    }

    private final Value mValue;
    private final Suit mSuit;

    Card(String s) {
        this(Value.getValue(s.charAt(VALUE_INDEX)), Suit.getSuit(s.charAt(SUIT_INDEX)));
    }

    Card(Value value, Suit suit) {
        this.mValue = value;
        this.mSuit = suit;
    }

    Value getValue() {
        return mValue;
    }

    Suit getSuit() {
        return mSuit;
    }

    @Override
    public int compareTo(Card o) {
        return mValue.compareTo(o.mValue);
    }

    @Override
    public String toString() {
        return String.format("Value: %s  Suit: %s", mValue.getChar(), mSuit.getChar());
    }
}
