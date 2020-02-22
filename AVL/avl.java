package AVL;

import java.util.Scanner;

class node {

    int data;
    int bf;
    node llink, rlink;

}

public class avl {

    node ptr, root, current, prev, pivot, pivot_prev;
    Scanner input = new Scanner(System.in);

    public void insert() {

        System.out.println("Input data:");
        int data = input.nextInt();
        if (search(data) == null) {

            node ptr = new node();
            ptr.data = data;
            if (root == null) {
                root = ptr;
                root.bf = 0;
                System.out.println("Data Insert!!!(ROOT)");
            } else if (root != null) {

                current = root;
                while (current != null) {
                    prev = current;
                    if (ptr.data > current.data) {
                        current = current.rlink;
                    } else if (ptr.data < current.data) {
                        current = current.llink;
                    }
                }
                if (ptr.data > prev.data) {
                    prev.rlink = ptr;
                } else if (ptr.data < prev.data) {
                    prev.llink = ptr;
                }
                System.out.println("Data Insert!!!");
                bf(root);//每次插入都重新計算BF
                pivot = find_pivot();//尋找不平衡
                System.out.printf("RETURN PIVOT  %d\n", pivot != null ? pivot.data : 0);
                if (pivot != null) {
                    int op = find_type();
                    switch (op) {

                        case 11: //LL
                            LL();
                            break;
                        case 12://LR
                            LR();
                            break;
                        case 21://RL
                            RL();
                            break;
                        case 22://RR
                            RR();
                            break;

                    }

                }
            }

        } else if (search(data) != null) {
            System.out.println("Data 重複");
        }

    }

    public void del() {
        int del = input.nextInt();
        node rel=null, rer = null, parent = null;
        node delnode = search(del);
        if (delnode == null) {
            System.out.println("Data not find.");
        } else {
            if (delnode.rlink == null && delnode.llink == null)//刪除樹葉節點
            {
                if (delnode == root) {
                    root = null;
                } else {
                    current = root;
                    while (current != null && current.data != delnode.data) {
                        if (current.rlink.data == delnode.data) {
                            parent = current;
                        }
                        else if (current.llink.data == delnode.data) {
                            parent = current;
                        }
                        if (current.data > delnode.data) {
                            current = current.llink;
                        }
                        else if (current.data < delnode.data) {
                            current = current.rlink;
                        }

                    }
                    if (parent.llink.data == delnode.data) {
                        parent.llink = null;
                    } else {
                        parent.rlink = null;
                    }
                    delnode = null;
                    System.out.println("DEL");
                }
            } else {
                //找尋替代節點-右最小
                current = delnode.rlink;
                while (current != null && current.llink != null) {
                    current = current.llink;
                }
                rer = current;
                //尋找右節點
                if (rer == null) {
                    current = delnode.llink;
                    while (current != null && current.rlink != null) {
                        current = current.rlink;
                    }
                    rel = current;
                }
                //尋找RE父節點
                current = root;
                if (rer != null) {
                    System.out.println(rer.data);
                    int i=0;
                    while (current != null && current.data != rer.data) {
                        i++;
                        if (current.rlink.data == rer.data) {
                            System.out.print("parent Find");
                            parent = current;
                        }else if (current.llink.data == rer.data) {
                            parent = current;
                        }
                        if (current.data > rer.data) {
                            System.out.printf("L %d \n",i);
                            current = current.llink;
                        }else if (current.data < rer.data) {
                            System.out.printf("R %d\n",i);
                            current = current.rlink;
                        }

                    }
                    if(rer.data>parent.data)
                        parent.rlink = rer.rlink;
                    else
                        parent.llink=rer.rlink;
                    delnode.data = rer.data;
                    rer = null;

                } else if (rel != null) {
                    while (current != null && current.data != rel.data) {
                        if (current.llink.data == rel.data) {
                            parent = current;
                        }
                        else if (current.rlink.data == rel.data) {
                            parent = current;
                        }
                        if (current.data > rel.data) {
                            current = current.llink;
                        }
                        else if (current.data < rel.data) {
                            current = current.rlink;
                        }

                    }
                    if(parent.data>rel.data)
                        parent.llink = rel.llink;
                    else
                        parent.rlink=rel.llink;
                    delnode.data = rel.data;
                    rel = null;
                    

                }
                
                System.out.println("DEL");

            }
            bf(root);
            int op = 0;
            pivot = find_pivot();
            if (pivot != null) {
                op = find_type();
                switch (op) {
                    case 11: //LL
                        LL();
                        break;
                    case 12://LR
                        LR();
                        break;
                    case 21://RL
                        RL();
                        break;
                    case 22://RR
                        RR();
                        break;
                }
            }

        }
    }

    public void LL() {
        node pivot_next, temp;
        pivot_next = pivot.llink;
        temp = pivot_next.rlink;
        pivot_next.rlink = pivot;
        pivot.llink = temp;
        if (pivot == root) {
            root = pivot_next;
        } else {//判斷pivot是父節點的左還是右子點

            if (pivot_prev.llink == pivot) {
                pivot_prev.llink = pivot_next;
            } else {
                pivot_prev.rlink = pivot_next;
            }

        }
    }

