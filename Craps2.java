public class Craps2
{
    public static void main (String[] args)
    {
        int END = 1000000;
        int totalFaceValue = 0;
        int newFaceValue = 0;
        int totalWinnings = 0;
        int totalLosses = 0;
        int point = 0;
        boolean win = false;
        double average = 0.0;

        MultiDie first = new MultiDie(6);
        MultiDie second = new MultiDie(6);

        for(int i = 0; i < END; i++)
        {
            boolean pt = false;
            first.roll();
            second.roll();
            totalFaceValue = first.getFaceValue() + second.getFaceValue();

            if (totalFaceValue == 2 || totalFaceValue == 3 || totalFaceValue == 12)
            {
                win = false;
            }
            else if (totalFaceValue == 7 || totalFaceValue == 11)
            {
                win = true;
            }
            else
            {
                while(!pt)
                {
                    point = totalFaceValue;
                    first.roll();
                    second.roll();
                    newFaceValue = first.getFaceValue() + second.getFaceValue();

                    if(newFaceValue == 7)
                    {
                        win = false;
                        pt = true;
                    }
                    else if (newFaceValue == point)
                    {
                        win = true;
                        pt = true;
                    }
                }
            }
            if(win)
            {
                totalWinnings++;
            }
            else
                totalLosses++;
        }
        System.out.println("Total Wins: " + totalWinnings);
        System.out.println("Total Losses : " + totalLosses);
        average = (double)totalWinnings/(double)END;
        System.out.println("Winning Percentage: " + average);
    }
}