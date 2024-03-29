import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
 {
	public static void main(String[] args)
	 {
	 	Constants cons = new Constants();
		if(args.length == 0 || args.length > 1)
		{
			System.out.println("Program terminated.\nPlease Enter a valid argument");
			return;
		}
		else if(args[0].equals(cons.showAll))
		
		 {
			System.out.println(cons.dLoading);				
			try
			{
			String reader = loadData("students.txt");
			String words[] = reader.split(",");			
			for(String word : words) 
			{
			 System.out.println(word);
			}
			}
			catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");
		 }
		else if(args[0].equals("r")) 
		 {
			System.out.println("Loading data ...");			
			try
			{
			String reader = loadData("students.txt");
			//System.out.println(r);
			String words[] = reader.split(",");	
			Random random = new Random();
			int randomindex = random.nextInt(words.length);
			System.out.println(words[randomindex]);
			} catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");			
		 }
		else if(args[0].contains("+"))
		 {
			System.out.println("Loading data ...");			
			try
			{
			BufferedWriter filestream = new BufferedWriter(
			new FileWriter("students.txt", true));
			String argvalue = args[0].substring(1);
	        Date date = new Date();
	        String dateformat = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(dateformat);
	        String finaldate= dateFormat.format(date);
			filestream.write(", "+argvalue+"\nList last updated on "+finaldate);
			filestream.close();
			} 
			catch (Exception e)
			{

			}
							
			System.out.println("Data Loaded.");	
		 }
		else if(args[0].contains("?")) 
		 {
			System.out.println("Loading data ...");			
			try 
			{
			String reader = loadData("students.txt");
			String words[] = reader.split(",");	
			boolean done = false;
			String argvalue = args[0].substring(1);
			for(int idx = 0; idx<words.length && !done; idx++)
			 {
				if(words[idx].equals(argvalue))
				 {
					System.out.println("We found it!");
						done=true;
				}
			 }


			 
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		 }
		else if(args[0].contains("c")) 
		 {
			System.out.println("Loading data ...");			
			try 
			{
			String fileContents = loadData("students.txt");
			char ara[] = fileContents.toCharArray();			
			boolean in_word = false;
			int count=0;
			for(char cha:ara)
			 {
				if(cha ==' ') 
				 {
					if (!in_word)

					 {	  
					 	count++; in_word =true;

				     }
					else
					 { 
					 	in_word=false;
					 }			
				 }
			}
			System.out.println(count +" word(s) found ");
			} 
			catch (Exception e){} 
			System.out.println("Data Loaded.");				
		 }
	
	 }

	public static String loadData(String filename)
	{
		String line;
		try
		{
			BufferedReader fileStream = new BufferedReader(
			new InputStreamReader(
			new FileInputStream(filename))); 

			line = fileStream.readLine();
			return line;

		}
		catch(Exception e)
		{

		}
		return "";
	}
}

