/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PushAndFront;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


/**
 *
 * @author user
 */
public class push {

    

    
    public static int[] pop(int[] st){
    
        return st;
    }
    
    public static void show(int[] st){
    
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(50);
        System.out.println(stack.peek());
        Scanner input=new Scanner(System.in);
        System.out.println("Please Keyin MAX:");
        int max = input.nextInt();
        String[] st=new String[max];
        int top=-1;
        System.out.println("<1>insert  <2>delete  <3>showData  <4>exit");
        while(true){    
            int inpu=input.nextInt();
            if(inpu==1){
                if(top>=max-1){
                    System.out.println("堆疊已經滿了!!!");
                }
                else{
                    top++;
                    System.out.print("請輸入要加入的資料:");
                    st[top]=input.next();
                    System.out.println("資料已加入");
                }
            }
            else if(inpu==2){
                if (top<0){
                    System.out.println("堆疊是空的!!");
                }
                else{
                    st[top]="";
                    top--;
                    System.out.println("資料已被刪除");
                    }
            }
            else if (inpu==3){
                if(top<0){
                    System.out.println("堆疊是空的!!");
                }
                else{
                    for (int i =top;i>-1;i--){
                      System.out.println(String.format("st [ %d ]  = %s ",i,st[i]));
                    }
                }
                
            }
            else if (inpu==4){
                System.exit(0);
            }
        }
    }
    
}
