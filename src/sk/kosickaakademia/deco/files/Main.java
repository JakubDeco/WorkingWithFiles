package sk.kosickaakademia.deco.files;

public class Main {
    public static void main(String[] args) {
        RWFiles rwFiles=new RWFiles();
        //calling a method to copy and turn a file to upper case
        //rwFiles.copyFileTurnToUCase("resources/A.txt");
        //calling a method to copy and turn a file into caesar cipher(shift)
        rwFiles.copyFileTurnToCCipher("resources/A.txt");
    }
}
