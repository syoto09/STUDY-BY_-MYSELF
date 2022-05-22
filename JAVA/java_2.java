// This is harder than java_1

import java.io.*;
import java.util.regex.*;
/**
 * This class is used to represent reads a single command-line argument:
 * the name of a file to open and process.  To process this file, you will 
 * read it line-by-line and create a running Total of the double values contained in the file.
 * 
 *
 */
public class java_2 extends Object{

	/**
	 * This main output;
	 * 1) the number of Total line ---
	 * 2) the total of double --- 
	 * 3) the number of lines skipped ---
	 * 4) the minimum value read --- 
	 * 5) the largest value read ---
	 * @param args It is get the File name which this class will read
	 */
	public static void main(String args[] ) {
		int NumberOfLines = 0;
		int NumberOfCharacters = 0;
		double TotalOfDouble = 0.0;
		double d = 0.0;  //double value 
		int CountDoubleEachLine = 0;
		int NumberOfNotSkipped = 0;
		int NumberOfSkipped = 0;
		double LargestValue = 0.0;
		double MinimumValue = 0.0;
		int CountDoubleALL = 0;
	
		if ( args.length != 1 ) {
			System.out.println("USAGE: java DemoFileRead <filename>");
			System.exit(0);
		}

		try ( 
			FileInputStream fstream = new FileInputStream( args[0] );
			DataInputStream in = new DataInputStream( fstream );	
			BufferedReader br = new BufferedReader( new InputStreamReader(in));

//  args[0]  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 
			)
		{
		String strLine;
/**
 * This while loop is reading a single command line. Find the double value from each line
 */
		while ( ( strLine = br.readLine() ) != null ) { 
			System.out.println(strLine);
			NumberOfLines += 1;
			NumberOfCharacters = NumberOfCharacters + strLine.length();
              
			String[] s = strLine.split(" ");
		
			Pattern p = Pattern.compile("(-?\\d+\\.\\d+)");
	
			for(int i = 0; i< s.length; i++){
				Matcher m = p.matcher(s[i]);
				if(m.find()){
					d = Double.parseDouble(m.group());
					System.out.println(d);
					TotalOfDouble += d;
					CountDoubleEachLine += 1;
					CountDoubleALL += 1;
					 if( LargestValue < d){
						LargestValue = d;
					 }
					 else if(MinimumValue > d){
						 MinimumValue = d;
					 }
				}
            }


			if(CountDoubleEachLine > 0){
				NumberOfNotSkipped += 1;
			}

            CountDoubleEachLine = 0;

			  
		}

		}
        /**
		 * 
		 */
		catch( FileNotFoundException fnf ) {
			System.out.println("ERROR: The file " + args[0] + " was not found ");
		}

		catch( IOException ioe ) {
			System.out.println("ERROR: Input Output Error");
		}
         


		NumberOfSkipped =  NumberOfLines - NumberOfNotSkipped  ;
		//System.out.println("Summary for file " + args[0] ); !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		System.out.println("Summary for file Sphere.java: ");   //// DELETE FOR FINAL
		System.out.println("Number of Lines " + NumberOfLines );
		System.out.println("There are " + CountDoubleALL + " double values in the all lines" );
		System.out.println("Total of the Double values " + TotalOfDouble );
		System.out.println("Total of Skpped line: " + NumberOfSkipped );
		System.out.println("Number of Characters " + NumberOfCharacters );
		System.out.println("The largest value " + LargestValue );
		System.out.println("The minmum value " + MinimumValue );
		
	}

}

