package learnprogramming;

import java.util.Scanner;

public class ChoiceAAB { // Add students
    public void input_AAB(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of students to add: ");
        boolean hasNextInt=sc.hasNextInt();
        if(hasNextInt){
            int n=sc.nextInt();  //Number of students to add
            sc.nextLine();
            if(n>=1){
                System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
                for(int i=0;i<n;i++) {
                    System.out.println("Enter the details of Student:");
                    System.out.print("Enter your name: ");
                    String name=sc.nextLine();
                    System.out.print("Enter your roll number: ");
                    int roll_num=sc.nextInt();
                    System.out.print("Enter your cgpa: ");
                    double cgpa=sc.nextDouble();
                    System.out.print("Enter your Branch: ");
                    String branch=sc.nextLine();
                    sc.nextLine();
                    Student student=new Student(name,roll_num,cgpa,branch);//we have made a student instance here
                    Institute_Placement_Cell.add_student(student);
                    //here we have added the whole instance as a value of the key<name> in Hash map Add_student_record.
                    System.out.println();
                }
            }
            else{
                System.out.println("Sorry,you entered an invalid value,choose again.");
                System.out.println();
                this.main();
            }
        }
        else{
            System.out.println("Sorry,you entered an invalid value,choose again.");
            System.out.println();
            this.main();
        }
    }
    public void main(){
        this.input_AAB();
    }
}
