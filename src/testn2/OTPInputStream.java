package testn2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class OTPInputStream {

	public static void main(String[] args) throws IOException
	{
		InputStream inputstream = null;
	      int i;
	      char c;
	      String  word = null;
	      
		try{
	         // new input stream created
			inputstream = new FileInputStream("src/testn2/word.txt");
	         
	         System.out.println("Characters printed:");
	         
	         // reads till the end of the stream
	         while((i=inputstream.read())!=-1)
	         {
	            // converts integer to character
	            c=(char)i;
	            
	            // prints character
	            System.out.print(c);
	            word+=c;
	         }
	      }catch(Exception e){
	         
	         // if any I/O error occurs
	         e.printStackTrace();
	      }finally
		{
	         
	         // releases system resources associated with this stream
	         if(inputstream!=null)
	        	 inputstream.close();
	      }
		
		
		
		
		
		
		
		
		
		
	}

}
