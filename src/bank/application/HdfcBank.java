package bank.application;

import java.util.UUID;

public class HdfcBank implements BankInterface{
    private int balance;
    private String accountNo;
    private String password;
    public String name;
    public static double rateOfInterest;

    public HdfcBank(int balance, String password, String name) {
        this.accountNo= UUID.randomUUID().toString();
        this.balance = balance;
        this.password = password;
        this.name = name;
    }

    @Override
    public int checkBalance(String password) {
        if(password==this.password)
            return balance;
        return -1;
    }

    @Override
    public String addMoney(int money) {
        balance+=money;
        String message=money+" has been added to the account "+accountNo;
        return message;
    }

    @Override
    public String withdrawMoney(int drawMoney, String password) {
        if(password==this.password){
            if(drawMoney>balance)
                return "Insufficient Balance";
            balance-=drawMoney;
            return "Money withdrawn successfully";
        }
        return "Wrong Password";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password==oldPassword){
            this.password=newPassword;
            return "Password changed successfully";
        }
        return "Wrong Password";
    }

    @Override
    public double calculateTotalInterest(int years) {
        double interest=balance*rateOfInterest*years/100;
        return interest;
    }
}
