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
public class Queue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = 3;
        String[] q = new String[max];
        int rear = -1;
        int front = 0;
        while (true) {
            System.out.println("<1>insert <2>del <3>print <4>exit");
            int inpu = input.nextInt();
            if (inpu == 1) { //加入佇列
                if (rear >= max - 1) {
                    System.out.println("佇列已經滿了");
                } else {
                    System.out.println("請輸入要加入的資料:");
                    String insertdata = input.next();
                    rear++;
                    q[rear] = insertdata;

                }
            } else if (inpu == 2) { //刪除佇列
                if (front > rear) {
                    System.out.println("此佇列為空");

                } else {
                    System.out.println(q[front] + " 已被刪除!");
                    q[front] = "";
                    front++;
                }

            } else if (inpu == 3) { //顯示佇列
                if (rear > 0 && !(front > rear)) {
                    for (int i = front; i <= rear; i++) {
                        System.out.println(q[i]);
                    }
                } else {
                    System.out.println("此佇列為空!");
                }

            } else if (inpu == 4) {
                break;

            }
        }
    }
}
