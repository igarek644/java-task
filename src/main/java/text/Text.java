package text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Text extends Sentence {
    private String text;
    List<Sentence> sentenceList;
    List<Word> wordList;

    public Text(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            text = sb.toString();

        } finally {
            br.close();
        }
    }


    public Sentence getSentence(int index) {
        String[] sentences = text.split("(?<=[a-z])\\.\\s+");
        sentences[index] = sentences[index].replace("\n", " ").replace("\r", " ");
        return new Sentence(sentences[index]);
    }


    private int getSentenceCount() {
        return text.split("(?<=[a-z])\\.\\s+").length;
    }

    public ArrayList<Sentence> changeFirstAndLastWord() {
        ArrayList<Sentence> sentenceArrayList = new ArrayList<>();
        for (int i = 0; i < getSentenceCount(); i++) {
            Word[] words = getSentence(i).getWords();
            Word buffer = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = buffer;
            sentenceArrayList.add(setSentence(words));
        }
        return sentenceArrayList;
    }

    private boolean wordIsUnique(Word word) {
        int repeating = 0;
        for (int i = 0; i < getSentenceCount(); i++) {
            Sentence buffer = getSentence(i);
            Word[] words = buffer.getWords();
            for (int j = 0; j < buffer.getWordsCount(); j++) {
                if (word.getWord().toLowerCase().equals(words[j].getWord().toLowerCase())) {
                    repeating++;
                }
            }
        }
        if (repeating == 1) {
            return true;
        } else {
            return false;
        }

    }

    public List<Sentence> tasktwelwth(int size){
        sentenceList = new ArrayList<>();
        for (int i = 0; i < getSentenceCount(); i++) {
            sentenceList.add(getSentence(i));
        }
        for (int i = 0; i <sentenceList.size()-1 ; i++) {
            for (int j = 0; j < sentenceList.get(i).getWords().length ; j++) {
                if(sentenceList.get(i).getWords()[j].getWord().length() == size ) {
                   // System.out.println("in if");
                    sentenceList.add(i, removeWord(sentenceList.get(i), j));
                }

            }
        }
        return sentenceList;
    }
    public Sentence taskSixteen(int index, int size, String substring) {
        Sentence sentence = getSentence(index);
        Word[] words = sentence.getWords();
        for (int i = 0; i < words.length; i++) {
            if (words[i].getWord().length() == size) {
                words[i] = new Word(substring);
            }
        }
        return setSentence(words);
    }

    public Word findWordInFirstSentenceWithoutRepeat() {
        Sentence firstSentence = getSentence(0);
        Word[] words = firstSentence.getWords();
        for (int i = 0; i < words.length; i++) {
            if (wordIsUnique(words[i])) {
                return words[i];
            }
        }

        return new Word("noWord");
    }

    public List<Sentence> sortTextByWordsCount() {
        sentenceList = new ArrayList<>();
        for (int i = 0; i < getSentenceCount(); i++) {
            sentenceList.add(getSentence(i));
        }
        for (int i = 0; i < getSentenceCount() - 1; i++) {
            for (int j = 0; j < getSentenceCount() - 1; j++) {
                if (sentenceList.get(j).getWordsCount() > sentenceList.get(j + 1).getWordsCount()) {

                    Collections.swap(sentenceList, j, j + 1);
                }

            }
        }
        return sentenceList;

    }

    public String setText(Sentence[] sentence) {
        String buffer = "";
        for (Sentence sent : sentence) {
            buffer += sent + ".";
        }
        return buffer;
    }

    public String getText() {
        return text;
    }
}
