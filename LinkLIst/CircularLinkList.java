
package LinkLIst;

import java.util.Scanner;

class Node1{
    public int data;
    public Node1 next;
    
}

public class CircularLinkList {
    
    static Node1 ptr,head,current,prev,forward;
    static Scanner input = new Scanner(System.in);
    
    CircularLinkList(){
        head=new Node1();
        head.next=head; //當一開始創立串列，就要將自己與自己串聯
    
    }
    
    public static void insert_h(){ //插入至前端
        
        ptr=new Node1();
        System.out.println("請輸入要插入的資料：");
        ptr.data=input.nextInt();
        ptr.next=head.next;
        head.next=ptr;
        System.out.println("您的資料已經加入成功!");
    
    }
    
    public static void insert_c(){  //插入至末端
   
        ptr=new Node1();
        System.out.println("請輸入要插入的資料：");
        ptr.data=input.nextInt();
        current=head.next;
        while(current.next!=head){  //與單向串列不同，不是null而是head
            
            current=current.next;
        
        }
        
        current.next=ptr;
        ptr.next=head;
        System.out.println("您的資料已經加入成功!");
    
    }
    
    public static void insert_f(){  //由大至小插入
        
        ptr=new Node1();
        System.out.println("請輸入要插入的資料：");
        ptr.data=input.nextInt();
        prev=head;
        current=head.next;
        while((current!=head) && (current.data>=ptr.data)){
            
            prev=current;
            current=current.next;
        
        }
        ptr.next=current;
        prev.next=ptr;
        System.out.println("您的資料已經加入成功!");
    
    }
    
    public static void del_h(){
        
        current=head.next;  //另CURRENT在前端
        head.next=current.next;
        current=null;
        System.out.println("前端資料已被刪除");
    
    }
    
    public static void del_c(){
        
        current=head.next;
        while(current.next!=head){
            
            prev=current;
            current=current.next;
        
        }
        prev.next=head;
        current=null;
        
    }
    
    public static void del_f(){
        
        System.out.println("請輸入要刪除的資料內容:");
        int del=input.nextInt();
        prev=head;
        current=head.next;
        while ((current!=head) && (current.data != del)){
            
            prev=current;
            current=current.next;
        
        }
        if (current==head){
            System.out.println("資料不存在");
        }
        else{
            prev.next=current.next;
            current=null;
            System.out.printf("%d 已經被刪除!",del);
        }
        
    }
    
    public static void print(){
        current=head.next;
        while(current!=head){
            System.out.printf("%d ",current.data);
            current=current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        CircularLinkList obj = new CircularLinkList();
        System.out.println("--------------------------\n");
        System.out.println("--環狀串列的基本加入和刪除--\n");
        System.out.println("--------<1>按大小插入-------\n");
        System.out.println("--------<2>插入至前端-------\n");
        System.out.println("--------<3>插入至末端-------\n");
        System.out.println("--------<4>刪 除 前端-------\n");
        System.out.println("--------<5>刪 除 末端-------\n");
        System.out.println("-------<6>刪除指定資料------\n");
        System.out.println("--------<7>列       印-------\n");
        System.out.println("--------<8>結       束-------\n");
        while(true){
            Scanner doing=new Scanner(System.in);
            int doin=doing.nextInt();
            switch(doin){
                case 1://按照大至小
                    obj.insert_f();
                    break;
                case 2:
                    obj.insert_h();
                    break;
                case 3:
                    obj.insert_c();
                    break;
                case 4:
                    obj.del_h();
                    break;
                case 5:
                    obj.del_c();
                    break;
                case 6:
                    obj.del_f();
                    break;
                case 7:
                    obj.print();
                    break;
                case 8:
                    System.exit(0);
                    break;
            
            }
        
        
        }
    }
    
}
