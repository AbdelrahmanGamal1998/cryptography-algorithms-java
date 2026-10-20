package des;


public class XOR_operation {
	 
public XOR_operation() {
		super();
		// TODO Auto-generated constructor stub
	}

public static String xor(String string, String fun) {
   String result = "";
   for (int i = 0; i < string.length(); i++) {
       if (string.charAt(i) == fun.charAt(i)) {
           result += "0";
       } else {
           result += "1";
       }
   }
   return result;
}

}
