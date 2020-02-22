/************************************************
* 為使方便，因此簡化了環狀串列，主要示範兩個串列之連結
* 插入僅保留插入至前端，且可以自行指定資料，不必輸入
* 以及保留基本的輸出功能
* 另外在串列之類別的static，是因為只有一個串列
* 當多個串列時若宣告static，每個串列仍會使用同一個結構
************************************************/
package LinkLIst;

class Node2{
    public int data;
    public Node2 next;
    
}

class CircularLinkList1 {
    
    Node2 ptr,head,current,tail,forward;
    
    CircularLinkList1(){
        head=new Node2();
        head.next=head; //當一開始創立串列，就要將自己與自己串聯
    
    }
    
    public void insert_h(int inpu){ 
        
        ptr=new Node2();
        ptr.data=inpu;
        ptr.next=head.next;
        head.next=ptr;

    
    }    
    
    public void print(){
        current=head.next;
        while(current!=head){
            System.out.printf("%d ",current.data);
            current=current.next;
        }
        System.out.println();
    }
    
    public static void link(CircularLinkList1 linkA,CircularLinkList1 linkB){
        linkA.tail=linkA.head.next;
        while (linkA.tail.next!=linkA.head){
            
            linkA.tail=linkA.tail.next;
            
        }
        linkA.tail.next=linkB.head.next;
        
        linkB.tail=linkB.head.next;
        while (linkB.tail.next!=linkB.head){
            
            linkB.tail=linkB.tail.next;
            
        }
        
        linkB.tail.next=linkA.head;
        
        linkB.head=null;
    }
        

    public static void main(String[] args) {
        CircularLinkList1 linkA = new CircularLinkList1();
        CircularLinkList1 linkB = new CircularLinkList1();
        linkA.insert_h(50);linkA.insert_h(70);linkA.insert_h(80);linkB.insert_h(100);linkB.insert_h(200);
        System.out.print("linkA:");
        linkA.print();
        System.out.print("linkB:");
        linkB.print();
        //合併
        link(linkA,linkB);
        System.out.println("進行合併之後:");
        linkA.print();

    }
    
}
