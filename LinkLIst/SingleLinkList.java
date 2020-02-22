package LinkLIst;

import java.util.Scanner;

class Node { //節點

    public int data;  //節點中的資料
    public Node next; //紀錄下一個節點

}

class singleList { //整個LIST的結構

    static Node ptr, head, current, prev, forward;
    static Scanner key = new Scanner(System.in);

    singleList() { //建立LIST，head

        head = new Node();
        head.next = null;
    }
    
    public static void insert_f(){ /*依照數字大小排列*/
    
        ptr=new Node();/*建立新的節點*/
        ptr.next=null;
        System.out.print("請輸入要插入的資料:");
        ptr.data=key.nextInt();
        /*利用像是夾擊的方法，prev為前一個節點，current為當前的節點*/
        prev=head;
        current=head.next;
        /*current!=null時代表還尚未抵達串列末端，但不是current.next!=null否則會使current停留在最後一筆資料，而導致ptr原本應該插入末端，但卻插入末端的前一個*/
        /*將要插入之資料與current比對，當要插入之PTR已經大於CURRENT代表已到達應插入位置*/
        while ((current!=null) && (current.data>=ptr.data)){
            prev=current;
            current=current.next;
        
        }
        ptr.next=current; /*將PTR串聯至CURRENT*/
        prev.next=ptr;
    
    }
    
    public static void insert_h(){
        ptr=new Node();
        ptr.next=head.next;//插入前端，目前ptr與head都指向同一個節點
        System.out.print("請輸入要新增的資料:");
        ptr.data=key.nextInt();
        head.next=ptr;
   
    }
    
    public static void insert_c(){
        
        ptr=new Node();
        ptr.next=null;
        System.out.print("請輸入要新增的資料:");
        ptr.data=key.nextInt();
        current=head;/*CURRENT從頭開始找*/
        while (current.next!=null){
            current=current.next;
        }
        current.next=ptr;
    
    }
    
    public static void reverse(){
        
        current=null;
        forward=head.next;
        while(forward!=null){
            
            prev=current;
            current=forward;
            forward=forward.next;
            current.next=prev;
           
        }
        head.next=current;
    }
    
    public static void del(){
        if(head.next==null){
            System.out.println("串列為空");
        }
        else{
            System.out.print("請輸入要刪除的資料節點之內容:");
            int del_node=key.nextInt();
            prev=head; 
            current=head.next; 
            while((current!=null)&&(del_node!=current.data)){
                prev=current;
                current=current.next;
            }
            if(current!=null){
                
                prev.next=current.next; /*將prev連結到要刪除的資料之後的節點*/
                current=null; /*回收節點*/
                System.out.printf("del Data: %d\n",del_node);
            
            }
            else{
                
                System.out.println("Not Find Data.");
                
            }            
        }

    }
    public static void print(){
        current=head.next;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
        
        }
    
    
    public static void main(String[] args) {
        singleList obj = new singleList();
        while(true){
            Scanner doing=new Scanner(System.in);
            int doin=doing.nextInt();
            switch(doin){
                case 1://按照大至小
                    obj.insert_f();
                    break;
                case 2:
                    obj.del();
                    break;
                case 3:
                    obj.print();
                    break;
                case 4:
                    obj.insert_h(); //加入前端
                    break;
                case 5: //加入後端
                    obj.insert_c();
                    break;
                case 6:
                    obj.reverse();
                    break;
                case 7:
                    System.exit(0);
                    break;
            
            }
        
        
        }
    }      
}
