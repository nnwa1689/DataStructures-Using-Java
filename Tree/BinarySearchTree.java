
package Tree;

import java.util.Scanner;

class Node{
    
    int data;
    Node llink;
    Node rlink;

}

public class BinarySearchTree {
    
    Node root,ptr,re_node;
    Scanner input = new Scanner(System.in);

    public BinarySearchTree() {
        
        root=null;
        
    }
    
    
    public void insert(){ //插入節點
        
        ptr=new Node();
        System.out.println("Input DATA:");
        ptr.data=input.nextInt();
        if(search(ptr.data)!=null){
            System.out.println("該筆資料已經存在");
        }
        else{
            
            ptr.rlink=ptr.llink=null;
            if (root==null){ //判斷樹根
                root=ptr;
                System.out.println("Node Insert!!!(ROOT)");
            }
            else{
                
                Node current = new Node(); //用於尋找適合插入的節點
                current=root;
                Node prev = new Node();
                while (current!=null){
                    
                    prev=current;
                    if(current.data>ptr.data) //如果樹根大於節點，向左
                        current=current.llink;
                    else
                        current=current.rlink;
                    
                }
                if(prev.data>ptr.data) //如果樹根大於節點，插入左方
                    prev.llink=ptr;
                else
                    prev.rlink=ptr;
                System.out.println("Node Insert!!!");
            }
        
        }
                
    
    }
    
    public void del(){
        
        Node del_node=new Node();
        System.out.println("Input DEL DATA:");
        del_node.data=input.nextInt();
        if(search(del_node.data)==null)
            System.out.println("Data Not Find!");
        else{
            del_node=search(del_node.data);
            if(del_node.rlink==null && del_node.llink==null){ //若刪除為樹葉，直接刪掉
                if(del_node==root)  //若刪除的不是樹根，必須先移除父節點的鍊節
                    root=null;
                
                else{
                    
                    Node parent=parent(del_node);
                    if(del_node.data>parent.data) //若要刪除的節點為父的右子樹
                        parent.rlink=null;
                    else if(del_node.data<parent.data)
                        parent.llink=null;
                
                }
                del_node=null;
            
            }
            else{ //如果不是，要找左或右的替代節點
                if(re_r(del_node.rlink)!=null)
                   re_node=re_r(del_node.rlink); 
                  
                else
                    re_node=re_l(del_node.llink);
                System.out.printf("RENODE:%d\n",re_node.data);
                Node parent=parent(re_node); //尋找替代節點的父節點
                System.out.printf("parent:%d\n",parent.data);
                //判斷替代節點為父節點的左子還右子樹
                if(re_node.data>parent.data){ //替代節點為右子
                    //替代節點不是有右子樹就是有左子樹，否則為樹葉節點，不會同時有左或右子樹，如果有代表不符合替代節點的規則
                    if(re_node.llink!=null)//右子為空
                        parent.rlink=re_node.llink;
                    else if(re_node.rlink!=null)//左子為空
                        parent.rlink=re_node.rlink;
                    else    //樹葉
                        parent.rlink=null;
                    
                }
                else{   //替代節點為左
                    if(re_node.llink!=null)//右子為空
                        parent.llink=re_node.llink;
                    else if(re_node.rlink!=null)//左子為空
                        parent.llink=re_node.rlink;
                    else    //樹葉
                        parent.llink=null;
                }
                //System.out.printf("%d %d \n",del_node.data,re_node.data);
                del_node.data=re_node.data; 
                /*if(del_node==parent){ //如果刪除的結點恰為父節點，需檢查最後是否符合二元搜尋樹的定義
                    if(parent.llink!=null && parent.rlink==null){
                        
                        if(parent.llink.data>parent.data){ //如果左結點大於父節點則要調整
                            parent.rlink=parent.llink;
                            parent.llink=null;
                        }
                        
                    }
                    else if(parent.rlink!=null && parent.llink==null){
                        if(parent.rlink.data<parent.data){
                            parent.llink=parent.rlink;
                            parent.rlink=null;
                        }
                    }
                    else if(parent.rlink!=null && parent.llink!=null){
                        Node temp;
                        if(parent.rlink.data<parent.data){
                            temp=parent.rlink;
                            parent.rlink=parent.llink;
                            parent.llink=temp;
                        }
                    }
                    
                }*/
               
               System.out.printf("DEL:%d,P:%d",del_node.data,parent.data);
               del_node=re_node;
               re_node=null;
            }
                
            
        }
        
    }
    
    
    public Node re_l(Node node){ //傳入要刪除的節點的左端節點
        
        Node current = node;
        while (current!=null && current.rlink!=null){
           
            current=current.rlink; //由於左端要找最大，最大的一定向右找

        }
        return current;
    }
    
    public Node re_r(Node node){
        
        Node current=node;
        while (current!=null && current.llink!=null){
            
            current=current.llink;
        
        }
        return current;
    }
    
    public Node parent(Node node){
        
        Node parent=root;
        while(parent!=null){
            
            if(node.data>parent.data){
                if(parent.rlink==node)
                    return parent;
                else
                    parent=parent.rlink;
            }
            else if(node.data<parent.data){
                
                if(parent.llink==node)
                    return parent;
                else
                    parent=parent.llink;
                
            }
               
        }
        return null;
    }
    
    
    public Node search(int s){
        
        Node current=root;
        while (current!=null){
            
            if(current.data==s)
                break;
            else{
                if(current.data>s)
                  current=current.llink;
                else if(current.data<s)
                 current=current.rlink;
            }
            
        }
        return current;
    }
    
    public void inordor(Node node){
        
        if(node!=null){
            inordor(node.llink);//走訪左
            System.out.printf("%d ",node.data);//訪樹根
            inordor(node.rlink);//走訪右
        }
    }
    
    public void show(){
        
        if(root!=null){
            
            ptree(root,1);
            System.out.println("INORDOR : ");
            inordor(root);
        }
        else
            System.out.println("TREE IS NULL!");
        
    }
    
    public void ptree(Node tree,int lev){
        
        if(root!=null){
            
            if(tree.rlink!=null)
                ptree(tree.rlink,lev+1);
            int i;
            for(i=1;i<lev;i++)
                System.out.printf("\t");
            System.out.printf("%d\n",tree.data);
            if(tree.llink!=null)
                ptree(tree.llink,lev+1);
            
        
        }
        
    }
    
    public static void main(String[] args) {
        
        BinarySearchTree obj=new BinarySearchTree();
        Scanner input = new Scanner (System.in);
        System.out.println("1.Insert 2.Del 3.中序走訪 4.PTREE");
        while (true){
            
            int doing=input.nextInt();
            switch(doing){
                case 1:
                    obj.insert();
                    break;
                case 2:
                    obj.del();
                    break;
                case 3:
                    obj.show();
                    break;
                
                
            }
            
        }
        
    }
    
}
