package des;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DesTest {

	private static final String KEY = "133457799BBCDFF1";
	private static final String PLAIN = "0123456789ABCDEF";

	private static String hex(byte[] bytes) {
		return new Convert_Bytes_To_Hexa().Bytes_into_Hexa(bytes).replaceAll("[^0-9A-Fa-f]", "").toUpperCase();
	}

	@Test
	void encryptsTheClassicTextbookVector() {
		byte[][] subKeys = new GetSubKeys().getSubkeys(HexToBytes.hexToBytes(KEY));

		byte[] cipher = new Encryption().encryption(HexToBytes.hexToBytes(PLAIN), subKeys);

		assertEquals("85E813540F0AB405", hex(cipher));
	}

	@Test
	void decryptionReversesEncryption() {
		byte[][] subKeys = new GetSubKeys().getSubkeys(HexToBytes.hexToBytes(KEY));
		byte[] plain = HexToBytes.hexToBytes(PLAIN);
		byte[] cipher = new Encryption().encryption(plain, subKeys);

		byte[] decrypted = new Algorithm_Des().des(cipher, subKeys, false);

		assertArrayEquals(plain, decrypted);
	}
}
