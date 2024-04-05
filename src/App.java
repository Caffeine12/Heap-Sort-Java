import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static int[] arr = new int[8];
    public static int filled = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while(filled<=7)
        {
            int newVal=sc.nextInt();
            heapInsert(newVal);
            filled++;
        }
        System.out.println("Size is full");        
        System.out.print(Arrays.toString(arr));
        filled-=1;
        System.out.println("\n"+"Do you want to delete ? (1 or 0)");
        int ans = sc.nextInt();
        while(ans==1 && filled>=0)
        {
            heapDelete();
            
            System.out.println("\n"+"Do you want to delete again? (1 or 0)");
            ans = sc.nextInt();
            
             
        }
        System.out.println("\n"+"All elements are deleted and heap sorted array is: ");  
        System.out.println(Arrays.toString(arr));

    }

    public static void heapInsert(int newVal)
    {
        
        arr[filled]=newVal;        
        int i = filled+1;
        while(i!=1)
        {
            if(arr[(i/2)-1]<arr[i-1])
            {
                int swap=arr[(i/2)-1];
                arr[(i/2)-1]=arr[i-1];
                arr[i-1]=swap;
                i=i/2;
            }
            else
            break;
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void heapDelete()
    {
        int deleted = arr[0];
        arr[0]=arr[filled];
        arr[filled]=deleted;
        filled-=1;
        int swap =0;
        int i = 1;
        while((2*i)<=filled)
        {
            if(arr[(2*i)-1]>arr[(2*i+1)-1])
            {
                if(arr[(2*i)-1]>arr[i-1])
                {
                    swap=arr[i-1];
                    arr[i-1]=arr[(2*i)-1];
                    arr[(2*i)-1]=swap;
                    i=2*i;

                }
                else
                {
                    break;
                }

            }
            else
            {
                if(arr[(2*i+1)-1]>arr[i-1])
                {
                    swap=arr[i-1];
                    arr[i-1]=arr[(2*i+1)-1];
                    arr[(2*i+1)-1]=swap;
                    i=2*i+1;

                }
                else
                {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
