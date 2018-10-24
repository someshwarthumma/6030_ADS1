import java.util.Scanner;
/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * Solution constructor
     */
    private Solution() {
        //Solution constructor
    }
    /**.
     * main method to handle the input testcases
     * Complexity is O(N) as we read the all inputs
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        int noOfWordsInMag = Integer.parseInt(tokens[0]);
        int noOfWordsInRansom = Integer.parseInt(tokens[1]);
        String[] magWords = scan.nextLine().split(" ");
        String[] ransomWords = scan.nextLine().split(" ");
        RansomNote ransomNote = new RansomNote(
            noOfWordsInMag, noOfWordsInRansom,
            magWords, ransomWords);
        System.out.println(ransomNote.isReplicaPossible());
    }
}
/**.
 * class to check weather replica is possible or not
 */
class RansomNote {
    /**.
     * variable for no of words in magazine
     */
    private int magNum;
    /**.
     * variable for no of words in ramson note
     */
    private int ransomNum;
    /**.
     * String array for storing the mag words
     */
    private String[] magWords;
    /**.
     * String array for storing the ransom words
     */
    private String[] ransomWords;
    /**.
     * hash table for mag words
     */
    private SeparateChainingHashST<String , Integer> hashMag;
    /**.
     * hashtable for ransom words
     */
    private SeparateChainingHashST<String , Integer> hashRansom;
    /**.
     * constructor for ramsonNote
     *
     * @param      m     { mag words count }
     * @param      r     { ransom words count }
     * @param      mW    mag words as Array
     * @param      rW    ransom words as Array
     */
    RansomNote(final int m, final int r,
        final String[] mW, final String[] rW) {
        this.magNum = m;
        this.ransomNum = r;
        this.magWords = mW;
        this.ransomWords = rW;
        hashMag = new SeparateChainingHashST<String, Integer>();
        hashRansom = new SeparateChainingHashST<String, Integer>();
    }
    /**.
     * method to load the words into the hashtable
     * Complexity is O(N) as it iterate all over the array
     *
     * @param      arr   of Type array
     * @param      hash  of type hashtable
     */
    public void loadWords(final String[] arr,
        final SeparateChainingHashST<String , Integer> hash) {
        for (String word : arr) {
            if (hash.contains(word)) {
                int count = hash.get(word);
                count++;
                hash.put(word, count);
            } else {
                hash.put(word, 1);
            }
        }
    }
    /**.
     * method to determine whether replica is possible or not
     * Complexity is O(N) as it iterate all over the table
     *
     * @return     True if replica possible, False otherwise.
     */
    public String isReplicaPossible() {
        loadWords(magWords, hashMag);
        loadWords(ransomWords, hashRansom);
        /*for(String one: magWords){
            if(hashMag.contains(one)){
                int count = hashMag.get(one);
                count++;
                hashMag.put(one, count);
            } else {
                hashMag.put(one, 1);
            }
        }*/
        /*for(String two: ransomWords){
            if(hashRansom.contains(two)){
                int count = hashRansom.get(two);
                count++;
                hashRansom.put(two, count);
            } else {
                hashRansom.put(two, 1);
            }
        }*/
        for (String key : hashRansom.keys()) {
            Integer oneVal = hashMag.get(key);
            Integer twoVal = hashRansom.get(key);
            if (twoVal == null || oneVal == null) {
                return "No";
            } else if ( oneVal < twoVal) {
                return "No";
            }
        }
        return "Yes";

        //return false;
    }


}