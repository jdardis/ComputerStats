public class HTX
{
   public static void main (String[] args)
   {
      MultiDie test = new MultiDie(2);
      final int START = 1;
      final int END = 1000000;
      double total=0.0;
      int flips=0;
      int totalFlips=0;   
      for(int current = START; current <= END; current++)
      {
         flips =0;
         String sequence="";
         boolean found = false;
         while(!found)
         {
            test.roll();
            flips++;
            //System.out.print(test.getFaceValue());
            if(test.getFaceValue()==1)
            {
               sequence+="H";
            }
            else
               sequence+="T";
            if(sequence.contains("HTT"))
            {
               found=true;
            }
         }
         //System.out.print("  Flips: " + flips);
         totalFlips += flips;
      }
      total = (double)totalFlips/END;
      System.out.println("Average Number: " + total);  
   }
}