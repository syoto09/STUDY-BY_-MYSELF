import java.io.*;
 import java.util.regex.*;
/**
 * This class is used to represent reads a single command-line argument:
 * the name of a file to open and process.  To process this file, you will 
 * read it line-by-line and create a running Total of the double values contained in the file.
 * 
 *
 */
public class java_1  extends Object{

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
		
		double TotalOfDouble = 0.0;
		double d = 0.0;  //double value 
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
             // args[0]
			 // 

			)
		{
		String strLine;
/**
 * This while loop is reading a single command line. Find a double value from each line -----
 * If the line does not contain a double, the line will be skipped -----
 * This method also find the large and minimum value ------
 * NumberForExceptin - When the line contains non-numeric values or characters ----- 
 */
		while ( ( strLine = br.readLine() ) != null ) { 
			//System.out.println(strLine);
			NumberOfLines += 1;
            
			
            try{
				if(strLine.contains(".")){
                d = Double.valueOf(strLine);
				System.out.println(d);
                TotalOfDouble += d;
                CountDoubleALL += 1;
				}
				else{
					NumberOfSkipped += 1;
				}
        
            }
			catch(NumberFormatException nex){
             NumberOfSkipped += 1;
            }
            
            if( LargestValue < d){
                LargestValue = d;
             }
             else if(MinimumValue > d){
                 MinimumValue = d;
             }


        }

			  
		

		}
        /**
		 * FileNotFoundException - The file can not be found in your folder
		 */
		catch( FileNotFoundException fnf ) {
			System.out.println("ERROR: The file " + args[0] + " was not found ");
		}

        /**
         * IOException - when the construction of the canonical pathname may require file system queries
         */
		catch( IOException ioe ) {
			System.out.println("ERROR: Input Output Error");
		}
         

        System.out.println();
		//System.out.println("Summary for file " + args[0] ); 
		System.out.println();

		System.out.println("Number of Lines " + NumberOfLines );
		System.out.println("There are " + CountDoubleALL + " double values in the all lines" );
		System.out.println("Total of the Double values " + TotalOfDouble );
		System.out.println("Total of Skpped line: " + NumberOfSkipped );
		System.out.println();

		System.out.println("The largest value " + LargestValue );
		System.out.println("The minmum value " + MinimumValue );
		
	}

}
