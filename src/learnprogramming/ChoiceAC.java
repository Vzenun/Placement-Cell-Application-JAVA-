package learnprogramming;

import java.util.HashMap;
import java.util.Scanner;

public class ChoiceAC { //Enter as Placement Cell Mode
    public void Choice_ac_1(Scanner sc){ // Open Student Registrations
        //as stated by the dev I can use compare function.
        //Here I have to add a compare function which would check if we have set the
        // deadlines after company deadlines or not if not we would have to ask user again to input correct one.
        if(Institute_Placement_Cell.open_student_reg(sc)){
            System.out.println();
            main();
        }
        else{
            Choice_ac_1(sc);
        }
    }
    public void Choice_ac_2(Scanner sc){ // Open Company Registrations
        Institute_Placement_Cell.open_company_reg(sc);
        System.out.println();
        main();
    }
    public void Choice_ac_3(){ // Get Number of Student Registrations
        System.out.println(Institute_Placement_Cell.number_stud_register());
        main();
    }
    public void Choice_ac_4(){ // Get Number of Company Registrations
        System.out.println(Institute_Placement_Cell.number_comp_register());
        main();
    }
    public void Choice_ac_5(){ // Get Number of Offered/Unoffered/Blocked Students
        //Here iterating over all registered students.
        int offered=0;
        int unoffered=0;
        int blocked=0;
        for (HashMap.Entry<String,Student> entry : Institute_Placement_Cell.Reg_student_record.entrySet()){
            if(entry.getValue().getCurrent_status()==0){
                unoffered++;
            }
            else if(entry.getValue().getCurrent_status()==1){
                offered++;
            }
            if(entry.getValue().getCurrent_status()==0){
                blocked++;
            }
        }
        System.out.println("Number of student with offer:"+offered);
        System.out.println("Number of student without an offer:"+unoffered);
        System.out.println("Number of student blocked from any offers:"+blocked);
        main();

    }
    public void Choice_ac_6(){ // Get Student Details
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the student:");
        String name=sc.nextLine();
        System.out.print("Enter roll number:");
        int roll_num=sc.nextInt();
        sc.nextLine();
        Institute_Placement_Cell.getStudentDetails(name,roll_num);
        main();
    }
    public void Choice_ac_7(){ // Get Company Details
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the company:");
        String name=sc.nextLine();
        sc.nextLine();
        Institute_Placement_Cell.getCompanyDetails(name);
        main();
    }
    public void Choice_ac_8(){ // Get Average Package
        int num_stud_reg=Institute_Placement_Cell.number_stud_register();
        double max=0;
        for (HashMap.Entry<String,Student> entry : Institute_Placement_Cell.Reg_student_record.entrySet()){
            if(entry.getValue().isPlaced()){
                max+= entry.getValue().getHighest_ctc_held();
            }
        }
        double avg=max/num_stud_reg;
        System.out.println("Average Package: "+avg);
        main();
    }
    public void Choice_ac_9(String name){ // Get Company Process Results
        //print the details of the student with the highest offer.
        Institute_Placement_Cell.get_company_process_results(Institute_Placement_Cell.Reg_company_record.get(name));
        main();
    }
    public void Choice_ac_10(){ //Back to ChoiceA
        ChoiceA cs_a=new ChoiceA();
        cs_a.main();
    }
    public void input_AC(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you choice: ");
        boolean hasNextInt=sc.hasNextInt();
        if(hasNextInt){
            int n=sc.nextInt();
            sc.nextLine();
            System.out.println();
            if(n==1){ // Enter as a Student(Give Student Name, and Roll No.)
                Choice_ac_1(sc);
            }
            else if(n==2){ //Open Company Registrations
                Choice_ac_2(sc);
            }
            else if(n==3){ //Back to Choice A
                Choice_ac_3();
            }
            else if(n==4){ // Add students
                Choice_ac_4();
            }
            else if(n==5){ //Back to Choice A
                Choice_ac_5();
            }
            else if(n==6){ // Add students
                Choice_ac_6();
            }
            else if(n==7){ //Back to Choice A
                Choice_ac_7();
            }
            else if(n==8){ // Add students
                Choice_ac_8();
            }
            else if(n==9){ //Back to Choice A
                System.out.print("Enter the company name: ");
                String name= sc.nextLine();
                Choice_ac_9(name);
            }
            else if(n==10){ //Back to Choice A
                Choice_ac_10();
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
        sc.close();
    }
    public void main(){ //Enter as Placement Cell Mode
        System.out.println("Welcome to IIITD Placement Cell");
        System.out.println("   1) Open Student Registrations");
        System.out.println("   2) Open Company Registrations");
        System.out.println("   3) Get Number of Student Registrations");
        System.out.println("   4) Get Number of Company Registrations");
        System.out.println("   5) Get Number of Offered/Unoffered/Blocked Students");
        System.out.println("   6) Get Student Details");
        System.out.println("   7) Get Company Details");
        System.out.println("   8) Get Average Package");
        System.out.println("   9) Get Company Process Results");
        System.out.println("   10) Back");
        this.input_AC();
    }
}
