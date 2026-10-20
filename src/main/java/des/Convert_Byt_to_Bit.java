package des;


public class Convert_Byt_to_Bit {
	 public Convert_Byt_to_Bit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String Byt_into_bit(byte[] key) {
	        String FinalString = "";
	        for (int i = 0; i < key.length; i++) {
	            byte b1 = key[i];
	            FinalString += String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
	        }
	        return FinalString;
	    }

}

