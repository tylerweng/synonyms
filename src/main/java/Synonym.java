import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Synonym {

    String wordA;
    String wordB;

    Synonym(String wordA, String wordB) {
        this.wordA = wordA;
        this.wordB = wordB;
    }
}
