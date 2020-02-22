/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PushAndFront;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class CircularQueue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = 3;
        String[] q = new String[max];
        int rear = max - 1;//Let rear and front 初始為max-1
        int front = max - 1;
        int tag = 0;//輔助判斷，0:未滿，1:已滿
        while (true) {
            System.out.println("<1>insert <2>del <3>print <4>exit");
            int inpu = input.nextInt();
            if (inpu == 1) { //加入佇列
                if (rear == front && tag == 1) { //佇列已滿
                    if (rear == 0) {
                        rear = max - 1; //rear為0時，使rear回預設值
                    } else {
                        rear--; //若rear非預設值，則退回上一個rear
                    }
                    System.out.println("佇列已經滿了");
                } else {
                    System.out.println("請輸入要加入的資料:");
                    rear = (rear + 1) % max; //取得新的rear(%max是為了使rear循環)
                    String insertdata = input.next();
                    q[rear] = insertdata;

                    if (front == rear) {
                        tag = 1;//每次加入佇列之後，判斷是否已經滿了
                    }
                }

            } else if (inpu == 2) { //刪除佇列
                if (front == rear && tag == 0) {
                    System.out.println("此佇列為空");
                } else {
                    front = (front + 1) % max;
                    System.out.println(q[front] + " 已被刪除!");
                    q[front] = null;
                    if (front == rear) {
                        tag = 0;
                    }
                }

            } else if (inpu == 3) { //顯示佇列
                if (rear == front && tag == 0) {
                    System.out.println("此佇列為空!");
                } else {
                    for (int i = 0; i < max; i++) {
                        if (q[i] != null) {
                            System.out.println(q[i]);
                        }
                    }

                }

            } else if (inpu == 4) { //退出迴圈
                break;
            }
        }
    }
}
