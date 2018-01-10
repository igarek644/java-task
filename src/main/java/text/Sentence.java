package text;

import java.util.List;

public class Sentence extends Word {
    private String value;
    List<Word> wordList;

    public Sentence(String value) {
        this.value = value;
    }

    public Sentence() {

    }

    public Word[] getWords() {
        String[] buffer = value.split("\\s+");
        Word[] words1 = new Word[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = buffer[i].replaceAll("[^\\w]", "");
            words1[i] = new Word(buffer[i]);

        }
        return words1;
    }
    public static Sentence setSentence(Word[] words){
        String buffer = "";
        for (Word word:words){
            buffer += word.getWord() + " ";
        }
        return new Sentence(buffer);
    }
    public Sentence removeWord(Sentence sentence,int index){
        Word [] words = sentence.getWords();
        for (int i = index; i <sentence.getWords().length-1; i++) {
            words[i] = words[i+1];
        }
        System.out.println("comlete + " + index);
        return setSentence(words);


    }
    public int getWordsCount() {
        Word[] words = getWords();
        return words.length;
    }

    public String getValue() {
        return value;
    }


}
