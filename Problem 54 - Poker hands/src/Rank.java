import java.util.ArrayList;

public class Rank implements Comparable<Rank>{

    private HandRank mHandRank;
    private ArrayList<Card.Value> mHighestValues;
    private Card.Value mPrimaryValue;
    private Card.Value mSecondaryValue;

    @Override
    public int compareTo(Rank o) {
        if(mHandRank.compareTo(o.mHandRank) != 0){
            return mHandRank.compareTo(o.mHandRank);
        }
        else if(mPrimaryValue.compareTo(o.mPrimaryValue) != 0){
            return mPrimaryValue.compareTo(o.mPrimaryValue);
        }
        else if(mSecondaryValue.compareTo(o.mSecondaryValue) != 0){
            return mSecondaryValue.compareTo(o.mSecondaryValue);
        }
        else {
            for(int i = mHighestValues.size() - 1; i >= 0; i--) {
                if(mHighestValues.get(i).compareTo(o.mHighestValues.get(i)) != 0){
                    return mHighestValues.get(i).compareTo(o.mHighestValues.get(i));
                }
            }
            return 0;
        }
    }

    public enum HandRank {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH;
    }

    Rank(HandRank handRank, Card.Value primaryValue, Card.Value secondaryValue, ArrayList<Card.Value> highestValues){
        mHandRank = handRank;
        mPrimaryValue = primaryValue;
        mSecondaryValue = secondaryValue;
        mHighestValues = highestValues;
    }
}
