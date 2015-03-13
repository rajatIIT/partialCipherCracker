package cryptoAsst1LoopTexting;

public class MyKey {
	
	int[] key;
	int keySize;
	
	public MyKey(int keySize){
		this.keySize = keySize;
	}
	
	public int[] getKeyArray(){
		return key;
	}
	
	public void setKeySize(int keySize){
		this.keySize=keySize;
	}
}
