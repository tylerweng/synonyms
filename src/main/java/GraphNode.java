import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
public class GraphNode {

    String word;
    Set<GraphNode> synonyms;

    GraphNode(String word) {
        this.word = word;
        this.synonyms = new HashSet<>();
    }

    void addSynonymNode(GraphNode synonym) {
        this.synonyms.add(synonym);
    }

    boolean isSynonymOfString(String targetWord) {
        Set<String> seen = new HashSet<>();
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.addAll(synonyms);
        while (!queue.isEmpty()) {
            GraphNode node = queue.pop();
            String otherWord = node.getWord();
            seen.add(otherWord);
            if (otherWord.equals(targetWord)) return true;
            for (GraphNode adjNode : node.getSynonyms()) {
                if (!seen.contains(adjNode.getWord())) queue.add(adjNode);
            }
        }
        return false;
    }

}
