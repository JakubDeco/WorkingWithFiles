package sk.kosickaakademia.deco.students;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private String fName;
    private String lName;
    private String id;
    private double height;//m
    private double weight;//kg
    private int age;
    private Gender gender;
    private Contact contact;

    public Student(String fName,String lName,String id,double height,double weight){
        this.fName=fName;
        this.lName=lName;
        this.id=id;
        this.height=height;
        this.weight=weight;
        age=setAge();
        gender=getGender(id);
        contact=new Contact();
    }

    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public String getId() {
        return id;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }

    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Gender getGender(String id) {
        return id.charAt(2)>'4'?Gender.FEMALE:Gender.MALE;
    }
    public Gender getGender(){
        return gender;
    }

    private int setAge() {
        int idYear=Integer.parseInt(id.substring(0,2));
        if (idYear<53)
            idYear+=2000;
        else idYear+=1900;

        int idMonth=Integer.parseInt(id.substring(2,4));
        int idDay=Integer.parseInt(id.substring(4,6));

        LocalDate ld=LocalDate.now();
        String date= ld.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int year=Integer.parseInt(date.substring(0,4));
        int month=Integer.parseInt(date.substring(4,6));
        int day=Integer.parseInt(date.substring(6,8));

        if (idMonth<month)
            return year - idYear;

        else if(idDay<=day)
            return year - idYear;

        else
            return year - idYear -1;
        //todo could be simplified Date object.compareTo(Date anotherObject)
    }

    public void printStudent() {
        System.out.println(fName+" "+lName+" "+id+" "+height+" "+weight+" "+age+" years");
    }
}
