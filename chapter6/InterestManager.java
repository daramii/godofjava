public class InterestManager {
  
  public static void main(String args[]) {
    
    InterestManager interest = new InterestManager();
    
    /*
    for(int day=1;day<=365;day++) {
			double amount=interest.calculateAmount(day, 1000000);
			System.out.print(day+":"+amount+" ");
			if(day%20==0) System.out.println();
		}
		*/
		
		for(int day=10;day<=370;day+=10) {
			double amount=interest.calculateAmount(day, 1000000);
			System.out.println(day+":"+amount+" ");
		}
    
  }
  
  
  public double getInterestRate(int day) {
     
     double interestPercent = 0.0;
     
    if(day >= 1 && day <= 90) {
       interestPercent = 0.5;
    }else if (day >91 && day <=180) {
      interestPercent = 1.0;
    }else if (day >= 181 && day <= 364) {
      interestPercent = 2.0;
    }else {
      interestPercent = 5.6;
    }
    
    return interestPercent;
  }
  
  public double calculateAmount(int day, long amount) {
    double totalAmount;
		double interest = getInterestRate(day);
		double interestAmount= amount * interest / 100.0;
		totalAmount = amount + interestAmount;
		return totalAmount;
  }
  
  
  
}