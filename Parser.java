/*  
 * Author: Derian Pratama Tungka
 * 
 * Scenario: a new and simple markup language has been designed. 
 * This program checks if a file which is already tokenized with tags is syntactically correct,
 * using a Stack. 
 * 
 * Paired Tags:
 * Section  <S>  </S> 
 * Paragraph  <P>  </P> 
 * Bold Font  <B>  </B> 
 * Italic font  <I>  </I> 
 * 
 * Non-Paired Tags: 
 * Line Break  <LB>
 * Page Break  <PB> 
 * Text  <TEXT> (to simulate text embedded in the file)
 * 
 * 1.An empty source file is syntactically correct. 
 * 2.An  opening  tag  must  be  closed.
 * 3.There should not be any invalid tags in the source file. 
 * 4.If an opening  tag is embedded in the environment of another opening tag, the inner opening tag 
 * must be closed before closing the outer opening tag. 
 * 
 */ 

import java.util.*;

/* Parser for the markup language */
public class Parser {
    public static void main(String[] args) {              
        Parser bc = new Parser();
        bc.run();
    }
    private void run(){
        Scanner sc = new Scanner(System.in);
        //No Error if the input is syntactically correct 
        if(checkValid(sc))
            System.out.println("No Error");
        //Error! if it is not
        else
            System.out.println("Error!");
    }
    private boolean checkValid(Scanner sc){
        Stack<String> opening = new Stack<>(); 
        String tag;
        while(sc.hasNextLine()&&!(tag = sc.nextLine()).equals("")){
            if(tag.equals("<S>")||tag.equals("<P>")||tag.equals("<I>")||tag.equals("<B>")){
                opening.push(tag);//push all opening tags into stack
            }
            else if(tag.equals("</S>")||tag.equals("</P>")||tag.equals("</I>")||tag.equals("</B>")){
                if(tag.charAt(2)!=opening.pop().charAt(1))//once closing tag is detected
                    return false;//check if it matches the last opening tag.
            }
            else if(!tag.equals("<LB>")&&!tag.equals("<PB>")&&!tag.equals("<TEXT>")){
                return false;//if the tag is invalid, return false
            }
        }
        return true;
    }
}
