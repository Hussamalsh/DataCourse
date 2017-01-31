
public class OneTimePad 
{
		
	//This method take only capital letters in the input and the key streams. 
	public static char[] version1(String[] secret)
	{
		char [] temp; 
		char [] noUC;
		int r=0;
		int size=0;
		
		for(int z = 0;z<secret.length; z++){
			size += secret[z].length();
		}
		noUC = new char[size];
		
		for(int i = 0; i<secret.length; i++)
		{
			temp = secret[i].toCharArray();
			
			for(int j =0; j<temp.length; j++)
				if(Character.isUpperCase(temp[j]))
				{
					noUC[r++]= temp[j];
				}
			
		}
		
		
		return noUC;
	}
	
	
	//This method take only capital letters in the input and the key streams. 
	public static char[] version2(String[] secret)
	{
		char [] temp; 
		char [] noUC;
		int r=0;
		int size=0;
		
		for(int z = 0;z<secret.length; z++){
			size += secret[z].length();
		}
		noUC = new char[size];
		
		for(int i = 0; i<secret.length; i++)
		{
			temp = secret[i].toCharArray();
			
			for(int j =0; j<temp.length; j++)
					noUC[r++]=temp[j];
		}
		
		
		return noUC;
	}
	
	
	
	public static byte [] convertToByte(char [] arr)
	{
		 
		byte[] secret = new byte [arr.length];
		
		for (int i = 0; i< arr.length; i++)
			secret[i] = (byte) (arr[i]-65);
		
		return secret;
	}

	public static byte [] convertToBytev2(char [] arr)
	{
		 
		byte[] secret = new byte [arr.length];
		
		for (int i = 0; i< arr.length; i++)
			secret[i] = (byte) (arr[i]);
		
		return secret;
	}
	
	public static byte [] encryptv1(byte []secret, byte []key)
	{
		byte[] encoded = new byte[secret.length];
		   // Encrypt
	    for (int i = 0; i < secret.length; i++) {
	        encoded[i] = (byte) (((((secret[i] + key[i])%26))+26)%26);
	    }
		
		return encoded;
	}
	
	
	public static byte [] decryptv1(byte []secret, byte []key)
	{
		byte[] decoded  = new byte[secret.length];
		   // Encrypt
	    for (int i = 0; i < secret.length; i++) {
	    	decoded [i] = (byte) (((((secret[i] - key[i])%26))+26)%26);
	    }
		
		return decoded;
	}
	
	
	public static byte [] encryptv2(byte []secret, byte []key)
	{
		byte[] encoded = new byte[secret.length];
		   // Encrypt
	    for (int i = 0; i < secret.length; i++) {
	    	 encoded[i] = (byte) (secret[i] ^ key[i]);
	    }
		
		return encoded;
	}
	
	
	public static byte [] decryptv2(byte []encoded, byte []key)
	{
		byte[] decoded  = new byte[encoded.length];
		   // Encrypt
	    for (int i = 0; i < encoded.length; i++) {
	    	decoded [i] = (byte) (encoded[i] ^ key[i]);
	    }
		
		return decoded;
	}
	
	
	

}
