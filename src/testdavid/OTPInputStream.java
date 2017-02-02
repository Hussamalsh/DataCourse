package testdavid;

public class OTPInputStream
{
	
	public static void main(String[] args) 
	{	
		System.out.println("Encryption/decryption simple way");
		String encrypted = encryptOTP("XMCKL","HELLO");
		System.out.println(encrypted);
		System.out.println(decryptOTP("XMCKL",encrypted));
	}
	
	
	
	//Encrypt (simple way)
	public static String encryptOTP(String key, String secret){
		byte[] keyB = convertToByte(checkCase(key),true);
		byte[] secretB = convertToByte(checkCase(secret),true);
		byte[] encB = encryptv1(secretB,keyB);
		String theWord = "";
		for(int q = 0; q < encB.length; q++)
		{
    	  char one = (char) ((int)encB[q]+65);
    	  theWord+=one;
		}
		
		return theWord;
	}

	//Decrypt (simple way)
	public static String decryptOTP(String key, String secret){
		byte[] keyB = convertToByte(checkCase(key),true);
		byte[] secretB = convertToByte(checkCase(secret),true);
		byte[] decB = decryptv1(secretB,keyB);
	    String theWord = "";
	    for(int q = 0; q < decB.length; q++)
	    {
	    	  char one = (char) ((int)decB[q]+65);
	    	  theWord+=one;
	    }
			
			return theWord;
	}
			
	//This method take only capital letters in the input and the key streams.(also converts to char)
	private static char[] checkCase(String secret)
	{
		char [] temp; 
		char [] noUC;
		int r=0;
		int size = 0;
		for(int j =0; j<secret.length(); j++)
			if(Character.isUpperCase(secret.charAt(j)))
			{
				size++;
			}		
		noUC = new char[size];
		temp = secret.toCharArray();
			for(int j =0; j<temp.length; j++)
				if(Character.isUpperCase(temp[j]))
				{
					noUC[r++]=temp[j];
				}
		return noUC;
	}	
	
	private static byte [] convertToByte(char [] arr, boolean asciiSubtract)
	{
		 
		byte[] secret = new byte [arr.length];
		
		for (int i = 0; i< arr.length; i++){
			if(asciiSubtract)
				arr[i]-=65;
			secret[i] = (byte) (arr[i]);
		}
		
		return secret;
	}
	
	private static byte [] encryptv1(byte []secret, byte []key)
	{
		byte[] encoded = new byte[secret.length];
		   // Encrypt
	    for (int i = 0; i < secret.length; i++) {
	        encoded[i] = (byte) (((((secret[i] + key[i])%26))+26)%26);
	    }
		
		return encoded;
	}
	
	
	private static byte [] decryptv1(byte []secret, byte []key)
	{
		byte[] decoded  = new byte[secret.length];
		   // Encrypt
	    for (int i = 0; i < secret.length; i++) {
	    	decoded [i] = (byte) (((((secret[i] - key[i])%26))+26)%26);
	    }
		
		return decoded;
	}
	
}