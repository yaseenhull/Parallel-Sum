// Parallel Sum
// 17 September 2018
// Yaseen Hull

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.io.*;

public class demo {

	static final ForkJoinPool fjPool = new ForkJoinPool();

	static float sum(Tree[] arr, float [] in, float [] out ){
		ParallelSum one = new ParallelSum(arr,0,arr.length,in, out);

	    return fjPool.invoke(one);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String outfile = null;
		Scanner fileIn = null;
		try {
			Scanner inLine = new Scanner(System.in); // reads in files line
			String input = inLine.nextLine();
			String [] o = input.split(" "); 
			String infile = o[0];
			outfile = o[1];
			fileIn = new Scanner(new FileInputStream(infile));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}

		int terX = fileIn.nextInt(); // reads in terrain dimensions as integer
		int terY = fileIn.nextInt();
		String space = fileIn.nextLine();
		float [] data = new float[terX*terY]; // creates array of twith terrain data size

		for(int i =0; i<terX*terY; i++) {
			data[i] = fileIn.nextFloat(); // adds all terrain data from file to array

		}

		String space2 = fileIn.nextLine();


		int trees = fileIn.nextInt();
		int i = 0;
		float [] sumValues = new float[trees];
		Tree [] treelist = new Tree[trees];

		while (i<trees) {
			int xtre = fileIn.nextInt();
			int ytre = fileIn.nextInt();
			int ext = fileIn.nextInt();

			Tree tree = new Tree(terX, terY,xtre, ytre, ext); // creates tree object
			treelist[i] = tree; // add tree to list

			i++;

		}

		long start = System.nanoTime();
		float totalSum = sum(treelist, data, sumValues); // executes parallelsum with total of all areas returned

		long end = System.nanoTime();
		long total = end-start;

		//System.out.println(total/1000000000.0);


	  BufferedWriter bw = null; //writer is created
		FileWriter fw = null;

		try{

				fw = new FileWriter(outfile); //file to write to specified
				bw = new BufferedWriter(fw);

				bw.write(String.format("%.6f", (double)totalSum/trees)+"\n"); //average set to 6 decimal places
				bw.write(String.valueOf(trees)+"\n");

				for(int j =0; j<trees; j++) {

					bw.write(String.format("%.6f",sumValues[j] )+"\n"); // writes each trees area to file
				}

		}

		catch(IOException er){
				er.printStackTrace();
		}

		finally{
				try{
						if(bw != null)
							bw.close();
						if(fw != null)
							fw.close();

				}
				catch(IOException er){
						er.printStackTrace();
				}
		}

	}

}
