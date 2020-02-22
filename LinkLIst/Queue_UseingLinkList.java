package LinkLIst;

import java.util.Scanner;

class Nodeq{
    
    public String data;
    public Nodeq next;

}
public class Queue_UseingLinkList {
    
    static Nodeq rear,front,ptr,current;
    static Scanner input = new Scanner(System.in);
    
    public static void insert(){
        
        System.out.println("Key Your Data:");
        ptr=new Nodeq();
        ptr.data=input.next();
        ptr.next=null;
        if(rear==null)
            front=ptr;
        else
            rear.next=ptr;
        rear=ptr;
        System.out.println("Insesrt -> OK!");
        
    }
    
    public static void del(){
        
        if(front==null)
            System.out.println("Queue is Null!");
        else{
            
            Nodeq clear; 
            clear=front;
            front=front.next;      
            clear=null;
            
        }
        
    }
        public static void printStack(){
        
        current=front;
        while(current!=null){
            
            System.out.print(current.data +" ");
            current=current.next;
            
        }
        
    }
    
    
    public static void main(String[] args) {
       Queue_UseingLinkList obj = new Queue_UseingLinkList();
        System.out.println("1.插入/2.刪除/3.PRINT");
        Scanner doing = new Scanner(System.in);
        while (true){
            
            int don=doing.nextInt();
            switch(don){
                
                case 1:
                    obj.insert();
                    break;
                case 2:
                    obj.del();
                    break;
                case 3:
                   obj.printStack();
                   break;
                
            }
        }
    }
    
}
