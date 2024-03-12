package Main;

import MyExceptions.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author m.e.morse39757
 */
public class Main {

    public static void main(String[] args) {
        String outputFile;
        String inputFile;
        File inFile;
        Scanner input;
        ArrayList<String> titles = new ArrayList<String>();
        String temp;

        outputFile = JOptionPane.showInputDialog("Enter the output file name");

        JFileChooser chooser = new JFileChooser(".");

        int status = chooser.showOpenDialog(null);

        if (status != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "No File Selected");
        } else {
            inFile = chooser.getSelectedFile();
            inputFile = inFile.getAbsolutePath();
            System.out.println(inputFile);

            try {
                input = new Scanner(inFile);
                while (input.hasNext()) {
                    try {
                        temp = input.nextLine();
                        if (titles.contains(temp)) {
                            throw new TitleDuplicate("The title " + temp + " is a duplicate");
                        } else {
                            titles.add(temp);
                        }
                    } catch (TitleDuplicate ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
                if(titles.size() > 0){
                    try{
                        FileWriter fw = new FileWriter(outputFile);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter outFile = new PrintWriter(bw);
                        
                        for(String temp2 : titles){
                            outFile.println(temp2);
                        }
                        outFile.close();
                    }
                    catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            } catch (FileNotFoundException ex) {

            }
        }
    }
}
