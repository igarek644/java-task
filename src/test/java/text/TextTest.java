package text;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TextTest {
    Text text;

    @Before()
    public void initialize() {
        try {
            text = new Text("C:\\Users\\Igor Pravdyvyi\\IdeaProjects\\StringTask\\src\\main\\MyBook.txt");

        } catch (IOException e) {

        }
    }

    //task5
    @Test
    public void changeFirstAndLastWord() {
        String str = "software exceptions are defined in NET libraries and are used by the framework while application exceptions are defined by application developers and are used by the application System ";
        ArrayList<Sentence> arrayList = text.changeFirstAndLastWord();
        Assert.assertEquals("application in NET are two types  system and Exceptions ", arrayList.get(0).getValue());
        Assert.assertEquals(str,arrayList.get(1).getValue());
    }

    //task3
    @Test
    public void findWordInFirstSentenceWithoutRepeat() {
        Assert.assertEquals("two", text.findWordInFirstSentenceWithoutRepeat().getWord());
    }

    //task2
    @Test
    public void sortTextByWordsCount() {
        List<Sentence> list = text.sortTextByWordsCount();
        Assert.assertEquals(4, list.get(0).getWords().length);
        Assert.assertEquals(5, list.get(1).getWords().length);
        Assert.assertEquals(10, list.get(2).getWords().length);
        Assert.assertEquals(10, list.get(3).getWords().length);
        Assert.assertEquals(10, list.get(4).getWords().length);
        Assert.assertEquals(12, list.get(5).getWords().length);

    }
    //task12
    @Test
    public void task12(){

    }
    //task16
    @Test
    public void task16() {
        String string = "System exceptions substr defined in substr libraries substr substr used by substr framework while application exceptions substr defined by application developers substr substr used by substr application software ";
        Assert.assertEquals(string, text.taskSixteen(1,3, "substr").getValue());
    }
}