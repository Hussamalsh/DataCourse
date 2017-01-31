
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Scanner;

public class OTPInputStream 
{

    int pointer = 0;
    static byte[] contents;
	
	public static void main(String[] args) 
	{	
		  OneTimePad otp = new OneTimePad ();
	      byte[] encoded = new byte[args.length];
	      byte[] decoded = new byte[args.length];
	      byte[] key = new byte[5];
	      System.out.println("Write they key: ");
	      // create a new scanner with the specified String Object
	      Scanner scanner = new Scanner(System.in);
	      int i=0;
	      while (scanner.hasNext() && i < 4) {
	    	   // check if the scanner's next token is an int
	    	   //System.out.println("" + scanner.hasNextInt());
	    	  key[i++] = scanner.nextByte();
	    	  
	      }
	      // Generate random key (has to be exchanged)
	      //final byte[] key = {23,12,2,10,11}; //23 12 2 10 11   {4,16,13,21,25}
	      //= new byte[args.length];
	      //new SecureRandom().nextBytes(key);
	      
	      //Version 1 Test
	      System.out.println("Test version 1: ");
	      contents = otp.convertToByte(otp.version1(args));   //"hello".getBytes();
	      encoded = otp.encryptv1(contents, key);
	      writeWord(encoded);
	      decoded = otp.decryptv1(encoded, key);
	      writeWord(decoded);
	      
	      
	      //Version 2 Test
	      System.out.println("Test version 2: ");
	      contents = otp.convertToBytev2(otp.version2(args));//"hello".getBytes();
	      encoded = otp.encryptv2(contents, key);
	      writeWordv2(encoded);
	      decoded = otp.decryptv2(encoded, key);
	      writeWordv2(decoded);

	        

	}
	
	
	public static void writeWord(byte [] decoded)
	{
	      String theWord = "";
	      for(int q = 0; q < decoded.length; q++)
	      {
	    	  char one = (char) ((int)decoded[q]+65);
	    	  theWord+=one;
	      }
	      System.out.println(theWord);
	}
	
	
	public static void writeWordv2(byte [] decoded)
	{
	      String theWord = "";
	      for(int q = 0; q < decoded.length; q++)
	      {
	    	  char one = (char) ((int)decoded[q]);
	    	  theWord+=one;
	      }
	      System.out.println(theWord);
	}



}
