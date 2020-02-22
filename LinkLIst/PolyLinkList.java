
package LinkLIst;

import java.util.Scanner;

class poly{
    
    public int coef,exp;
    public poly next;

}
public class PolyLinkList {

    public poly ptr,eq1,eq2,ans;
    
    public poly input(){
        
        poly eq=null,prev=null;
        Scanner input=new Scanner(System.in);
        while(true){
            
            System.out.println("請輸入係數:");
            ptr=new poly();
            ptr.coef=input.nextInt();
            if(ptr.coef==0)
                return eq;
            
            System.out.println("請輸入指數:");
            ptr.exp=input.nextInt();
            
            if(eq==null){
                
                eq=ptr;
            
            }
            else{
                
                prev.next=ptr;
            
            }
            prev=ptr;
        
        }
        
    }
    
    public void add(){
        
        poly this1=eq1,this2=eq2,prev=null;
        while (this1!=null || this2!=null){
            
            ptr=new poly();
            ptr.next=null;
            //當第一個多相式不為空，或第一個多項式指數大於第二個多項式指數
            if((this1!=null && this2==null) || this1!=null && this1.exp>this2.exp){
                
                ptr.coef=this1.coef;
                ptr.exp=this1.exp;
                this1=this1.next;
                
                
            }
            else if(this1==null || (this2.exp>this1.exp)){
                
                ptr.coef=this2.coef;
                ptr.exp=this2.exp;
                this2=this2.next;
                
            }
            else{
                
                ptr.coef=this1.coef + this2.coef;
                ptr.exp=this1.exp;
                if(this1!=null)
                    this1=this1.next;
                if(this2!=null)
                    this2=this2.next;
                
            }
            
            if(ptr.coef!=0){
                
                if(ans==null)          
                    ans=ptr;
                else
                    prev.next=ptr;
                prev=ptr;
                
            }
            else
                ptr=null;
            
        }
        
    }
    
    public void print(poly node){
        
        if(node.coef<0)
            System.out.printf("-%dx^%d",node.coef,node.exp);
        else
            System.out.printf("%dx^%d",node.coef,node.exp);
        node=node.next;
        while(node!=null){
            
            if(node.coef >0)
                System.out.printf("+%dx^%d", node.coef,node.exp);
            else
                System.out.printf("-%dx^%d",node.coef,node.exp);
            node=node.next;
        }
        
        
    }
    
    
    public static void main(String[] args) {
        PolyLinkList obj = new PolyLinkList();
        System.out.println("----請輸入第一個多項式----");
        obj.eq1=obj.input();
        System.out.println("----請輸入第二個多項式----");
        obj.eq2=obj.input();
        System.out.println("----第一個多項式----");
        obj.print(obj.eq1);
        System.out.println();
        System.out.println("----第二個多項式----");
        obj.print(obj.eq2);
        System.out.println();
        System.out.println("----相加結果----");
        obj.add();
        obj.print(obj.ans);
    }
    
}
