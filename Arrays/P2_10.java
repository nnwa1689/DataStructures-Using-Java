/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

/**
 *
 * @author user
 */
public class P2_10 {

    public static void main(String[] args) {
        int[][] a=new int [3][3];
        int[][] b= new int [3][3];
        a[0][0]=1;a[0][1]=2;a[0][2]=3;
        a[1][0]=4;a[1][1]=5;a[1][2]=6;
        a[2][0]=7;a[2][1]=8;a[2][2]=9;
        
        b[0][0]=1;b[0][1]=2;b[0][2]=3;
        b[1][0]=1;b[1][1]=2;b[1][2]=3;
        b[2][0]=1;b[2][1]=2;b[2][2]=3;
        int[][] c =new int [3][3];
        int sum=0;
        
        for (int i =0;i<a.length;i++){//控制A矩陣
            for (int j =0;j<b.length;j++){//控制B矩陣
                for (int x=0;x<a.length;x++){//控制目前正在乘的(?)
                  sum+=a[i][x]*b[x][j];  
                }
                c[i][j]=sum;
                sum=0;
            }
        }
        
        for (int s=0;s<c.length;s++){
            for (int z=0;z<c.length;z++){
                System.out.printf("%d ",c[s][z]);
            }
            System.out.println();
        }
    }
    
}
