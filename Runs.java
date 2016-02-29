/* Runs.java		Author: Dardis/Jack
 * 
 */
public class Runs
{
   public static void main (String[] args)
   {
      MultiDie test = new MultiDie(2);
      final int START = 1;
      final int END = 10000000;
            
      for(int current = START; current <= END; current *= 10)
      {
         int count=0;
         int max=0;
         int firstFaceValue=0;
         
         for(int i = 1; i <= current; i++)
         {
            test.roll();
            if (i == 1)
            {
               firstFaceValue = test.getFaceValue();
            }
            if(firstFaceValue == test.getFaceValue())
            {
               count++;
            }
            else
            {            
               count=1;
            }
            
            firstFaceValue = test.getFaceValue();
            
            if(count > max)
            {
               max = count;
            }
         }
         System.out.println("Runs for " + current + " flips: " + max);
      }
   }
}