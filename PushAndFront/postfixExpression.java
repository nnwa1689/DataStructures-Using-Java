package PushAndFront;

import java.util.Scanner;

public class postfixExpression {

    public static int geticp(char text) { //取得ICP
        int icp = 0;
        switch (text) {
            case '(':
                icp = 4;
                break;
            case '*':
            case '/':
                icp = 2;
                break;
            case '+':
            case '-':
                icp = 1;
                break;
            default:
                break;
        }
        return icp;
    }

    public static int getisp(char text) {   //取得ISP
        int isp = 0;
        switch (text) {
            case '(':
                isp = 0;
                break;
            case '*':
            case '/':
                isp = 2;
                break;
            case '+':
            case '-':
                isp = 1;
                break;
        }
        return isp;
    }

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.print("--------------------\n");
        System.out.print("----有效運算子:------\n");
        System.out.print("/(除)、*(乘)、+(加)、-(減)、(、)\n");
        System.out.print("---------------------\n");
        System.out.print("請輸入中序運算式：");
        String str = key.nextLine();

        char[] infix = new char[str.length() + 1]; /*建立一個陣列，將運算式放入*/
        char[] stack_t = new char[str.length()]; /*放入還不用輸出的字元*/
        int top = 0; //堆疊TOP，0不使用
        for (int i = 0; i < str.length(); i++) {
            infix[i] = str.charAt(i);
        }
        infix[str.length()] = '#'; /*在運算式末端加上#代表結束*/
        int icp = 0;
        int isp = 0;
        for (int j = 0; j < infix.length; j++) {
            switch (infix[j]) {   //判斷為運算子或運算元
                case ')':
                    while (stack_t[top] != '(') { //輸出直到(
                        System.out.print(stack_t[top]);
                        top--;
                    }
                    stack_t[top] = '\0'; /*將(清除*/
                    top--;
                    break;
                case '#':
                    for (int s = top; s >= 0; s--) { /*輸出堆疊中剩餘的字元*/
                        if (stack_t[s] != '\0') {
                            System.out.print(stack_t[s]);
                        }
                    }
                    break;
                case '(':
                case '*':
                case '/':
                case '+':
                case '-':
                    //運算子
                    //直接判斷給予ICP值
                    icp=geticp(infix[j]);
                    if (top == -1) { //堆疊為空時直接把運算子放進去
                        top++;
                        stack_t[top] = infix[j];
                    } else {    //否則取得堆疊TOP的ISP
                        isp=getisp(stack_t[top]);
                        //比較ICP與ISP
                        if (icp > isp) {//如果ICP比較大，則直接加入堆疊
                            top++;
                            stack_t[top] = infix[j];
                        } else {//如果比較小，輸出堆疊直到ICP>ISP，再把該運算子加入
                            while(icp<=getisp(stack_t[top])){
                                System.out.print(stack_t[top--]);
                            }
                            top++;
                            stack_t[top]=infix[j];
                        }
                    }
                    break;
                default:
                    System.out.print(infix[j]);//若為運算元則直接輸出
            }
        }
    }

}
