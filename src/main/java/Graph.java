import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Graph {

    Map<String, GraphNode> nodes = new HashMap<>();

    void addSynonym(Synonym synonym) {
        String wordA = synonym.getWordA();
        String wordB = synonym.getWordB();
        GraphNode nodeA = (nodes.containsKey(wordA) ? nodes.get(wordA) : new GraphNode(wordA));
        GraphNode nodeB = (nodes.containsKey(wordB) ? nodes.get(wordB) : new GraphNode(wordB));
        nodes.put(wordA, nodeA);
        nodes.put(wordB, nodeB);
        nodeA.addSynonymNode(nodeB);
        nodeB.addSynonymNode(nodeA);
    }
}
