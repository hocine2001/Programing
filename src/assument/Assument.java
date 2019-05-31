package assument;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mosaabramadan
 */
public class Assument {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Property> inputList = new ArrayList();

    public static void main(String[] args) throws FileNotFoundException {
       
        inputList = readDataLineByLine("hocine/melb_data.csv");
        // ArrayList<Double> hocine = new ArrayList<Double>();
        System.out.println("enter the address");
        
        int r = 3067;

        double sum = 0;
        double sum2 = 0;
        double sm = 0;
        double sumxy = 0;
int z = 0;
        for (int i = 0; i < inputList.size(); i++) {

            if (inputList.get(i).address == r && 0!=inputList.get(i).sm) {
                 z =1;

                sum = sum + inputList.get(i).sm;

                sum2 = sum2 + (inputList.get(i).sm * inputList.get(i).sm);
                sm = sm + inputList.get(i).price;
                sumxy = sumxy + (inputList.get(i).sm * inputList.get(i).price);
            }
        }
        
        double s = inputList.size();
        double t;
        t = ((s * sumxy) - (sum * sm)) / ((s * sum2) - (sum * sum));
        double u;
        u = (sm / s) - (t * (sum / s));
System.out.println(u+"   "+t);
        double resalt;
        System.out.println("enter the address");
        double area = 424;
        resalt = (t * area) + u;
        if (z==1){System.out.println(resalt);}
if (z !=1) {System.out.println("sorry we dont have this adderss ");
    }
    }
    static ArrayList<Property> readDataLineByLine(String file) throws FileNotFoundException {

        Scanner fileinput = new Scanner(new BufferedReader(new FileReader(file)));
        ArrayList<Property> hocine1 = new ArrayList<Property>();

        while (fileinput.hasNextLine()) {
            String newline = fileinput.nextLine();
            Property toAdd = new Property();
            String[] line = newline.trim().split(",");
            
            
            toAdd.setPrice(Double.parseDouble(line[4]));
            toAdd.setAddress(Double.parseDouble(line[9]));
        toAdd.setSm(Double.parseDouble(line[13]));
        hocine1.add(toAdd);
            
            

        }

        return hocine1;

    }

}
    


