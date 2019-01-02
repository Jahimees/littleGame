package Items;
		

public class BodyPart {
		private boolean head = false;
		private boolean legs = false;
		private boolean breast = false;
		private boolean foots = false;	
		
		public String getBodyPart() {
			String ret = null;
			if (head==true) {ret = "head";}
			if (legs==true) {ret = "legs";}				
			if (breast==true) {ret = "breast";}
			if (foots==true) {ret = "foots";}
			
			
			return ret;
		}
		
		public BodyPart(String type){
			switch (type) {
			case "head":{ head = true; break;}
			case "legs": { legs = true; break;}
			case "breast": { breast = true; break;}
			case "foots": { foots = true; break;}
			}				
		}		
}