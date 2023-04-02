package bank.application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SBI.rateOfInterest=7;
        HdfcBank.rateOfInterest=6;
        SBI account1=new SBI(100000,"123","Dev");
        SBI account2=new SBI(150000,"1234","Honey");

        HdfcBank account3=new HdfcBank(150000,"789","yoyo");
        // Wrong Password
        int balance=account1.checkBalance("124");
        System.out.println("The balance for account1 is "+balance);

        int balanceCheck=account1.checkBalance("123");
        System.out.println("The balance for account1 is "+balanceCheck);

        String bankMessage=account2.addMoney(50000);
        System.out.println(bankMessage);

        String message= account3.withdrawMoney(50000,"1234");
        System.out.println(message);

        String message1= account3.withdrawMoney(50000,"789");
        System.out.println(message1);

        // SBI
        double interest=account1.calculateTotalInterest(20);
        System.out.println("The total interest you will get is "+interest);

        // HDFC
        double interest1=account3.calculateTotalInterest(20);
        System.out.println("The total interest you will get is "+interest1);

        System.out.println("Welcome to SBI. Please enter the details");
        System.out.println("Enter name");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        System.out.println("Enter balance: ");
        int initialBalance=sc.nextInt();
        System.out.println("Enter password ");
        String password=sc.next();

        SBI sbiAccount=new SBI(initialBalance,password, name);
    }
}