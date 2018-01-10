package text;

public class Word {
    String word;

    public Word(String word) {
        this.word = word;
    }

    Word(String[] word) {

    }

    public Word() {

    }

    public String getWord() {
        return word;
    }

    public int getSize() {
        return this.word.length();
    }

}
