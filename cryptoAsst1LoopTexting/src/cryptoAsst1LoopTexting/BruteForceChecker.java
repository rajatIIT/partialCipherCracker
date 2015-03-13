package cryptoAsst1LoopTexting;

import java.util.HashMap;

/**
 * 
 * Takes a list pt of possible plaintexts and ct, a ciphertext and generates possible key
 * 
 * and a list of possible plaintexts for the key. If more than one key exists, using which cipher can be cracked, returns false. 
 * 
 * Returns this list.
 * 
 * 
 * @author vaio
 *
 */
public class BruteForceChecker {
	
	HashMap<String,String> possiblePlaintexts;
	int possiblekeySize,maximumKeyShift;
	int[] currentPossibleKey;
	int[] cipherTextToBeCracked;
	String currentPossiblePlainTextString;
	
			
	
	public BruteForceChecker(HashMap<String,String> passedPossiblePlainTextHashMap,String passedCipherText){
		
		possiblePlaintexts = new HashMap<String,String>();
		possiblePlaintexts = passedPossiblePlainTextHashMap;
		
		cipherTextToBeCracked = getIntArray(passedCipherText);
		
		
		possiblekeySize=2;
		maximumKeyShift = 26;
		
		currentPossibleKey = new int[possiblekeySize + 1]; 
		

		
		bruteforceChecker(0);
		
		// let key is ABA
		
		// then Using CDE : CDE + ABA = CDE + 121 = DFF
		
		// using ABC       
		
		String plainText=	"YAJSKLGHDFJF";
		
			
		String cipherText=	"BCJDSJGFDGHL";
	
	//	int[] possibleKEy = computeDifference(plainText, cipherText); 
	//	for (int i=0;i<possibleKEy.length;i++)
	//		System.out.print(possibleKEy[i] + " ");
		
	//	generateAndCheckKeys(cipherText);
		
	}
	
	private int[] computeDifference(int[] currentPossibleKey2, int[] cipherTextToBeCracked2) {
		
		 
		 int[] cipherArray = cipherTextToBeCracked2;
		 int[] plainArray = currentPossibleKey2;
		 int[] possibleKey = new int[cipherArray.length];
	
		 for(int i=0;i<cipherArray.length;i++){
			 
			 possibleKey[i] = ((cipherArray[i] - plainArray[i]) % 26);
			 if (possibleKey[i]<0)
				 possibleKey[i] = 26+possibleKey[i];
		 }
		 
		 return possibleKey;
	}

	private void generateAndCheckKeys(String cipherText) {
		
		
		
	}
	 
	private void bruteforceChecker(int possibleKeyCheckIndex) {
		if (possibleKeyCheckIndex == possiblekeySize) {
			// execute base case
			for (int i=0;i<=maximumKeyShift;i++){
			//	System.out.println(" " + " "+ " " + i + " ");
				currentPossibleKey[possibleKeyCheckIndex]=i;
				currentPossiblePlainTextString = getString(computeDifference(currentPossibleKey,cipherTextToBeCracked));
				System.out.println("Checking " + currentPossibleKey[0] + " " + currentPossibleKey[1] + " " + currentPossibleKey[2] + " .");
				if (possiblePlaintexts.containsKey(currentPossiblePlainTextString)){
					System.out.println("We can crack cipher with this key: " + getString(currentPossibleKey));
					System.exit(0);
				}
			}
		} else {
			// execute recursion case
			
			for (int i=0;i<=maximumKeyShift;i++){
			//	System.out.print(i + " ");
				// alter the possibleCheckKeyindex and then recurse
				currentPossibleKey[possibleKeyCheckIndex]=i;
				bruteforceChecker(possibleKeyCheckIndex+1);
				
			}
			
			
		}
	}
	
	private void checkKey(){
		
		// fetch the key
		
		
		// compute the difference
		int[] currentPossiblePlainText = computeDifference(currentPossibleKey, cipherTextToBeCracked);
		
		
		
		// check in the plaintext array
				
				
		
	}
	
	/**
	 *
	 * 
	 * @param possiblePlainText
	 */
	public void checkPossiblePlainText(int[] possiblePlainText){
		
		
		
	}
	
	/**
	 * 
	 */
	private String getString(int[] inputIntArray){
		
		char[] string = new char[inputIntArray.length]; 
		
		for(int eachInt=0;eachInt<inputIntArray.length;eachInt++){
			if (inputIntArray[eachInt]==0)
				string[eachInt]=' ';
			else
			string[eachInt] =(char)(inputIntArray[eachInt] + 64);
		}
		
		return (new String(string));
	}
	
	/**
	 * Return the integer array representation array for the String for the string assuming that the String contains only Capital Alphabets.
	 * 
	 * @param inputString
	 * @return
	 */
	private int[] getIntArray(String inputString){
		
		int[] stringArray = new int[inputString.length()];
		for(int i=0;i<inputString.length();i++){
			
			char index = inputString.charAt(i);
			int tempint = (int)index;
			stringArray[i] = tempint - 64;
		}
		return null;
	}
}
