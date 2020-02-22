package LinkLIst;

import java.util.Scanner;

class Nodes{
    
    public String data;
    public Nodes next;

}

public class Stack_UseingLinkList {
    
    static Nodes top,ptr,current;
    static Scanner input = new Scanner(System.in);
    
    Stack_UseingLinkList(){
        
    }
    
    public static void push(){
        
        ptr=new Nodes();
        ptr.data=input.next();
        ptr.next=top;
        top=ptr;
        System.out.println("Push-->OK!");
        
    }
    
    public static void pop(){
        
        if(top==null){
            
            System.out.println("Stack is null!");
            
        }
        else{
            
            Nodes clear;
            clear=top;
            top=top.next;
            clear=null;
            System.out.println("POP -> OK!");
            
        }
        
        
    }
    
    public static void printStack(){
        
        current=top;
        while(current!=null){
            
            System.out.println(current.data);
            current=current.next;
            
        }
        
    }


    public static void main(String[] args) {
        Stack_UseingLinkList obj=new Stack_UseingLinkList();
        System.out.println("1.PUSH/2.POP/3.PRINT");
        Scanner doing = new Scanner(System.in);
        while (true){
            
            int don=doing.nextInt();
            switch(don){
                
                case 1:
                    obj.push();
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                   obj.printStack();
                   break;
                
            }
        }
    }
    
}
