import java.io.*;
import java.util.*;

public class compare{

  public static void main(String[] args ){

  Scanner fileIn = null;
  Scanner fileIn2 = null;
  try {
    Scanner inLine = new Scanner(System.in);
    String input = inLine.nextLine();
    String [] o = input.split(" ");
    String infile = o[0];
    String outfile = o[1];
    fileIn = new Scanner(new FileInputStream(infile));
    fileIn2 = new Scanner(new FileInputStream(outfile));
  }
  catch(FileNotFoundException e) {
    System.out.println("File not found.");
    System.exit(0);
  }

  double average = fileIn.nextDouble();
  double average2 = fileIn2.nextDouble();

  String line = fileIn.nextLine();
  String line2 = fileIn2.nextLine();

  int trees = fileIn.nextInt();
  int trees2 = fileIn2.nextInt();

  String line3 = fileIn.nextLine();
  String line4 = fileIn2.nextLine();

  for(int i=0; i<trees; i++){
    float value = fileIn.nextFloat();
    float value2 = fileIn2.nextFloat();
    if(value != value2){
      System.out.println("Error on line "+i+1);
      //System.out.println(i+1+"hoya");
    }

    //String line5 = fileIn.nextLine();
    //String line6 = fileIn2.nextLine();
  }

  }
}
