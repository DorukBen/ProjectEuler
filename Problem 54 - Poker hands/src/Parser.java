import java.io.*;
import java.util.ArrayList;

public class Parser implements Closeable {
    private final BufferedReader mReader;

    Parser(FileReader in) {
        this.mReader = new BufferedReader(in);
    }

    Round getNextRound() throws IOException {
        String nextLine = mReader.readLine();
        String[] cardStrings = nextLine.split(" ");

        ArrayList<Card> cardList = new ArrayList<>();

        for(String cardString : cardStrings) {
            cardList.add(new Card(cardString));
        }

        return new Round(cardList);
    }

    public void close() throws IOException {
        mReader.close();
    }

    boolean hasNext() throws IOException {
        return mReader.ready();
    }
}
