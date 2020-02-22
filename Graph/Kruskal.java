/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.io.FileInputStream;
import java.util.Scanner;
import sun.applet.Main;

/**
 *
 * @author wucongen
 */

class Edge{ //紀錄邊
    
    int v1; //點1
    int v2; //點2
    int weight; //邊權重
    boolean edge_del;   //邊是已被刪除（已被選出）
    
}

class Graph{

    int[] v = new int[100];
    int edges;

}

public class Kruskal {
    
    int MAXV = 100; //最大節點數
    
    Graph T = new Graph();  //紀錄Kruskal算法已經加入的節點以及邊個數
    Edge[] E = new Edge[MAXV];  //紀錄相鄰矩陣中所有存在的邊
    int total_e = 0;    //總邊個數
    int total_v = 0;    //總結點個數
    int[][] adjmat = new int[MAXV][MAXV];   //相鄰矩陣
    
    public void build_mat(){    //建立相鄰矩陣
    
        Scanner input = null;
        
        //InputAdjmat.
        try{
        
            input = new Scanner(new FileInputStream("kruskal.txt"));
            
        }catch(Exception e){
        
            System.err.print("File Open Error!");
            System.exit(1);
        
        }
        
        total_v = input.nextInt();
        for(int vi = 1; vi <= total_v; vi++){   //vi及vj從1開始,0不用
        
            for(int vj = 1; vj <= total_v; vj++){
            
                adjmat[vi][vj] = input.nextInt();
                
            }
        
        }
        //close file
        input.close();
    
    }
    
    public void creatEdge(){    //依照相鄰矩陣建立邊
    
        int weight = 0;
        
        for(int i = 1; i <= total_v; i++){
        
            for(int j = i + 1; j <= total_v; j++){
                
                if(adjmat[i][j] != 0){  //如果權重不為0
                    
                    Edge e = new Edge();    //建立一個新的邊
                    e.v1 = i;
                    e.v2 = j;
                    e.weight = adjmat[i][j];
                    e.edge_del = false;

                    E[++total_e] = e;   //將邊加入陣列
                
                }
                
            }
        
        }
    
    }
    
    public void showEdge(){ //印出邊與點的關係
    
        System.out.printf("Total V : %d, Total E = %d \n", total_v, total_e);
        
        for(int i = 1; i <= total_e; i++){
        
            System.out.printf("%s <---> %s  weight = %d \n", E[i].v1, E[i].v2, E[i].weight);
            
        }
        
    }
    
    public Edge findMinedge(){  //尋找最小邊
    
        int min = 0, minweight = 100000;    //初始化邊為極大值
        for(int i = 1; i <= total_e; i++){
        
            if((E[i].edge_del != true) && E[i].weight < minweight){ //循序尋找目前成本最低邊
                
                minweight = E[i].weight;
                min = i;
            
            }
            
        }
        E[min].edge_del = true; //找到之後標記已經輸出並回傳
        return E[min];
    
    }
    
    public boolean cyclic(Edge e){  //檢查是否循環
    
        //先假設無循環，並將該邊加入最小成本擴展圖
        T.v[e.v1]++;    //這裡是紀錄如果加入這個邊，點被加入的次數
        T.v[e.v2]++;
        T.edges++;
        
        //當加入這個邊時，如果兩個點都已經曾經被加入過，代表形成循環
        if(T.v[e.v1] >= 2 && T.v[e.v2] >= 2){
        
            T.v[e.v1]--;
            T.v[e.v2]--;
            T.edges--;
            return true;
            
        }
        else
            return false;
    }
    
    
    public void kruskal(){
    
        int steps = 1;  //次數
        
        //初始化圖形中的節點被加入次數
        for(int i = 0; i <= total_v; i++)
            T.v[i] = 0;
        T.edges = 0;
        
        System.out.println("_________min.Cost Spanning Tree using kruskal_________");
        
        while(T.edges < total_v - 1){   //當加入的邊小於總結點個數減一，則執行
        
            Edge e = findMinedge();
            
            if(cyclic(e) == false){
            
                System.out.printf("Step %d. V%d  <----> V%d  weight = %d \n", steps++, e.v1, e.v2, e.weight);
                
            }
            
        }
        
    }
    
    public static void main(String[] args){
    
        Kruskal k = new Kruskal();
        
        k.build_mat();
        k.creatEdge();
        k.showEdge();
        k.kruskal();
    
    }
    
}
