
import java.util.*;

/* WebBrowser Simulator:
	
	This program simulates a web browser with a browsing history log through the use of stacks.
	*/
public class WebBrowser {
	public WebBrowser(Scanner sc) {
		Stack<String> s1=new Stack<>();
		Stack<String> s2=new Stack<>();
		String curr= new String();
		while(sc.hasNextLine()){
			String str = sc.nextLine();
			if(str.equals("BACKWARD")){
				if(s1.size()>1)//if s1 is empty or has only one page then this wont run
					s2.push(s1.pop());
			}
			else if(str.equals("FORWARD")){
				if(!s2.isEmpty())//if there are no pages to forward to, then this wont run
					s1.push(s2.pop());
			}
			else{
				s1.push(str);
				while(!s2.isEmpty()){
					s2.pop();//every time new url is entered, clear 2nd stack
				}
			}
		}
		if(!s1.isEmpty()){
			curr=s1.peek();//point to current page, which is always the top of the first stack
		}
		while(!s1.isEmpty()){
			s2.push(s1.pop());//transfer everything to s2 because s2 is the browsing history stack
		}
		if(s2.isEmpty())//browsing history empty
			System.out.println("Browsing history is empty.");
		else{
			System.out.println("Browsing History:");
			while(!s2.isEmpty()){
				System.out.println(s2.pop());
			}
			System.out.println("Current Page:\n"+curr);
		}
	}

	public static void main(String[] args) {         
		Scanner sc = new Scanner(System.in);     
		WebBrowser bc = new WebBrowser(sc);

	}
}
