import info.debatty.java.stringsimilarity.*;
import java.text.DecimalFormat;
import java.util.*;

// MyClass tests out the sensitivity of each of the string similarity algorithms
// below to 2 pre-defined strings (i.e. prints % match, sorted in descending order)
public class MyClass {
    public static void main(String args[]) {
        String str1 = "Banke Centrale Asie (BCA)";
        String str2 = "Bank Central Asia (BCA)";

        // format similarity result as percentage value
        DecimalFormat df = new DecimalFormat("#%");

        // arraylist to store all results
        ArrayList<SimilarityResult> results = new ArrayList<>();

        // Jaro-Winkler is a string edit distance that was developed in the area of record linkage (duplicate detection) (Winkler, 1990).
        // The Jaro-Winkler distance metric is designed and best suited for short strings such as person names, and to detect typos.
        JaroWinkler jw = new JaroWinkler();
        results.add(new SimilarityResult("Jaro-Winkler", jw.similarity(str1, str2)));

        // The Levenshtein distance between two words is the minimum number of single-character edits (insertions, deletions or substitutions) required to change one word into the other.
        NormalizedLevenshtein nl = new NormalizedLevenshtein();
        results.add(new SimilarityResult("Normalized Levenshtein", 1-nl.distance(str1, str2)));

        // NGram splits the text into groups of N words each, using "\n", to increase the weightage of first characters
        NGram onegram = new NGram(1);
        results.add(new SimilarityResult("1 Gram", 1-onegram.distance(str1, str2)));

        NGram twogram = new NGram(2);
        results.add(new SimilarityResult("2 Gram", 1-twogram.distance(str1, str2)));

        Cosine cos = new Cosine();
        results.add(new SimilarityResult("Cosine", cos.similarity(str1, str2)));

        SorensenDice sd = new SorensenDice();
        results.add(new SimilarityResult("Sorensen-Dice", sd.similarity(str1, str2)));

        Jaccard jac = new Jaccard();
        results.add(new SimilarityResult("Jaccard", jac.similarity(str1, str2)));

        Collections.sort(results);
        for(SimilarityResult res : results){
            System.out.println(res.getName()+": "+df.format(res.getScore()));
        }
    }

    private static class SimilarityResult implements Comparable<SimilarityResult>{
        private String name;
        private double score; // min:0, max:1

        public SimilarityResult(String name, double score){
            this.name = name;
            this.score = score;
        }

        public String getName(){
            return name;
        }

        public double getScore(){
            return score;
        }

        @Override
        public int compareTo(SimilarityResult another){
            double otherScore = another.getScore();
            if(score == otherScore){
                return 0;
            }else if(score > otherScore){ // want higher score first
                return -1;
            }else{
                return 1;
            }
        }
    }
}
