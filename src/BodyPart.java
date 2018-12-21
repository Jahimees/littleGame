		

public class BodyPart {
		private boolean head;
		private boolean legs;
		private boolean breast;
		private boolean foots;	
		
		public String getBodyPart() {
			String ret;
			if (head) {ret = "head";}
			if (legs) {ret = "legs";}
			if (breast) {ret = "breast";}
			else ret = "foots";
			return ret;
		}
		
		public BodyPart(String type){
			switch (type) {
			case "head":{head = true;}
			case "legs": {legs = true;}
			case "breast": { breast = true;}
			case "foots": { foots = true;}
			}				
		}		
}