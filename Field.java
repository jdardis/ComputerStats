import java.text.DecimalFormat;
public class Field
{
   public static void main (String[] args)
   {
      int END = 10000000;
      int totalFaceValue = 0;
      int totalWinnings = 0;
      int totalLosses = 0;
      int earnings = 0;
      double average=0.0;
      
      MultiDie first = new MultiDie(6);
      MultiDie second = new MultiDie(6);
      
      for(int i = 0; i < END; i++)
      {
         first.roll();
         second.roll();
         totalFaceValue = first.getFaceValue() + second.getFaceValue();
         switch (totalFaceValue) {
            case 1:  break;
            case 2:  totalWinnings += 30;
                     break;
            case 3:  totalWinnings += 20;
                     break;
            case 4:  totalWinnings += 20;
                     break;
            case 5:  totalLosses += 10;
                     break;
            case 6:  totalLosses += 10;
                     break;
            case 7:  totalLosses += 10;
                     break;
            case 8:  totalLosses += 10;
                     break;
            case 9:  totalWinnings += 20;
                     break;
            case 10: totalWinnings += 20;
                     break;
            case 11: totalWinnings += 20;
                     break;
            case 12: totalWinnings += 30;
                     break;
            default: totalWinnings += 0;
                     totalLosses += 0;
                     break;
        }
      }
      System.out.println("Total Winnings: " + totalWinnings);
      System.out.println("Total Losses : " + totalLosses);
      earnings = totalWinnings - totalLosses;
      System.out.println("Earnings: " + earnings);
      DecimalFormat df = new DecimalFormat("#.00");
      average = (double)earnings/(double)END;
      System.out.println("Average Earnings: $" + df.format(average));
   }
}