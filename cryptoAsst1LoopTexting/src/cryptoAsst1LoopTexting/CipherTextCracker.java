
package cryptoAsst1LoopTexting;

import java.util.ArrayList;

public class CipherTextCracker {

	int sizeOfCipherText;
	ArrayList<String> fragmentedCipherTexts = new ArrayList<String>();
	String cipherTextToBeCracked;
	int cipherTextFragmentSize;
	
	public CipherTextCracker() {
	
		BruteForceChecker myBruteForceChecker = new BruteForceChecker();
		cipherTextFragmentSize = 4;
		
		if (cipherTextToBeCracked.length()%cipherTextFragmentSize!=0)
		{
		System.out.println("Fatal : CipherText not in proper format!");
		System.exit(0);
		} else 
			fragmantizeCipherText();
		
		// now,for each fragment check the cardinality of possible plaintexts
		
		
		
		
	
	}

	private void fragmantizeCipherText() {
		//TODO Auto-generated method stub
		for (int i=0;i<((cipherTextToBeCracked.length()/cipherTextFragmentSize));i=i+cipherTextFragmentSize) 
			fragmentedCipherTexts.add(cipherTextToBeCracked.substring(i, (i-1)+ cipherTextFragmentSize));
	}
	
	
}
