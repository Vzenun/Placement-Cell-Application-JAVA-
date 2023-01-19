package learnprogramming;

import java.util.Scanner;

public class Main { // Starting of the main application.

    public static void Choice_main_1(){ //Enter the Application
        ChoiceA cs_a=new ChoiceA();
        cs_a.main();//Now goes to choice A class
    }
    public static void Choice_main_2(){ //Exit the Application
        System.out.println("Thanks For Using FutureBuilder app!!!!!!");
        System.exit(0);
        //You have exited the application.
    }

    public static void input_main(){
        String choice="Enter your choice: ";
        System.out.print(choice);
        Scanner sc=new Scanner(System.in);
        boolean hasNextInt=sc.hasNextInt();
        if(hasNextInt) {
            int n= sc.nextInt(); //n is the choice number
            sc.nextLine();
            System.out.println();
            if(n==1){//Enter the Application
                Choice_main_1();
            }
            else if(n==2){//Exit the Application
                Choice_main_2();
            }
            else{
                System.out.println("Sorry,you entered an invalid value,choose again.");
                System.out.println();
                main();
            }
        }
        else{
            System.out.println("Sorry,you entered an invalid value,choose again.");
            System.out.println();
            main();
        }
        sc.close();
    }
    public static void main(){ //Giving the choice to whether enter or exit the application.
        System.out.println("Welcome to FutureBuilder:");
        System.out.println("   1) Enter the Application");
        System.out.println("   2) Exit the Application");
        input_main();
    }
    public static void main(String[] args){ //
        System.out.print("Input:- ");
        Scanner sc=new Scanner(System.in);
        String a= sc.nextLine();
        Boolean t=false;
        if(a.equals("Enter FutureBuilder")) {
            t=true;
        }
        if(t){
            main();
        }
    }
}
