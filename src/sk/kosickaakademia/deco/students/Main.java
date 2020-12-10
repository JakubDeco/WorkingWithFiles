package sk.kosickaakademia.deco.students;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Student[] students=null;
        students = readStudentsFromFile(students);
        printStudents(students);
        printFemales(students);

        readContactsFromFile(students);
        System.out.println(students[1].getContact().getEmail()+" "+students[1].getContact().getSkype());
    }

    private static void readContactsFromFile(Student[] students) {
        try {
            FileReader fileReader=new FileReader("resources/contacts.dat");
            BufferedReader bf=new BufferedReader(fileReader);

            String line;
            String[] help;
            while ((line=bf.readLine())!=null){
                help=line.split(" ");
                for (Student i : students) {
                    if (help[0].equals(i.getfName())&&help[1].equals(i.getlName())){
                        System.out.println("Found match in contacts with students ");
                        for (int j = 2; j < help.length; j++) {
                            String[] contact=help[j].split("=");
                            switch (contact[0]){
                                case "email":i.getContact().setEmail(contact[1]); break;
                                //
                                case "mobil":i.getContact().setMobil(contact[1]); break;
                                case "skype":i.getContact().setSkype(contact[1]);
                                //
                            }
                        }
                    }
                }
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student[] readStudentsFromFile(Student[] students) {
        try {
            FileReader fileReader=new FileReader("resources/students.dat");
            String line;
            BufferedReader bufferedReader=new BufferedReader(fileReader);

            line=bufferedReader.readLine();
            int count=Integer.parseInt(line);
            students =new Student[count];

            for (int i = 0; i < students.length; i++) {
                line=bufferedReader.readLine();
                String[] helpString=line.split(" ");
                double height=Double.parseDouble(helpString[3]);
                double weight=Double.parseDouble(helpString[4]);
                Student helpStudent=new Student(helpString[0],helpString[1],helpString[2],height,weight);
                students[i]=helpStudent;
            }




            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    private static void printFemales(Student[] students) {
        System.out.println();
        System.out.println("List of female students:");
        for (Student help : students) {
            if (help.getGender()==Gender.FEMALE)
                help.printStudent();
        }
    }

    private static void printStudents(Student[] students) {
        System.out.println("List of all students:");
        for (Student s: students) {
            s.printStudent();
        }

    }
}
