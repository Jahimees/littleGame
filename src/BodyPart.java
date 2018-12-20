		

public class BodyPart {
		boolean head;
		boolean legs;
		boolean breast;
		boolean foots;
			
		BodyPart(String type){
			switch (type) {
			case "head":{head = true;}
			case "legs": {legs = true;}
			case "breast": { breast = true;}
			case "foots": { foots = true;}
			}
				
		}
}