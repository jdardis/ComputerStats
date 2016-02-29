import java.text.DecimalFormat;

public class Coin {
   public static void main (String[] args)
   {
      MultiDie test = new MultiDie(2);
      DecimalFormat df = new DecimalFormat("#.#####");
      final int START = 1;
      final int END = 10000000;
            
      for(int current = START; current <= END; current *= 10)
      {
    	  double avg = 0.00000;
    	  int head = 0;
    	  
    	  for(int i=0; i<current; i++)
    	  {
	    	  int face = 0;
	    	  
	    	  test.roll();
	    	  face = test.getFaceValue();
	    	  
	    	  if(face == 1)
	    	  { head++;
	    	  }
    	  }
    	  avg = (double)head/current;
    	  System.out.println("Heads up ratio for "+current+ " flips: "+df.format(avg));
      }
}
}
