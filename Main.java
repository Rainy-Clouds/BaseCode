import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        long base1 = askForBase("Enter the base of the number you're trying to convert (2-10): ", scan);
        long base2 = askForBase("Enter the base you're trying to convert to (2-10): ", scan);
        long num = askForNum("Enter the number to convert: ", scan);

        System.out.println(convertToBase(convertToDecimal(num, base1, 0, 0), base2, 0, 0));
    }

    public static long convertToDecimal(long num, long base, long exp, long sum)
    {
        if(num / 10 == 0)
        {
            return (num * (long)Math.pow(base, exp));
        }
        else
        {
            return (num % 10 * (long)Math.pow(base, exp)) + convertToDecimal(num / 10, base, exp + 1, sum);
        }
    }

    public static long convertToBase(long num, long base, long exp, long sum){
        if (num / base == 0){
            return ((num % base) * (long)Math.pow(10, exp));
        }
        else{
            
            return ((num % base) * (long)Math.pow(10, exp)) + convertToBase(num/base, base, exp+1, sum);
        }
    }

    public static long askForBase(String message, Scanner scan)
    {
        System.out.print(message);
        try
        {
            long num = scan.nextLong();
            
            if(num < 2 || num > 10)
            {
                System.out.println("Invalid input!");
                return askForBase(message, scan);
            }
            else
            {
                return num;
            }
        }
        catch(Exception e)
        {
            scan.next();
            System.out.println("Invalid input!");
            return askForBase(message, scan);
        }
    }

    public static long askForNum(String message, Scanner scan)
    {
        System.out.print(message);
        try
        {
            long num = scan.nextLong();
                
            return num;
        }
        catch(Exception e)
        {
            scan.next();
            System.out.println("Invalid input!");
            return askForBase(message, scan);
        }
    }
}