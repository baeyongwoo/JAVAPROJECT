import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		String str = "3000 3001 3001 3001 3001";	//qcode
		
		StringTokenizer st = new StringTokenizer(str, " ");
//		System.out.println("문자열 1" + st.nextToken());
//		System.out.println("문자열 2" + st.nextToken());
//		System.out.println("문자열 3" + st.nextToken());
//		System.out.println("문자열 4" + st.nextToken());
		
		while(st.hasMoreTokens()) {
			if(st.nextToken().equals("32")) {
				System.out.println("중복");
				break;
			}
			System.out.println("새로 문제 풀기");
			break;
		}
	}

}
