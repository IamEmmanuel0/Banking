package mybank;
import java.util.Scanner;
public class Transactions {
    private double balance = 0.0;
    private String account;
    
    public String getBalance(){
        String statement = "Current Balance: $" + this.balance;
        return statement;
    }
    
    private String getAccount(){
        return this.account;
    }
    
    public String Deposit(double Amt){
        this.balance += Amt;
        String statement = "Deposit of: $" + Amt + " was made. \nCurrent Balance: $" + this.balance;
        return statement;
    }

    public String Withdraw(double Amt){
        String statement = "";
        if(Amt <= this.balance){
        this.balance -= Amt;
        return "Withdrawal of: $" + Amt + " was made. \nCurrent Balance: $" + this.balance;
        }
        return "Insufficient fund!!!";
    }
    
    public String Transfer(double Amt, String Acc){
        if(Amt <= this.balance){
            if(Acc.length() == 10){
                this.balance -= Amt;
                this.account = Acc;
                return "Transfer of: $" + Amt + " was made to "+ this.account +". \nCurrent Balance: $" + this.balance;
            }
            return "Invalid Account number!!!";
        }
        return "Insufficient fund!!!";
    }
    
    public void Transaction(){
        Scanner input = new Scanner(System.in);
        boolean answer = true;
        while(answer){
            System.out.println("""
                               What transaction do you which to perform? Enter:
                               1. To Deposit
                               2. To Withdraw
                               3. To Transfer
                               4. To Check Balance""");
            int what = input.nextInt();
            double x = 0;
            switch(what){
                case 1:
                    System.out.print("How much do you want to Deposit: ");
                    x = input.nextDouble();
                    System.out.println(this.Deposit(x));
                    break;
                case 2:
                    System.out.print("How much do you want to Withdraw: ");
                    x = input.nextDouble();
                    System.out.println(this.Withdraw(x));
                    break;
                case 3:
                    System.out.print("How much do you want to Transfer: ");
                    x = input.nextDouble();
                    System.out.print("Enter account number: ");
                    String y = input.next();
                    System.out.println(this.Transfer(x,y));
                    break;
                case 4:
                    System.out.println(this.getBalance());
                    break;
                default:
                    System.out.println("Invalid input: ");
            }
            System.out.println("""
                             Do you which to make another transaction? Enter
                             1. Yes
                             2. No""");
            int ans = input.nextInt();
            switch(ans){
                case 1:
                    answer = true;
                    break;
                case 2:
                    answer = false;
                    System.out.println("Thanks for banking with us!");
                    break;
                default:
                    System.out.println("Invalid input: ");
                    answer = false;
        }
    }
}
}
