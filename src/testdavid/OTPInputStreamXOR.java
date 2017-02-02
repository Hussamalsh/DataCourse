package testdavid;
import java.io.IOException;
import java.io.InputStream;

public class OTPInputStreamXOR
{
	
	public static void main(String[] args) 
	{	
		System.out.println("\n\nEncryption/decryption XOR operator");
		String encrypted2 = encryptXOR("XMCKL","hello");
		System.out.println(encrypted2);
		System.out.println(decryptXOR("XMCKL",encrypted2));
	}
	
	//Encrypt (Xor way)
	public static String encryptXOR(String key, String secret){
		byte[] keyB = convertToByte(key.toCharArray(), false);
		byte[] secretB = convertToByte(secret.toCharArray(), false);
		byte[] encB = encryptv2(secretB,keyB);
		String theWord = "";
		for(int q = 0; q < encB.length; q++)
		{
    	  char one = (char) ((int)encB[q]);
    	  theWord+=one;
		}
		
		return theWord;
	}

	//Decrypt (Xor way)
	public static String decryptXOR(String key, String secret){
		byte[] keyB = convertToByte(key.toCharArray(), false);
		byte[] secretB = convertToByte(secret.toCharArray(), false);
		byte[] decB = decryptv2(secretB,keyB);
	    String theWord = "";
	    for(int q = 0; q < decB.length; q++)
	    {
	    	  char one = (char) ((int)decB[q]);
	    	  theWord+=one;
	    }
			
			return theWord;
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
	
	private static byte [] encryptv2(byte []secret, byte []key)
	{
		byte[] encoded = new byte[secret.length];
		   // Encrypt
	    for (int i = 0; i < secret.length; i++) {
	    	 encoded[i] = (byte) (secret[i] ^ key[i]);
	    }
		
		return encoded;
	}
	
	
	private static byte [] decryptv2(byte []encoded, byte []key)
	{
		byte[] decoded  = new byte[encoded.length];
		   // Encrypt
	    for (int i = 0; i < encoded.length; i++) {
	    	decoded [i] = (byte) (encoded[i] ^ key[i]);
	    }
		
		return decoded;
	}
		
}
