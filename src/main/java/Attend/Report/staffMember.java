package Attend.Report;

public class staffMember {
	
		private String AID;
	    private String ID;
	    private String date;
	    private String clockin;
	    private String clockout;
	    private String thour;
	    
	    
		public staffMember(String AID,String ID, String date, String clockin, String clockout, String Thour) {
			this.AID = AID;
			this.ID = ID;
			this.date = date;
			this.clockin = clockin;
			this.clockout = clockout;
			this.thour = Thour;
		}
		public String getAID() {
			return AID;
		}
		public String getID() {
			return ID;
		}
		public String getDate() {
			return date;
		}
		public String getClockin() {
			return clockin;
		}
		public String getClockout() {
			return clockout;
		}
		public String getThour() {
			return thour;
		}
		
	

	   
}