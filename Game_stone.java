import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

class Helper extends TimerTask
{
    public static int i=0;
    public void run()
    {
        System.out.println(" "+ ++i);
        if(i==3)
        {
            synchronized(Game_stone.obj)
            {
                Game_stone.obj.notify();
            }
        }
    }
}
public class Game_stone
{
    protected static Game_stone obj;
    public static void main(String args[])throws InterruptedException
    {
        char c;
        String ye;
        int j=0;
        int z;
        int count=0;
        int count1=0;
        obj = new Game_stone();
        Random random = new Random();
        Timer timer =new Timer();
        TimerTask task=new Helper();
        Date date =new Date();
        int x = random.nextInt(1,4);
       
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nAre you guise Ready for Playing \"Stone\" ,\"Paper\" ,\"Scissor\"  Then press \"yes\" ");
        String  y = sc.next();
    
        if(y.equalsIgnoreCase("yes"))
        {
           System.out.println("Rules for Game ");
           System.out.println("Rule 1 : For \"Stone\" Press \"1\" ");
           System.out.println("Rule 2 : For \"Paper\" Press \"2\" ");
           System.out.printf("Rule 3 : For \"Scissor\" Press \"3\" ");


           String a =  sc.nextLine();
           String name1 = sc.nextLine();

          
          // System.out.println(x);
          timer.schedule(task,date,2003);
          System.out.println("Timer Running");
          synchronized(obj)
          {
            obj.wait();
            timer.cancel();
          }

           System.out.println("\n\n-------Game Strat-------");
        
        do
        {
         while(j<3)
         { //Stone 1 ,paper 2 ,scissor 3
           System.out.println("\nChoose the element");
           z=sc.nextInt();
           //System.out.println(x);

           if(x==z)
           {
              System.out.println("\nThis match is draw");
           }
           else if(((x==1)&&(z==2))||((x==3)&&(z==1))||((x==3)&&(z==1)))
           {
             System.out.println("\nComputer gains zero point");
             System.out.println("You gain one point");
             count1++;
           }
           else if(((x==2)&&(z==1))||((x==3)&&(z==2))||((x==1)&&(z==3)))
           {
             System.out.println("\nComputer gains one point");
             System.out.println("You gain zero point");
             count++;
           }
           else
           {          
               System.out.println("\nComputer gains zero point");
               System.out.println("You gain one point");
               count1++;

           }
           j++;
         }
         j=0;

         System.out.printf("\n\nScore is :- \n Computer :-%d \n You:- %d\n", count,count1);

         if(count==count1)
         {
           System.out.println("\n\nThe Match is draw\n ");
         }
         else if(count>count1)
         {
             System.out.printf("Computer Win the Game with %d", (count-count1));
         }

          else if(count1>count)
         {
            System.out.printf("Computer Win the Game with %d", (count1-count));
         }
         System.out.println("\n\n-----Game End------\n");
         System.out.println("Do you want to play Again");
         ye =sc.next();
       
        }while(ye.equalsIgnoreCase("yes"));

        }

        
    }
}