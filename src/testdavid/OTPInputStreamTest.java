package testdavid;
import static org.junit.Assert.*;

import org.junit.Test;

public class OTPInputStreamTest {

	@Test
	public void test() {
		//normal test
		assertEquals(OTPInputStream.decryptOTP("XMCKL",OTPInputStream.encryptOTP("XMCKL","HELLO")),"HELLO");
		assertEquals(OTPInputStream.encryptOTP("XMCKL",OTPInputStream.decryptOTP("XMCKL","HELLO")),"HELLO");
		
		//Testing multiple encryptions and decryptions + ignoring lower case
		String test1="TESTing";
		for(int i=0;i<10;i++){
			test1 = OTPInputStream.encryptOTP("TESTasdfKEY",test1);
		}
		for(int i=0;i<10;i++){
			test1 = OTPInputStream.decryptOTP("TESTKEpadifjgY",test1);
		}
		assertEquals(test1,"TEST");
		
		//testing wrong key to decrypt
		assertNotEquals(OTPInputStream.decryptOTP("ABCDEF",OTPInputStream.encryptOTP("XMCKL","HELLO")),"HELLO");
		
		
	}

}
