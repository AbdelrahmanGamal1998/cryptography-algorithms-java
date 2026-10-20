package des;


public class DesFunctions extends XOR_operation {

static S_BOX_operation_class s=new S_BOX_operation_class();
	
	
	
	 public DesFunctions() {
	super();
	// TODO Auto-generated constructor stub
}









	public String Des_functions(String string, String key) {
		
	        byte[][] expantion = E_BIT_SELECTION_TABLE();
	   
	        String holder = "";
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 6; j++) {
	                holder += string.charAt(expantion[i][j] - 1);
	            }
	        }
	        
	        
	        
	        holder = xor(holder, key);
	
	        holder = s.applySboxes(holder);
	 
	        byte[][] p = permutation_table();
	       
	        String result = "";
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 4; j++) {
	                result += holder.charAt(p[i][j] - 1);
	            }
	        }
	        return result; 
	    }


	 
	 
	 
	 
	 
	 

	private static byte[][] permutation_table() {
		byte[][] p = {{16, 7, 20, 21},
		{29, 12, 28, 17},
		{1, 15, 23, 26},
		{5, 18, 31, 10},
		{2, 8, 24, 14},
		{32, 27, 3, 9},
		{19, 13, 30, 6},
		{22, 11, 4, 25}};
		return p;
	}



	private static byte[][] E_BIT_SELECTION_TABLE() {
		byte[][] expantion = {{32, 1, 2, 3, 4, 5},
		{4, 5, 6, 7, 8, 9},
		{8, 9, 10, 11, 12, 13},
		{12, 13, 14, 15, 16, 17},
		{16, 17, 18, 19, 20, 21},
		{20, 21, 22, 23, 24, 25},
		{24, 25, 26, 27, 28, 29},
		{28, 29, 30, 31, 32, 1}};
		return expantion;
	}

	 
	 



}