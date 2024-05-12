import java.util.*;
public class StackIntMethods
{
    public static Scanner reader = new Scanner(System.in);
    
    public static int maxStack(Stack<Integer> s) 
    {
        int maxNum = 0, value;
        while(!s.isEmpty()) 
        {
            value = s.pop();
            if(value > maxNum)
                maxNum = value;
        }
        return maxNum;
    }
    
    public static int minStack(Stack<Integer> s) 
    {
        if(s.isEmpty())
        {
            System.out.println("empty");
        }
        int minNum = s.pop() , value;
        Stack<Integer> tempStack = new Stack<Integer>();

        // חסר האיבר הראשון
        //tempStack.push(minNum);
        while(!s.isEmpty()) 
        {
            value = s.pop();
            tempStack.push(value);
            if(value < minNum)
                minNum = value;
        }
        while(!tempStack.isEmpty())
        {
            value = tempStack.pop();
            s.push(value);
        }
        return minNum;
    }
    
    public static Stack<Integer> buildStack() 
    {
        int value;
        Stack<Integer> tempStack = new Stack<Integer>();
        
        System.out.println("enter num");
        value=reader.nextInt();
        
        while(value!=-999) 
        {
            tempStack.push(value);
            
            System.out.println("enter num");
            value=reader.nextInt();
        }
        return tempStack;
    }
    
    public void plusMinus(Stack<Integer> s) 
    {
        if(s.isEmpty())
        {
            System.out.println("equal");
        }
        int sumMin = 0, sumMax = 0 , value;
        while(!s.isEmpty()) 
        {
            value = s.pop();
            
            if(value < 0)
                sumMin++;
            if(value > 0)
                sumMax++;
        }
        if(sumMin>sumMax)
        {
            System.out.println("Minus");
        }
        if(sumMin<sumMax)
        {
            System.out.println("Plus");
        }
        if(sumMin==sumMax)
        {
            System.out.println("equal");
        }
    }
    
    public static boolean isSorted(Stack<Integer> s) 
    {
        if(s.isEmpty())
        {
            return true;
        }
        int minNum = s.pop() , value;
        while(!s.isEmpty()) 
        {
            value = s.pop();
            if(value>minNum)
            {
                return false;
            }
            else
            {
                minNum=value;
            }
        }
        return true;
    }
    
    public static void main(String [] args) 
    {
        /*
        Stack<Integer> s = new Stack<Integer>();
        s.push(5);
        s.push(7);
        s.push(3);
        System.out.println(maxStack(s));
        
        s.push(5);
        s.push(1);
        s.push(3);
        System.out.println(s);
        System.out.println(minStack(s));
        System.out.println(s);

         */

        Stack<Integer> s = buildStack();
        System.out.println(s);
        System.out.println(isSorted(s));

    }
}
