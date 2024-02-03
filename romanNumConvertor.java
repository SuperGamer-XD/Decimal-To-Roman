/**
 * RomanNumConvertor
 * This convertor work for number in this range: [0,3999]
 * Date: 11/1/2024
 * @author: osher ovadia
 */
public class romanNumConvertor {
    
    public static void main(String[] args)
    {
        
            convert(1957);
    }
    public static void convert(int num)
    {        
        final char[] arr = new char[]{'|','V','X','L','C','D','M'};
        int length = 1;
        int tempNum = num;
        String s = ""; // contains roman letters

        while(tempNum%10!=tempNum) //get the num length
        {
            length+=1;
            tempNum/=10;
        }
        int[] arr1 = new int[length];//get the num in array
        String[] arrS = new String[length];
        int num1 = num; //another temp num
        for(int k=arrS.length-1;k>=0;k--)
            arrS[k]="";
        int length1 = length; // temp int
        while(length1>0) //insert the digits to arr1 in the right order
        {
            arr1[length-length1] = num1%10;
            num1/=10;  
            length1-=1;
        }
        for(int i=0; i<length; i++)//main loop
        {
         
            char letter1 = helpF(arr1[i]*Math.pow(10,i));
            int p=0;
            /*System.out.println(arr1[i]);//SELF CHECK
            System.out.println(arr1[i]*Math.pow(10,i));
            System.out.println(letter1);*/
                while(arr[p]!=letter1 && letter1!=' ')
                {
                   // System.out.println(letter1 + " " + arr[p]);
                    p+=1;
                }
           switch (arr1[i]) {
            case 1:
                arrS[i]+=letter1;
                break;
            case 2:
                arrS[i]+=letter1+""+letter1;
                break;
            case 3:
                arrS[i]+=letter1+""+letter1+""+letter1;
                break;
            case 4:
                arrS[i]+=arr[p-1]+""+arr[p];
                break;
            case 5:
                arrS[i]+=letter1;
                break;
            case 6:
                arrS[i]+=arr[p]+""+arr[p-1];
                break;
            case 7:
                arrS[i]+=arr[p]+""+arr[p-1]+""+arr[p-1];
                break;
            case 8:
                arrS[i]+=arr[p]+""+arr[p-1]+""+arr[p-1]+""+arr[p-1];
                break;
            case 9:
                arrS[i]+=arr[p-2]+""+arr[p];
                break;
            default:
                arrS[i]+="";
                break;  
           }
        
        }
        for(int k=arrS.length-1;k>=0;k--)
            if(arrS[k]!=null || arrS[k]!="")
                s+=arrS[k];
        System.out.println(s + " " + num);

        
        
    }


    public static char helpF(double n)
        {
            
            if(n>0 && n<4)
                return '|';
            if(n>=4&&n<9)
                return 'V';
            if(n>=9&&n<40)
                return 'X';
            if(n>=40&&n<90)
                return 'L';
            if(n>=90&&n<400)
                return 'C';    
            if(n>=400&&n<900)
                    return 'D'; 
            if(n>=900&& n<=8999)
                return 'M';
            if(n<0)        
                return '%';
            return ' ';



        }

    public static int help(int n)
    {
        if(n==0|| n==5 || n==1) //5,1,0
            return 5;
        if(n<5)
            { 
                if (n<4 && n>1) //2,3
                    return 1;
                return 2; // n=4       
            }
        if(n>5)
        {  
            if(n<9) // n=6,7,8
                return 3;
            else
                return 4; //9
        }
        return 6;
    }
    
}
