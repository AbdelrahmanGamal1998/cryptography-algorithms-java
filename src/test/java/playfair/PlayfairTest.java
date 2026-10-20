package playfair;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PlayfairTest {

	/** The worked example from the Wikipedia article on the Playfair cipher. */
	@Test
	void encryptsAndDecryptsTheClassicExample() {
		Playfair.table = Playfair.ciphermatrix("PLAYFAIREXAMPLE");

		String cipher = Playfair.cipher("HIDETHEGOLDINTHETREESTUMP");

		assertEquals("BMODZBXDNABEKUDMUIXMMOUVIF", cipher);
		assertEquals("HIDETHEGOLDINTHETREXESTUMP", Playfair.decode(cipher));
	}
}
