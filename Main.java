package Application;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
public static void main(String[] args){


List<Account> accounts = new ArrayList<>();

String file = "C:\\project\\bank_app\\file.csv";

List<String[]> newMembers =csv.read(file);

    for(String[] accountMembers : newMembers){
        String username = accountMembers[0];
        String name = accountMembers[1];
        String sSN = accountMembers[2];
        String accountType = accountMembers[3];
        double deposit  = Double.parseDouble(accountMembers[4]);


        if(accountType.equalsIgnoreCase("Savings")){
            accounts.add(new Saving(name,sSN,deposit));
        } else if (accountType.equalsIgnoreCase("Checking")) {
            accounts.add(new Checking(name,sSN,deposit));
        } else{
            System.out.println("ERROR READING THE ACCOUNT INFORMATION...........");
        }
    }

    for(Account account: accounts){
        System.out.println("\n---------------------------------");
        account.info();
    }



}


}
