package des;

import java.math.BigInteger;

public class S_BOX_operation_class {
	
	 public S_BOX_operation_class() {
		super();
		// TODO Auto-generated constructor stub
	}



	static BIN_OPERATION b =new BIN_OPERATION();
	 static S_box_table s=new S_box_table();
	 
	
	
	public String applySboxes(String holder) {
	    String[] holders = new String[8];
	    String[] rows = new String[8];
	    String[] cols = new String[8];
	   
	    int row = 0;
	    int col = 0;
	    for (int i = 0; i < 8; i++) {
	        holders[i] = holder.substring(i * 6, (i + 1) * 6);
	       
	        rows[i] = "" + holders[i].charAt(0) + holders[i].charAt(holders[i].length() - 1);
	       
	        cols[i] = holders[i].substring(1, holders[i].length() - 1);
	       
	    }
	    byte[][][] sBoxes = s.S_box_Table();
	    holder = "";
	    String s = "";
	    for (int i = 0; i < 8; i++) {

	        s +=b.bin(sBoxes[i][new BigInteger(rows[i], 2).toByteArray()[0]][new BigInteger(cols[i], 2).toByteArray()[0]]);

	        while (s.length() % 4 != 0 && s.length() < 4 || s.equals("")) {
	            s = "0" + s;
	        }
	   
	        holder += s;
	        s = "";
	    }
		return holder;
	}


	

}
