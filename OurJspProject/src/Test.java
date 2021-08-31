import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		String str = "9999 3005 3005 3004 3004"; // qcode
		StringTokenizer st = new StringTokenizer(str, " ");
//		System.out.println("문자열 1 = " + st.nextToken());
//		System.out.println("문자열 2 = " + st.nextToken());
//		System.out.println("문자열 3 = " + st.nextToken());
//		System.out.println("문자열 4 = " + st.nextToken());
//		System.out.println("문자열 5 = " + st.nextToken());

		ArrayList<String> str2 = new ArrayList<>();
		while(st.hasMoreTokens()) {
			str2.add(st.nextToken());
		}
		
		System.out.println(str2);
		
		if(str2.contains("9595")) {
			System.out.println("중복");
		}else {
			System.out.println("중복아님");
		}
		//user가 3005를 
	}
}
