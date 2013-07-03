	/** 
    * Creates a Runner and logs race times. 
	 *
	 * @author Seth Denney
	 * @version 10-16-2011
    */
   public class RunnerTimes {
      private String name;
      private double[] raceA, raceB,  raceC;
   
   	/**
   	* Constructor for RunnerTimes object.
   	*
   	* @param nameIn runner name
   	* @param raceAIn times for raceA
   	* @param raceBIn times for raceB
   	* @param raceCIn times for raceC
   	*/
      public RunnerTimes(String nameIn, double[] raceAIn, 
      double[] raceBIn, double[] raceCIn) {
         name = nameIn;
      
         raceA = new double[raceAIn.length];
         raceA = raceAIn;
      
         raceB = new double[raceBIn.length];
         raceB = raceBIn;
      
         raceC = new double[raceCIn.length];
         raceC = raceCIn;
      } 
   	
   	/**
   	* Sets times for specified race.
   	*
   	* @param raceID race identification character
   	* @param raceIn times for specified race
   	*
   	* @return boolean for successful set
   	*/
      public boolean setTimes(char raceID, double[] raceIn) {
         double[] temp;
         int i = 0;
      	
         if (raceIn.length > 0) {
            switch (raceID) {
               case 'A':
                  temp = new double[raceIn.length];
                  for (i = 0; i < raceIn.length; i++) {
                     temp[i] = raceIn[i];
                  }
                  raceA = new double[temp.length];
                  raceA = temp;
                  return true;
               case 'a':
                  temp = new double[raceIn.length];
                  for (i = 0; i < raceIn.length; i++) {
                     temp[i] = raceIn[i];
                  }
                  raceA = new double[temp.length];
                  raceA = temp;
                  return true;
               case 'B':
                  temp = new double[raceIn.length];
                  for (i = 0; i < raceIn.length; i++) {
                     temp[i] = raceIn[i];
                  }
                  raceB = new double[temp.length];
                  raceB = temp;
                  return true;
               case 'b':
                  temp = new double[raceIn.length];
                  for (i = 0; i < raceIn.length; i++) {
                     temp[i] = raceIn[i];
                  }
                  raceB = new double[temp.length];
                  raceB = temp;
                  return true;
               case 'C':
                  temp = new double[raceIn.length];
                  for (i = 0; i < raceIn.length; i++) {
                     temp[i] = raceIn[i];
                  }
                  raceC = new double[temp.length];
                  raceC = temp;
                  return true;
               case 'c':
                  temp = new double[raceIn.length];
                  for (i = 0; i < raceIn.length; i++) {
                     temp[i] = raceIn[i];
                  }
                  raceC = new double[temp.length];
                  raceC = temp;
                  return true;
               default:
                  return false;
            }
         }
         else {
            return false;
         }
      }
      
   	/**
   	* Gets times for specified race.
   	*
   	* @param raceID race identification character
   	*
   	* @return times for specified race
   	*/
      public double[] getTimes(char raceID) {
         double[] dummy = new double[0];
         String output;
         switch (raceID) {
            case 'A':
               return raceA;
            case 'a':
               return raceA;
            case 'B':
               return raceB;
            case 'b':
               return raceB;
            case 'C':
               return raceC;
            case 'c':
               return raceC;
            default:
               return dummy;
         }
      }
   	
   	/**
   	* Averages times for specified races.
   	*
   	* @param raceID race identification character
   	*
   	* @return average time for specified race
   	*/
      public double averageTimes(char raceID) {
         double average = 0;
         int i = 0;
      	
         switch (raceID) {
            case 'A':
               if (raceA.length == 0) {
                  return 0;
               }
               for (i = 0; i < raceA.length; i++) {
                  average += raceA[i];
               }
               average /= raceA.length;
               break;
            case 'a':
               if (raceA.length == 0) {
                  return 0;
               }
               for (i = 0; i < raceA.length; i++) {
                  average += raceA[i];
               }
               average /= raceA.length;
               break;
            case 'B':
               if (raceB.length == 0) {
                  return 0;
               }
               for (i = 0; i < raceB.length; i++) {
                  average += raceB[i];
               }
               average /= raceB.length;
               break;
            case 'b':
               if (raceB.length == 0) {
                  return 0;
               }
               for (i = 0; i < raceB.length; i++) {
                  average += raceB[i];
               }
               average /= raceB.length;
               break;
            case 'C':
               if (raceC.length == 0) {
                  return 0;
               }
               for (i = 0; i < raceC.length; i++) {
                  average += raceC[i];
               }
               average /= raceC.length;
               break;
            case 'c':
               if (raceC.length == 0) {
                  return 0;
               }
               for (i = 0; i < raceC.length; i++) {
                  average += raceC[i];
               }
               average /= raceC.length;
               break;
            case '0':
               if (raceA.length == 0 && raceB.length == 0
               && raceC.length == 0) {
                  return 0;
               }
               for (i = 0; i < raceA.length; i++) {
                  average += raceA[i];
               }
               for (i = 0; i < raceB.length; i++) {
                  average += raceB[i];
               }
               for (i = 0; i < raceC.length; i++) {
                  average += raceC[i];
               }
               average /= (raceA.length + raceB.length 
                  + raceC.length);
               break;
            default:
               return -1;
         }
         return average;
      }
      
   	/**
   	* Calculates total time for specified races.
   	*
   	* @param raceID race identification character
   	*
   	* @return total time for specified race
   	*/
      public double totalRaceTimes(char raceID) {
         double total = 0;
         int i = 0;
      	
         switch (raceID) {
            case 'A':
               for (i = 0; i < raceA.length; i++) {
                  total += raceA[i];
               }
               break;
            case 'a':
               for (i = 0; i < raceA.length; i++) {
                  total += raceA[i];
               }
               break;
            case 'B':
               for (i = 0; i < raceB.length; i++) {
                  total += raceB[i];
               }
               break;
            case 'b':
               for (i = 0; i < raceB.length; i++) {
                  total += raceB[i];
               }
               break;
            case 'C':
               for (i = 0; i < raceC.length; i++) {
                  total += raceC[i];
               }
               break;
            case 'c':
               for (i = 0; i < raceC.length; i++) {
                  total += raceC[i];
               }
               break;
            default:
               total = -1;
               break;
         }
         
         return total;
      }
      
   	/**
   	* Adds times to a specified races.
   	*
   	* @param raceID race identification character
   	* @param times double array of times to add
   	*
   	*/
      public void addTimes(char raceID, double ... times) {
         double[] temp;
         int i = 0;
      	
         switch (raceID) {
            case 'A':
               temp = new double[raceA.length + times.length];
               for (i = 0; i < raceA.length; i++) {
                  temp[i] = raceA[i];
               }
               for (i = raceA.length; i < temp.length; i++) {
                  temp[i] = times[i - raceA.length];
               }
               raceA = new double[temp.length];
               raceA = temp;
               break;
            case 'a':
               temp = new double[raceA.length + times.length];
               for (i = 0; i < raceA.length; i++) {
                  temp[i] = raceA[i];
               }
               for (i = raceA.length; i < temp.length; i++) {
                  temp[i] = times[i - raceA.length];
               }
               raceA = new double[temp.length];
               raceA = temp;
               break;
            case 'B':
               temp = new double[raceB.length + times.length];
               for (i = 0; i < raceB.length; i++) {
                  temp[i] = raceB[i];
               }
               for (i = raceB.length; i < temp.length; i++) {
                  temp[i] = times[i - raceB.length];
               }
               raceB = new double[temp.length];
               raceB = temp;
               break;
            case 'b':
               temp = new double[raceB.length + times.length];
               for (i = 0; i < raceB.length; i++) {
                  temp[i] = raceB[i];
               }
               for (i = raceB.length; i < temp.length; i++) {
                  temp[i] = times[i - raceB.length];
               }
               raceB = new double[temp.length];
               raceB = temp;
               break;
            case 'C':
               temp = new double[raceC.length + times.length];
               for (i = 0; i < raceC.length; i++) {
                  temp[i] = raceC[i];
               }
               for (i = raceC.length; i < temp.length; i++) {
                  temp[i] = times[i - raceC.length];
               }
               raceC = new double[temp.length];
               raceC = temp;
               break;
            case 'c':
               temp = new double[raceC.length + times.length];
               for (i = 0; i < raceC.length; i++) {
                  temp[i] = raceC[i];
               }
               for (i = raceC.length; i < temp.length; i++) {
                  temp[i] = times[i - raceC.length];
               }
               raceC = new double[temp.length];
               raceC = temp;
               break;
            default:
         	  	
         }
      }
      
   	/**
   	* Returns the race which has the lowest calculated
   	* average time.
   	*
   	* @return best race identification character
   	*/
      public char bestRace() {
         char raceID;
         double averageA, averageB, averageC;
      
         averageA = averageTimes('A');
         averageB = averageTimes('B');
         averageC = averageTimes('C');
      
         if (averageA < averageB && averageA < averageC) {
            return 'A';
         }
         else if (averageB < averageA && averageB < averageC) {
            return 'B';
         }
         else if (averageC < averageA && averageC < averageA) {
            return 'C';
         }
         else if (averageA == averageB || averageA == averageC) {
            return 'A';
         }
         else {
            return 'B';
         }
      }
      
   	/**
   	* Returns the race which has the highest calculated
   	* average time.
   	*
   	* @return worst race identification character
   	*/
      public char worstRace() {
         char raceID;
         double averageA, averageB, averageC;
      
         averageA = averageTimes('A');
         averageB = averageTimes('B');
         averageC = averageTimes('C');
      
         if (averageA > averageB && averageA > averageC) {
            return 'A';
         }
         else if (averageB > averageA && averageB > averageC) {
            return 'B';
         }
         else if (averageC > averageA && averageC > averageA) {
            return 'C';
         }
         else if (averageA == averageB || averageA == averageC) {
            return 'A';
         }
         else {
            return 'B';
         }
      }
      
   	/**
   	* Compares the total times for two RunnerTimes objects.
   	*
   	* @param runner RunnerTimes object to compare to self
   	*
   	* @return int representing whichever runner has a 
   	* lower total time
   	*/
      public int compareRunners(RunnerTimes runner) {
         double selfTotal, opponentTotal;
      	
         selfTotal = totalRaceTimes('A') + totalRaceTimes('B') 
            + totalRaceTimes('C');
      	
         opponentTotal = runner.totalRaceTimes('A') 
            + runner.totalRaceTimes('B') 
            + runner.totalRaceTimes('C');
      	
         if (selfTotal < opponentTotal) {
            return -1;
         }
         else if (selfTotal > opponentTotal) {
            return 1;
         }
         else {
            return 0;
         }
      }
      
   	/**
   	* toString method.
   	*
   	* @return List of race times in String format
   	*/
      public String toString() {
         String output = "";
         int i = 0;
      	
         output += "Runner Name: " + name;
         output += "\nRace A times:\n";
      	
         for (i = 0; i < raceA.length; i++) {
            output += "\t" + raceA[i];
         }
      	
         output += "\nRace B times:\n";
      	
         for (i = 0; i < raceB.length; i++) {
            output += "\t" + raceB[i];
         }
      	
         output += "\nRace C times:\n";
      	
         for (i = 0; i < raceC.length; i++) {
            output += "\t" + raceC[i];
         }
         return output;
      }
   	
   }