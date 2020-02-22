
package LinkLIst;

import java.util.Scanner;

class Node3{
    
    public int data;
    public Node3 llink,rlink;
    
}

class DoubleLinkList {
    
    static Node3 ptr, head, current, prev, tail,first;
    static Scanner key = new Scanner(System.in);
    
    DoubleLinkList(){
        
        head=new Node3();
        head.llink=head;
        head.rlink=head;
        
    }
    
    public static void insert_h(){
        
        ptr=new Node3();
        System.out.println("請輸入您想加入的資料:");
        ptr.data=key.nextInt();
        first=head.rlink;
        ptr.rlink=head.rlink;
        ptr.llink=head;
        head.rlink=ptr;
        first.llink=ptr;
        System.out.println("您的資料已加入!");
        
    }
    
    public static void insert_c(){
        
        ptr=new Node3();
        System.out.println("請輸入您想加入的資料:");
        ptr.data=key.nextInt();
        tail=head.llink;
        ptr.rlink=head;
        tail.rlink=ptr;
        ptr.llink=tail;
        head.llink=ptr;
        System.out.println("您的資料已加入!");
        
    }
    
    public static void insert_f(){
        
        ptr=new Node3();
        System.out.println("請輸入您想加入的資料:");
        ptr.data=key.nextInt();
        prev=head;
        current=head.rlink;
        while ((current!=head) && (current.data>=ptr.data)){
            
            prev=current;
            current=current.rlink;
            
        }
        
        ptr.rlink=current;
        ptr.llink=prev;
        prev.rlink=ptr;
        current.llink=ptr;
        System.out.println("您的資料已加入!");
    }
    
    public static void del_h(){
        
        current=head.rlink;
        head.rlink=current.rlink;
        current.rlink.llink=head;
        current=null;
        System.out.println("資料已被刪除");
        
    }
    
    public static void del_c(){
        
        tail=head.llink;
        tail.llink.rlink=tail.rlink;
        head.llink=tail.llink;
        tail=null;
        System.out.println("資料已被刪除");
        
    }
    
    public static void del_f(){
        
        System.out.println("請輸入要刪除的資料:");
        int del = key.nextInt();
        prev=head;
        current=head.rlink;
        while ((current.rlink!=head) && (current.data!=del)){
            
            prev=current;
            current=current.rlink;
            
        }
        if (current==head)
            System.out.println("資料找不到");
        else{
            
            prev.rlink=current.rlink;
            current.rlink.llink=prev;
            current=null;
            System.out.println("資料已被刪除!");
        
        }
           
    }
    
    
    public static void print(){
        current=head.rlink;
        while(current!=head){
            System.out.println(current.data);
            current=current.rlink;
        }
    }
        
    
    public static void main(String[] args) {
        
        DoubleLinkList obj = new DoubleLinkList(); 
        System.out.println("1.插入前端/2.插入末端/3.由大至小插入/4.刪除前端/5.刪除末端/6.刪除指定/7.列出");
        Scanner doing = new Scanner(System.in);
        while (true){
            
            int don=doing.nextInt();
            switch(don){
                case 1:
                    obj.insert_h();
                    break;
                case 2:
                    obj.insert_c();
                    break;
                case 3:
                    obj.insert_f();
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
            
            }
            
            
        }
        
    }
    
}
