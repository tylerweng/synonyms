public class Main {

    public static boolean areSynonyms(String s1, String s2, Synonym[] synonyms) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        if (words1.length != words2.length) return false;
        Graph graph = new Graph();
        for (Synonym synonym : synonyms) {
            graph.addSynonym(synonym);
        }
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            if (!w1.equals(w2)) {
                if (!graph.nodes.containsKey(w1) || ! graph.nodes.containsKey(w2)) return false;
                GraphNode node1 = graph.nodes.get(w1);
                if (!node1.isSynonymOfString(w2)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Synonym diner1 = new Synonym("rest", "diner");
        Synonym diner2 = new Synonym("diner", "mcd");
        Synonym[] synonyms = { diner1, diner2 };
        String s1 = "I ate at mcd";
        String s2 = "I ate at rest";
        String s3 = "I ate at god";
        System.out.println(areSynonyms(s1, s2, synonyms));
        System.out.println(!areSynonyms(s1, s3, synonyms));

    }
}
