package des;


public class HexToBytes {
	  public HexToBytes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static byte[] hexToBytes(String string) {
	        if (string == null) {
	            return null;
	        } else if (string.length() < 2) {
	            return null;
	        } else {
	            int len = string.length() / 2;
	            byte[] buffer = new byte[len];
	            for (int i = 0; i < len; i++) {
	                buffer[i] = (byte) Integer.parseInt(
	                        string.substring(i * 2, i * 2 + 2), 16);
	            }
	            return buffer;
	        }

	    }
}
