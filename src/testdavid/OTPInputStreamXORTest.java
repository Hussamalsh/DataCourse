package testdavid;
import static org.junit.Assert.*;

import org.junit.Test;

public class OTPInputStreamXORTest {

	@Test
	public void test() {
		//normal test
		assertEquals(OTPInputStreamXOR.decryptXOR("XMCKL",OTPInputStreamXOR.encryptXOR("XMCKL","HELLO")),"HELLO");
		assertEquals(OTPInputStreamXOR.encryptXOR("XMCKL",OTPInputStreamXOR.decryptXOR("XMCKL","HELLO")),"HELLO");
		
		//Testing multiple encryptions and decryptions + that lower and uppercase works
		String test1="tesTING";
		for(int i=0;i<10;i++){
			test1 = OTPInputStreamXOR.encryptXOR("aodfhosieUIUIHs",test1);
		}
		for(int i=0;i<10;i++){
			test1 = OTPInputStreamXOR.decryptXOR("aodfhosieUIUIHs",test1);
		}
		assertEquals(test1,"tesTING");
		
		//testing wrong key to decrypt
		assertNotEquals(OTPInputStreamXOR.decryptXOR("ABCDEF",OTPInputStreamXOR.encryptXOR("XMCKL","HELLO")),"HELLO");
		
		
	}

}
