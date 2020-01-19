import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	public static void main(String[] args) {
		
		System.out.println("beginning");
		Boolean a = false;
		LinkedList l = new LinkedList();
		List<String> zips = new ArrayList<String>();
	       
		//Valid ZIP codes
		zips.add("K1A--0B1");  
		zips.add("B1Z 0B9");  
		 
		//Invalid ZIP codes
		zips.add("K1A 0D1");  
		zips.add("W1A 0B1");  
		zips.add("Z1A 0B1");
		 
		String regex = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z][ -]{0,1}[0-9][A-Z][0-9]$";
		 
		Pattern pattern = Pattern.compile(regex);
		 
		for (String zip : zips)
		{
		    Matcher matcher = pattern.matcher(zip);
		    a = matcher.matches();
		    if(a) {
		    	zip.replaceFirst(" ", "");
		    	zip.replaceFirst("-", "");

		    	l.add(zip);
		    	System.out.println(zip);
		    }
		}
	}
}