    public void RR() {
        node temp, pivot_next;
        pivot_next = pivot.rlink;
        temp = pivot_next.llink;
        pivot_next.llink = pivot;
        pivot.rlink = temp;
        if (pivot == root) {
            root = pivot;
        } else {
            if (pivot_prev.llink == pivot) {
                pivot_prev.llink = pivot_next;
            } else {
                pivot_prev.rlink = pivot_next;
            }
        }
    }

    public void LR() {
        node temp, pivot_next;
        pivot_next = pivot.llink;
        temp = pivot_next.rlink;
        pivot.llink = temp.rlink;//將TEMP的右節點放到右邊(就是PIVOT的左鏈結)
        pivot_next.rlink = temp.llink;//將TEMP的左節點放到左邊(就是PIVOTNEXY的右連結)
        temp.rlink = pivot;   //PIVOT_NEXT一定小於PIVOT
        temp.llink = pivot_next;
        if (pivot == root) {
            root = temp;
        } else {
            if (pivot_prev.llink == pivot) {
                pivot_prev.llink = temp;
            } else {
                pivot_prev.rlink = temp;
            }
        }
    }

    public void RL() {
        node temp, pivot_next;
        pivot_next = pivot.rlink;
        temp = pivot_next.llink;
        pivot.rlink = temp.llink;
        pivot_next.llink = temp.rlink;
        temp.rlink = pivot_next;//PIVOT_NEXT一定大於PIVOT
        temp.llink = pivot;
        if (pivot == root) {
            root = temp;
        } else {
            if (pivot_prev.llink == pivot) {
                pivot_prev.llink = temp;
            } else {
                pivot_prev.rlink = temp;
            }
        }

    }

    public int find_type() {
        int op = 0;
        current = pivot;
        for (int i = 0; i < 2; i++) {
            if (current.bf > 0) { //左子樹較高
                current = current.llink;
                if (op == 0) {
                    op += 10;
                } else {
                    op++;
                }
            } else if (current.bf < 0) { //右子樹較高
                current = current.rlink;
                if (op == 0) {
                    op += 20;
                } else {
                    op += 2;
                }
                //11:LL，22:RR，12:LR、22:RR
            }
        }
        return op;
    }

    public node find_pivot() {

        current = root;
        pivot = null;
        while (current != null) {
            if (current.bf > 1 || current.bf < -1) {//當節點的BF絕對值大於1時，紀錄該點
                pivot = current;
                if (pivot != root) {
                    pivot_prev = prev;
                }
                //如果不是ROOT，需要追蹤前一個節點，為何需要追蹤請隨便舉例一種簡單的旋轉方式即可
                System.out.printf("PIVOT FIND:%d\n", current.data);
            }
            if (current.bf > 0) {//BF=左-右，大於代表左邊要調整，小於代表左邊要調整
                prev = current;
                current = current.llink;
            } else if (current.bf < 0) {
                prev = current;
                current = current.rlink;
            } else {//當上面情況都不是，代表平衡，讓current隨意向下直到為null結束迴圈
                current = current.llink;
            }
        }
        return pivot;
    }

    public node search(int set) {//搜尋方式與BST相同

        current = root;
        while (current != null) {
            prev = current;
            if (set > current.data) {
                current = current.rlink;
            } else if (set < current.data) {
                current = current.llink;
            } else if (set == current.data) {
                break;
            }
        }
        return current;
    }

    public void bf(node node) {

        if (node != null) {
            //利用後序走訪計算BF

            bf(node.llink);
            bf(node.rlink);
            System.out.printf("NODE LLINK HEI:%d    NODE RLINK HEI:%d   ", height(node.llink), height(node.rlink));
            node.bf = height(node.llink) - height(node.rlink);
            System.out.printf("BF %d\n", node.bf);
        }

    }

    public int height(node node) {

        if (node != null) {
            //當傳入的節點之左右子樹為空時
            if (node.rlink == null && node.llink == null) {
                return 1;
            } else {
                return 1 + (height(node.llink) > height(node.rlink) ? height(node.llink) : height(node.rlink));
            }
            //分別堆疊計算左右子樹高，回傳較大者  
        }
        return 0;

    }

    public void list() {
        if (root != null) {
            inorder(root);
        } else {
            System.out.println("Tree is null!");
        }
    }

    public void inorder(node node) {
        if (node != null) {
            inorder(node.llink);
            System.out.printf("%d ", node.data);
            inorder(node.rlink);
        }
    }

    public static void main(String[] args) {
        avl obj = new avl();
        Scanner input = new Scanner(System.in);
        System.out.println("<1>插入 <2>刪除 <3>印出");
        while (true) {
            int doing = input.nextInt();
            switch (doing) {
                case 1:
                    obj.insert();
                    break;
                case 2:
                    obj.del();
                    break;
                case 3:
                    obj.list();
                    break;
            }
        }
    }

}
