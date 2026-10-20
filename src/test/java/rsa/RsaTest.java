package rsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class RsaTest {

	@Test
	void recognisesPrimesAndComposites() {
		assertEquals(0, RSA.isPrime(1));
		assertEquals(1, RSA.isPrime(2));
		assertEquals(1, RSA.isPrime(13));
		assertEquals(0, RSA.isPrime(9));
		assertEquals(0, RSA.isPrime(15));
		assertEquals(0, RSA.isPrime(100));
	}

	/** Toy parameters: p=5, q=11, so n=55. Encrypting 4 gives 9, and decrypting 9 gives back 4. */
	@Test
	void decryptionReversesEncryption() {
		String cipher = RSA.RES_Encryption(4, 5, 11);

		assertEquals("9", cipher);
		assertEquals("4", RSA.RES_Decryptian(new BigInteger(cipher), 5, 11));
	}
}
