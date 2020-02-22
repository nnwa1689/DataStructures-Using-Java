package Heap;

import java.util.Scanner;

class heapA {

    final int max = 50;
    int[] heapt = new int[max];
    int last = 0;
    Scanner input = new Scanner(System.in);

    public void insert() {

        if (last >= max - 1) {
            System.out.println("Heap array is full!");
        } else {
            System.out.println("input data:");
            heapt[++last] = input.nextInt();
            adsjustup(heapt, last);
        }
    }

    //如果父節點(上)比較大，則由上往下調整
    //若比較小則由下往上調整
    public void adsjustup(int ads[], int index) {

        while (index > 1) {

            if (ads[index] <= ads[index / 2])//當父節點已經大於子結點就不再調整
            {
                break;
            } else {//否則交換

                exchange(ads, index);
                index /= 2;

            }

        }

    }
    
    public void del(){
        
        if(last<=0)
            System.out.println("Heap is null!");
        else{
            
            System.out.println("Input del data ：");
            int deldata=input.nextInt();
            int delindex=search(deldata);
            if(delindex==0)
                System.out.println("Data not Find!");
            else{
            
                heapt[delindex]=heapt[last];
                heapt[last]=0;
                last--;
                adsjustdown(heapt, 1);
                //adsjustup(heapt, delindex);
                
            }
        }
    
    }
    
    public void adsjustdown(int arr[],int index){
        
        int data=arr[index];//儲存該點資料
        int index_temp=index*2;//取得下一個階層
        while(index_temp<=last){
            
            if((index_temp<last)&&arr[index_temp]<arr[index_temp+1])    //取得該階層最大的點
                index_temp++;
            if(arr[index_temp]<=arr[index_temp/2])//如果取得的最大值比上階層小，則略過不交換
                break;
            else{
                arr[index_temp/2]=arr[index_temp];
                index_temp*=2;//繼續比較下面的子結點
            }
            
        }
        arr[index_temp/2]=data;
        
    }
    
    public int search(int data){
        
        int delindex =1 ;
        for(delindex=1;delindex<=last;delindex++){
            
            if(heapt[delindex]==data)
                return delindex;
        }
        return 0;
        
    }

    public void exchange(int temp[], int index) {

        int extemp = temp[index];
        temp[index] = temp[index / 2];
        temp[index / 2] = extemp;
        System.out.printf("L:%d,EX:%d", last, index);

    }
    
    public void show(){
        
        for (int c_index =1;c_index<=last;c_index++)
            System.out.printf(" %d",heapt[c_index]);
    
    }

}

public class heapArray {

    public static void main(String[] args) {
        heapA obj = new heapA();
        Scanner input = new Scanner(System.in);
        System.out.println("1");
        while (true) {
            
            int doing = input.nextInt();
            switch (doing) {

                case 1:
                    obj.insert();
                    break;
                case 2:
                    obj.show();
                    break;
                    
                case 3:
                    obj.del();
                    break;

            }
        }
    }

}
