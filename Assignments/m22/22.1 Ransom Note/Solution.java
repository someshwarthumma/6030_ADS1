import java.util.Scanner;
class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split(" ");
		int noOfWordsInMag = Integer.parseInt(tokens[0]);
		int noOfWordsInRansom = Integer.parseInt(tokens[1]);
		String[] magWords = scan.nextLine().split(" ");
		String[] ransomWords = scan.nextLine().split(" ");
		RansomNote ransomNote = new RansomNote(noOfWordsInMag,noOfWordsInRansom,magWords,ransomWords);
		System.out.println(ransomNote.isReplicaPossible()); 
	}
}

class RansomNote{
	int magNum;
	int ransomNum;
	String[] magWords;
	String[] ransomWords;
	SeparateChainingHashST<String , Integer> hashMag;
	SeparateChainingHashST<String , Integer> hashRansom;
	RansomNote(int m, int r, String[] mW, String[] rW){
		this.magNum = m;
		this.ransomNum = r;
		this.magWords = mW;
		this.ransomWords = rW;
		hashMag = new SeparateChainingHashST<String, Integer>();
		hashRansom = new SeparateChainingHashST<String, Integer>();
	}
	public void loadWords(String[] arr, SeparateChainingHashST<String , Integer> hash){
		for(String word: arr){
			if(hash.contains(word)){
				int count = hash.get(word);
				count++;
				hash.put(word, count);
			} else {
				hash.put(word, 1);
			}
		}
	}

	public String isReplicaPossible(){
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
		for(String key: hashRansom.keys()){
			Integer oneVal = hashMag.get(key);
			Integer twoVal = hashRansom.get(key);
			if(twoVal == null || oneVal == null){
				return "No";
			} else if ( oneVal < twoVal){
				return "No";
			}
		}
		return "Yes";

		//return false;
	}


}