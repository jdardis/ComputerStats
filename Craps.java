/**
 * Created by jackdardis on 2/21/16
 *
 */
public class Craps {
        public static void main (String[] args)
        {
            MultiDie d1 = new MultiDie(6);
            MultiDie d2 = new MultiDie(6);

            int end = 10000000, faceValue, point;
            double losses = 0, wins = 0, money = 0;
            boolean diff;  // diff will be used for
                           // non-natural or craps rolls
            for(int i = 0; i < end; i++)
            {
                int a = d1.roll(), b = d2.roll();
                faceValue = a+b;

                switch(faceValue)
                {
                    case 1: break;
                    case 2:case 3 :case 12:
                        money -= 10;
                        losses++;
                        break;
                    case 7:case 11:
                        money += 20;
                        wins++;
                        break;
                    case 4:case 5:case 6:case 8:case 9:case 10:
                        diff = true;
                        point = faceValue;
                        while(diff)
                        {
                            faceValue = d1.roll()+d2.roll();
                            if(faceValue == 7) {
                                money -= 10;
                                losses++;
                                diff = false;
                            }
                            else if(faceValue == point) {
                                money += 10;
                                wins++;
                                diff = false;
                            }
                        }
                        break;
                }
            }
            double avg = wins/losses;
            System.out.println("Average wins/losses: "+ avg);
            double percent = wins/end;
            System.out.println("percent: "+percent*100);
            money = money/end;
            System.out.println("Money per turn: "+money);
        }
}