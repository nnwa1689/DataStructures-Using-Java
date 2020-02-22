
/*************Exhaustion窮舉解**************
*簡單來說就是上下左右嘗試
*如果可以就移動，不行就代表死路，直接回傳失敗
*0:表示無障礙
*1:表示點
*2:表示障礙
********************************************/
package Arrays;

public class Mouse {

    int[][] maze = {
        {2, 2, 2, 2, 2, 2, 2},
        {2, 0, 0, 0, 0, 0, 2},
        {2, 0, 0, 0, 2, 0, 2},
        {2, 0, 0, 0, 0, 2, 2},
        {2, 2, 0, 2, 0, 2, 2},
        {2, 0, 0, 0, 0, 0, 2},
        {2, 2, 2, 2, 2, 2, 2}};
    
    int[][] stack=new int[7][7];//用來紀錄沒有過的路
    int top=0;
    
    
    int start_i=1,start_j=1,end_i=5,end_j=5;
    boolean flag=false;
    
    public void route(){
        
        if(go(start_i,start_j)==false)
            System.out.println("已經沒路了!");
        else{

            //印出路徑
            for(int i =0;i<maze.length;i++){
                for(int j =0;j<maze[i].length;j++){
                    
                    switch(maze[i][j]){
                        case 0:
                            System.out.print(" ");
                            break;
                        case 1:
                            System.out.print("@");
                            break;
                        case 2:
                            System.out.print("*");
                    }
                    
                }
                System.out.println("");
            }
            
            route();
            
        }
        
    }
    
    public boolean go(int i,int j){
        
        maze[i][j]=1;//走過的點改成1
        if(i==end_i && j==end_j){ //成功的話回傳TRUE
            flag=true;
        }
        //嘗試
        if(flag==false && maze[i][j+1]==0)
            go(i,j+1);
        if(flag==false && maze[i+1][j]==0)
            go(i+1,j);
        if(flag==false && maze[i][j-1]==0)
            go(i,j-1);
        if(flag==false && maze[i-1][j]==0)
            go(i-1,j);
        //失敗
        if(flag==false)
            maze[i][j]=0;
            
        return flag;
    }
    
    
    public void map(){
        /*印地圖*/
        
        for(int i =0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                
                switch(maze[i][j]){
                    
                    case 0:
                        System.out.print(" ");
                        break;
                    case 2:
                        System.out.print("*");
                    
                }
                
                
            }
            System.out.println("");
        }
    
    }

    public static void main(String[] args) {
        
        System.out.println("MAP");
        Mouse obj = new Mouse();
        obj.map();
        System.out.println("ANS:");
        obj.route();

    }

}
