package sk.kosickaakademia.deco.files;

import java.io.*;

public class RWFiles {
    public void copyFileTurnToUCase(String fileName){
        try {
            FileReader fl=new FileReader(fileName);
            File file=new File("output/"+genName());
            file.createNewFile();
            FileWriter fw=new FileWriter(file);
            BufferedReader br=new BufferedReader(fl);
            String line;

            while((line=br.readLine())!=null){
                line=line.toUpperCase();
                System.out.println(line);
                fw.write(line/*+'\n'*/);
            }
            fl.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String genName() {
        return null+".txt";
        // TODO: 11/11/2020 change retutn to cas
    }
}
