package learnprogramming;

import java.util.HashMap;
import java.util.Scanner;

public class ChoiceAAA { // Enter as a Student(Give Student Name, and Roll No.)
    public void input_another_AAA(Student student){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you choice: ");
        boolean hasNextInt=sc.hasNextInt();
        if(hasNextInt){
            int n=sc.nextInt();
            sc.nextLine();
            if(n==1){ // Register For Placement Drive
                if(!student.setDate()){
                    another_main(student);
                }
                Institute_Placement_Cell.reg_student(student);//i have put it in registered students hash map.
                System.out.println(student.getName()+", you are successfully registered for the Placement Drive at IIITD!!!!");
                System.out.println("Your details are:");
                System.out.println("Name: "+student.getName());
                System.out.println("Roll number: "+student.getRollNumber());
                System.out.println("CGPA: "+student.getCgpa());
                System.out.println("Branch: "+student.getBranch());
                System.out.println();

            }
            else if(n==2){ // Register For Company this is different from the register For Placement Drive
                System.out.print("Please enter Company name:");
                String name = sc.nextLine();
                sc.nextLine();
                if(student.reg_for_company(Institute_Placement_Cell.Reg_company_record.get(name))){
                    System.out.println("Successfully registered for "+Institute_Placement_Cell.Reg_company_record.get(name).getRole()+" at "+name);
                }
                else{
                    System.out.println("You are not eligible to register for "+Institute_Placement_Cell.Reg_company_record.get(name).getRole()+" at "+name);
                }
            }

            else if(n==3){ //Get All available companies that student registered for.
                System.out.println("List of all available companies are as follows:");
                //Here we have to print all the companies in which student registered with all their field values.
                student.get_all_available_companies();
            }
            else if(n==4){ // Get Current Status
                if(student.getCurrent_status()==0){
                    System.out.println("Status:Unoffered");
                }
                else if(student.getCurrent_status()==-1){
                    System.out.println("Status:Blocked");
                }
                else{
                    System.out.println("Status:Offered");
                    double max=0;
                    for (HashMap.Entry<Double,Company> entry : student.getOffer_by_comp().entrySet()) {
                        if(max< entry.getKey()){
                            max= entry.getKey();
                        }
                    }
                    System.out.println("You got an offer from "+student.getOffer_by_comp().get(max).getName()+" of "+student.getOffer_by_comp().get(max).getPackage_offer()+" as a "+student.getOffer_by_comp().get(max).getRole());
                }
            }
            else if(n==5){ //Update CGPA
                System.out.println("Enter your old cgpa:");
                double old_cgpa = sc.nextDouble();
                sc.nextLine();
                System.out.println("Enter your new cgpa:");
                double new_cgpa = sc.nextDouble();
                Institute_Placement_Cell.update_cgpa(student,new_cgpa,old_cgpa);
                sc.nextLine();
            }
            else if(n==6){ //Accept offer
                student.setPlaced(true);
                double max=0;
                for (HashMap.Entry<Double,Company> entry : student.getOffer_by_comp().entrySet()) {
                    if(max< entry.getKey()){
                        max= entry.getKey();
                    }
                }
                student.setHighest_ctc_held(student.getOffer_by_comp().get(max).getPackage_offer());
                System.out.println("Congratulations "+student.getName() +"!!! You have accepted the offer by "+student.getOffer_by_comp().get(max).getName());
            }
            else if(n==7){ //Reject offer
                if(student.getCurrent_status()==0){
                    System.out.println("You do not have any offer to reject.");
                }
                else{
                    System.out.println("You have been blocked from the placement drive");
                }
            }
            else if(n==8){ //Back to Choice AA
                ChoiceAA cs_aa=new ChoiceAA();
                cs_aa.main();
            }
            else{
                System.out.println("Sorry,you entered an invalid value,choose again.");
                System.out.println();
                this.main();
            }
            this.another_main(student);
        }
        else{
            System.out.println("Sorry,you entered an invalid value,choose again.");
            System.out.println();
            this.main();
        }
        sc.close();
    }

    public void another_main(Student student){
        System.out.println("Welcome "+student.getName());
        System.out.println("   1) Register For Placement Drive");
        System.out.println("   2) Register For Company");
        System.out.println("   3) Get All available companies");
        System.out.println("   4) Get Current Status");
        System.out.println("   5) Update CGPA");
        System.out.println("   6) Accept offer");
        System.out.println("   7) Reject offer");
        System.out.println("   8) Back");
        input_another_AAA(student);
    }
    public void input_AAA(){ // Enter as a Student(Give Student Name, and Roll No.)
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter students Name, Roll No (line by line):");
        // Vidur Goel
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        //2021364
        System.out.print("Enter roll number: ");
        int roll_num = sc.nextInt();
        sc.nextLine();
        System.out.println();
        another_main(Institute_Placement_Cell.Add_student_record.get(name));//here both reg and unreg student can enter the portal.
        sc.close();
        }

    public void main(){ // Enter as a Student(Give Student Name, and Roll No.)
        this.input_AAA();
    }
}
