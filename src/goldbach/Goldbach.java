package goldbach;
/* @author sumeyral

 */
class Goldbach {
    public static void main(String [] args)
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.println("Çift sayı giriniz:");
        int val = Integer.parseInt(kb.nextLine());

        NumberUtil.displayGoldbach(val);

    }
}

class NumberUtil {
    public static void displayGoldbach (int val)
    {
        if(val<=1 || val %2 !=0)
            System.out.println("Hatalı giriş!");
        else if(val == 4)
            System.out.println("2 2");
        else {
            int count = 0;

            for (int i = 3; i < val; i = i + 2)
                if (isPrime(i))
                    count = i;

            for(;;)
                if(!(isPrime(count) && isPrime(val-count)))
                    count-=2;
                else
                    break;

            System.out.printf("%d %d", count, val - count);
        }

    }

    public static boolean isPrime(int val)
    {
        if (val <= 1)
            return false;

        if (val % 2 == 0)
            return val == 2;

        if (val % 3 == 0)
            return val == 3;

        if (val % 5 == 0)
            return val == 5;

        if (val % 7 == 0)
            return val == 7;

        if (val % 11 == 0)
            return val == 11;

        for (int i = 13; i * i <= val; i += 2)
            if (val % i == 0)
                return false;

        return true;
    }
}