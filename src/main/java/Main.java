import text.Sentence;
import text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Text text = new Text("C:\\Users\\Igor Pravdyvyi\\IdeaProjects\\StringTask\\src\\main\\MyBook.txt");

        List<Sentence> sentenceList = text.tasktwelwth(3);

        for (Sentence sent:sentenceList) {
            System.out.println(sent.getValue());
        }


    }
}
