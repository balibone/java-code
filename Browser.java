
/*
 * Name  : Derian Pratama Tungka 
 * 
 * This program simulates the navigation of web browser tabs using a LinkedList data structure,
 * with the implementation of only a ListNode class. 
 * 
 * The user specifies the number of queries that to be given, 
 * and then proceeds to give these queries(as a form of navigating between the tabs). 
 * 
 * Query Commands: 
 * OPENNEW <url>
 * OPENHERE <url> 
 * NEXTTAB 
 * NEWTAB 
 * CLOSETAB
 * PREVTAB
 * 
 * This program will print out the URL of the current tab at every command. 
 */

import java.util.*;

public class Browser {
    public static void main(String[] args) {
        Browser chrome = new Browser();
        chrome.run();
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        int numQueries = sc.nextInt();//how many queries is user going to provide?
        processQueries(numQueries,sc);
    }
    public void processQueries(int num, Scanner sc){
        ListNode<String> curr = new ListNode<>("https://www.techinasia.com/");//homepage when chromes opens
        for(int i=0;i<num;i++){
            String query = sc.next();//process each query according to the command
            if(query.equals("NEWTAB")){
                newTab(curr);
            }
            else if(query.equals("CLOSETAB")){
                curr=closeTab(curr);
            }
            else if(query.equals("NEXTTAB")){
                curr=nextTab(curr);
            }
            else if(query.equals("PREVTAB")){
                curr=prevTab(curr);
            }
            else if(query.equals("OPENHERE")){
                String url = sc.next();
                openHere(url,curr);
            }
            else if(query.equals("OPENNEW")){
                String url = sc.next();
                openNew(url,curr);
            }
        }
    }
    private void newTab(ListNode<String> curr){
        ListNode<String> newTab = new ListNode<>("http://www.google.com.sg");
        newTab.setPrev(curr);
        newTab.setNext(curr.getNext());
        if(curr.getNext()!=null)
            curr.getNext().setPrev(newTab);
        curr.setNext(newTab);
        System.out.println(curr.getElement());
    }
    private ListNode<String> closeTab(ListNode<String> curr){
        ListNode<String> newCurr;
        if(curr.getNext() != null){
            newCurr=curr.getNext();
            if(curr.getPrev() != null){
                curr.getPrev().setNext(newCurr);
                newCurr.setPrev(curr.getPrev());
            }
            else
                newCurr.setPrev(null);
            curr.setNext(null);
            curr.setPrev(null);
        }
        else{ 
            newCurr=curr.getPrev();
            curr.getPrev().setNext(null);
            curr.setPrev(null);
        }
        System.out.println(newCurr.getElement());
        return newCurr;
    }
    private ListNode<String> nextTab(ListNode<String> curr){
        if(curr.getNext() != null)
            curr = curr.getNext();
        System.out.println(curr.getElement());
        return curr;
    }
    private ListNode<String> prevTab(ListNode<String> curr){
        if(curr.getPrev() != null)
            curr = curr.getPrev();
        System.out.println(curr.getElement());
        return curr;
    }
    private void openHere(String url, ListNode<String> curr){
        curr.setElement(url);
        System.out.println(curr.getElement());
    }
    private void openNew(String url, ListNode<String> curr){
        ListNode<String> newTab = new ListNode<>(url);
        newTab.setPrev(curr);
        newTab.setNext(curr.getNext());
        if(curr.getNext()!=null)
            curr.getNext().setPrev(newTab);
        curr.setNext(newTab);
        System.out.println(curr.getElement());
    }
}
class ListNode<String> {
    protected String element;
    protected ListNode<String> prev;
    protected ListNode<String> next;
    
    /* constructors */
    public ListNode(String item) {
        this(item,null,null);
    }
    public ListNode(String item, ListNode<String>p, ListNode<String> n) {
        element = item;
        prev = p;
        next = n;
    }
    /* get the previous ListNode */
    public ListNode<String> getPrev() {
        return this.prev;
    }
    /* get the next ListNode */
    public ListNode<String> getNext() {
        return this.next;
    }
    
    /* get the element of the ListNode */
    public String getElement() {
        return this.element;
    }
    // set prev pointer
    public void setPrev(ListNode<String> item){
        this.prev = item;
    }
    // set next pointer
    public void setNext(ListNode<String> item) {
        this.next = item;
    }
    // set the URL in this ListNode
    public void setElement(String item) {
        this.element = item;
    }
}
