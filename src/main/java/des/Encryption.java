package des;


public class Encryption {
	
	 public byte[] encryption(byte[] theMsg, byte[][] subKeys) {
		Algorithm_Des des=new Algorithm_Des();
	        return des.des(theMsg, subKeys, true);
	    }

	public Encryption() {
		super();
		// TODO Auto-generated constructor stub
	}

}
