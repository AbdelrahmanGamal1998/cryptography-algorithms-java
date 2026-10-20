package des;


public class Removingzero {
	public Removingzero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static byte[][] Remove_zero(byte[][] data) {
	        byte[][] Final = new byte[16][];
	        for (int i = 0; i < data.length; i++) {
	            if (data[i].length > 6 && data[i][0] == 0) {
	                Final[i] = new byte[data[i].length - 1];
	                for (int j = 1; j < data[i].length; j++) {
	                    Final[i][j - 1] = data[i][j];
	                }
	            } else {
	                Final[i] = new byte[data[i].length];
	                for (int j = 0; j < data[i].length; j++) {
	                    Final[i][j] = data[i][j];
	                }
	            }
	        }
	        return Final;
	    }

}
