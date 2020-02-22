package Treap;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class node {

    int data;
    int fix;
    node llink, rlink;

}

public class Treap {

    node root, current, prev, parent;
    Scanner input = new Scanner(System.in);
    Random rnd = new Random();
    ArrayList fixarr = new ArrayList();//存放HEAP優先順序的陣列

    public void insert() {

        node ptr = new node();
        System.out.println("PLEASE INPUT DATA:");
        ptr.data = input.nextInt();

        if (search(ptr.data) != null) {
            System.out.println("資料已存在");
        } else {
            ptr.fix = rnd.nextInt(10000 + 1);
            for (int i = 0; i < fixarr.size(); i++) {//檢查隨機優先順序是否重複

                boolean ser = fixarr.contains(ptr.fix);
                if (ser) {
                    ptr.fix = rnd.nextInt(10000 + 1);
                }

            }
            if (root == null) {

                root = ptr;
                System.out.println("Insert Data! (ROOT)");
                System.out.println(ptr.fix);

            } else {

                current = root;
                while (current != null) {
                    prev = current;
                    if (ptr.data > current.data) {
                        current = current.rlink;
                    } else {
                        current = current.llink;
                    }

                }
                if (ptr.data > prev.data) {
                    prev.rlink = ptr;
                    if (prev.fix > prev.rlink.fix) {
                        left(prev);
                    }

                } else {
                    prev.llink = ptr;
                    if (prev.fix > prev.llink.fix) {
                        right(prev);
                    }

                }

                System.out.println("Insert Data!");
                System.out.println(ptr.fix);

            }
        }

    }

    //找到要旋轉的上一個節點才能轉
    public node findparent(int data) {
        current = root;
        while (current.rlink!= null || current.llink!=null) {
            if (current.rlink.data == data || current.llink.data == data) {
                return current;
            }
            else if(data>current.data){
                current=current.rlink;
            }else{
                current=current.llink;
            }
        }
        return null;

    }

    public void right(node a) {

        if (a != root) {
            node b = a.llink;
            node temp = b.rlink;
            node parent = findparent(a.data);
            a.llink = temp;
            b.rlink = a;
            if(parent.data>a.data){
                parent.rlink=b;
            }else{
                parent.llink=b;
            }
        }else{
            node b=a.llink;
            node temp=b.rlink;
            root=b;
            a.llink=temp;
            b.rlink=a;
        }
        System.out.println("右璇");

    }

    public void left(node a) {

        if (a != root) {
            node b = a.rlink;
            node temp = b.llink;
            node parent = findparent(a.data);
            a.rlink = temp;
            b.llink = a;
            if(parent.data>a.data){
                parent.rlink=b;
            }else{
                parent.llink=b;
            }
        }else{
            node b=a.rlink;
            node temp=b.llink;
            a.rlink=temp;
            b.llink=a;
        }
        System.out.println("左旋");

    }

    public void ptree(node tree, int lev) {

        if (root != null) {

            if (tree.rlink != null) {
                ptree(tree.rlink, lev + 1);
            }
            int i;
            for (i = 1; i < lev; i++) {
                System.out.printf("\t");
            }
            System.out.printf("%d\n", tree.data);
            if (tree.llink != null) {
                ptree(tree.llink, lev + 1);
            }

        }

    }

    public void show() {

        if (root != null) {
            //ptree(root, 1);
            inordor(root);
        } else {
            System.out.println("Treap Is Null!");
        }

    }

    public void inordor(node node) {

        if (node != null) {
            inordor(node.llink);
            System.out.printf("%d ", node.data);
            inordor(node.rlink);
        }

    }

    public node search(int num) {
        current = root;
        while (current != null) {
            if (current.data == num) {
                break;
            } else {
                if (num > current.data) {
                    current = current.rlink;
                } else if (num < current.data) {
                    current = current.llink;
                }
            }
        }
        return current;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Treap obj = new Treap();
        while (true) {
            int doing = input.nextInt();
            switch (doing) {
                case 1:
                    obj.insert();
                    break;
                case 2:
                    obj.show();
            }
        }

    }

}
