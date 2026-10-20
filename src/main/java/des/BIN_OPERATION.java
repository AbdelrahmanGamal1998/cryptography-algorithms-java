package des;


public class BIN_OPERATION {
	 public String bin(byte x) {
	        String result = "";
	        int a = 0;
	        while (x > 0) {
	            a = x % 2;
	            result = a + "" + result;
	            x = (byte) (x / 2);
	        }
	        return result;
	    }

	public BIN_OPERATION() {
		super();
		// TODO Auto-generated constructor stub
	}
}
