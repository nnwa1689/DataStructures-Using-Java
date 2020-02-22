package Graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hazuya
 */

class Node2{
    int v;
    Node2 link;
}

class BFStest {
    
    final static int maxVer = 100;    //最大節點數
    
    Node2 Node2 = new Node2();
    Node2 lastNode2 = new Node2();
    static Node2[] adjlist = new Node2[maxVer + 1];    //相鄰串列
    static boolean[] visit = new boolean[maxVer + 1];       //紀錄是否已被走訪
    static int totalVer = 0;
    
    public void buildAdj(){
        
        int vi = 0, vj = 0, weight = 0; //節點V(i, j) 以及 路徑之權重
        Scanner input = null;
        
        try{
        
            input = new Scanner(new FileInputStream("dfs.txt")); //讀入資料檔
        
        }catch(FileNotFoundException e){  //接取檔案讀取錯誤例外
        
            System.out.print("dfs.txt not found.");
            System.exit(1); //離開程式
        
        }
        
        totalVer = input.nextInt();     //總結點數量
        
        //建立串列首與預設尚未走訪
        for(vi = 1; vi <= totalVer; vi++){
        
            visit[vi] = false; //預設尚未走訪
            adjlist[vi] = new Node2(); //建立串列首
            adjlist[vi].v = vi;     //節點
            adjlist[vi].link = null;
        
        }
        
        //讀取節點
        for(vi = 1; vi <= totalVer; vi++){
        
            for(vj = 1; vj <= totalVer; vj++){
            
                weight = input.nextInt();  //取得V(i,j)路徑權重
                
                if(weight != 0){        //如果V(i,j)權重不為0，則加入串列
                
                    Node2 = new Node2();
                    Node2.v = vj;    //節點
                    lastNode2 = searchlast(adjlist[vi]);     //將其串入相鄰串列的後面
                    lastNode2.link = Node2;
                
                }
            
            }
        
        }
        
        input.close();
        
    }
    
    //列出相鄰串列
    public void showAdj(){
    
        Node2 ptr = new Node2();
        
        System.out.println("Head        adjacencyNode2");
        System.out.println("=========================");
        
        for(int index = 1; index <= totalVer; index++){
        
            System.out.printf("V%d  ", adjlist[index].v);
            ptr = adjlist[index].link;
            while(ptr != null){
                          
                System.out.printf("=>V%d   ", ptr.v);
                ptr = ptr.link;
            
            }
            
            System.out.println();
        
        }
        
        
        
    }
    
    //進行BFS走訪    
    public void bfs(int v){
    
        Node2 ptr = new Node2();
        
        for(int vi = v; vi<=totalVer; vi++){
            
            ptr = adjlist[vi];
            
            while(ptr != null){
                
                if(visit[ptr.v] != true){
                    
                    System.out.printf("V%d, ", ptr.v);
                    visit[ptr.v] = true;
                    
                }
                
                ptr = ptr.link;
                
            }
            
        }
        
    }
    
    //尋找串列末端
    public Node2 searchlast(Node2 ll){
        
        Node2 ptr = new Node2();
        ptr = ll;
        while(ptr.link != null){
            
            ptr = ptr.link;
            
        }
        return ptr;
        
    }

    //主函數
    public static void main(String[] args) {
        BFStest bfs = new BFStest();
        bfs.buildAdj();
        bfs.showAdj();
        bfs.bfs(1);
    }
    
}
