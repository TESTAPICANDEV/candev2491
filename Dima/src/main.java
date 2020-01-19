import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	public static void main(String[] args) throws IOException {

		/**System.out.println("beginning");
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
		}**/

		BufferedReader csvReader = new BufferedReader(new FileReader("C:/Users/1/Desktop/CAN/candev2491/plant_output_aggregator/cip_standards3.csv"));

		String row;
		FileWriter csvWriter = new FileWriter("C:/Users/1/Desktop/CAN/candev2491/plant_output_aggregator/cip_standardsOut.csv");

		try {
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				System.out.println(data[4]);

				csvWriter.append(data[0]);
				csvWriter.append(",");
				csvWriter.append(data[1]);
				csvWriter.append(",");
				csvWriter.append(data[2]);
				csvWriter.append(",");
				csvWriter.append(data[3]);
				csvWriter.append(",");

				String d=data[4];
				try {

					int first = d.indexOf("/");
					int second = d.indexOf("/", first + 1)+1;

					int i=second;
					if (first ==-1) {
						//i = d.indexOf("-", d.indexOf("-") + 1)+1;
						first = d.indexOf("-");
						second = d.indexOf("-", first + 1)+1;
					}
					d.substring(i, i+4);
					//System.out.println (d.substring(i, i+4));
					csvWriter.append( d.substring(i, i+4));


				}catch (Exception e) {
					//do nothing
				}		    


				csvWriter.append(",");
				//csvWriter.append(data[5]);
				d=data[5];
				try {

					int first = d.indexOf("/");
					int second = d.indexOf("/", first + 1)+1;

					int i=second;
					if (first ==-1) {
						//i = d.indexOf("-", d.indexOf("-") + 1)+1;
						first = d.indexOf("-");
						second = d.indexOf("-", first + 1)+1;
					}
					d.substring(i, i+4);
					System.out.println (first);

					//System.out.println (d.substring(i, i+4));
					csvWriter.append( d.substring(i, i+4));


				}catch (Exception e) {
					//do nothing
				}		    
				
				
				csvWriter.append(",");
				csvWriter.append("\n");
			}
		}



		catch(Exception e) {

			csvReader.close();

			csvWriter.flush();
			csvWriter.close();		    
		}
		csvReader.close();

		csvWriter.flush();
		csvWriter.close();


	}
}