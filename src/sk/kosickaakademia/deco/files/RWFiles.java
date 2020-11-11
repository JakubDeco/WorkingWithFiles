package sk.kosickaakademia.deco.files;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RWFiles {
    public void copyFileTurnToUCase(String fileName){
        try {
            FileReader fr=new FileReader(fileName);

            File file=new File("output/"+genName('B'));
            if (!file.createNewFile()) {
                System.out.println("Name of the file you want create already exists in this directory. " +
                        "Application will now stop");
                return;
            }

            FileWriter fw=new FileWriter(file);
            BufferedReader br=new BufferedReader(fr);
            String line;

            while((line=br.readLine())!=null){
                line=line.toUpperCase();
                fw.write(line+'\n');
            }

            br.close();
            fw.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String genName(char prefix) {
        LocalTime lt=LocalTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("hhmmss");
        String formattedTime=lt.format(dtf);

        return prefix+"_"+formattedTime+".txt";
    }

    public void copyFileTurnToCCipher(String filename) {
        try {
            //reading source file and creating new file to be filled with cipher
            FileReader fr=new FileReader("resources/A.txt");
            File file=new File("output/"+genName('C'));
            if (!file.createNewFile()) {
                System.out.println("Name of the file you want create already exists in this directory. " +
                        "Application will now stop");
                return;
            }
            //
            FileWriter fw=new FileWriter(file);
            BufferedReader br=new BufferedReader(fr);
            String line;

            while((line=br.readLine())!=null){
                char[] arr=new char[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    arr[i]=line.charAt(i);
                }
                //method  shifting characters by int shift
                arr= shiftingArray(arr,3);
                //array to string
                StringBuilder sb=new StringBuilder(arr.length);
                sb.append(arr);
                line=sb.toString();

                fw.write(line+'\n');
            }
            //
            br.close();
            fw.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private char[] shiftingArray(char[] arr, int shift) {
        for (int i = 0; i < arr.length; i++) {
            char help=arr[i];

            //cycling for number characters Dec48-57
            if (help>47 && help<58){
                help=(char)(help+shift);
                help=help>57?(char)(help-10):help;//ternarny operator
            }
            //cycling for upper case characters Dec65-90
            else if (help>64 && help<91){
                help=(char)(help+shift);
                help=help>90?(char)(help-26):help;//ternarny operator
            }
            //cycling for lower case characters Dec97-122
            else if (help>96 && help<123){
                help=(char)(help+shift);
                help=help>122?(char)(help-26):help;//ternarny operator
            }
        }
        return arr;
    }
}
