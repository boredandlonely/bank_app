package Application;
import java.util.Random;
import java.util.Scanner;
public abstract class Account {

    private String name;

    protected String user;
    private String socialSN;
    private double balance;

    static int index = 1000;

    public String accountNumber;

    protected String password;

    protected int passwordLength = 32;

    private String passwordCharacterList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";

    double rate;

    private Scanner scan;

    // constructor
    public Account(String name, String socialSN, double deposit) {

        this.name = name;
        this.socialSN = socialSN;
        balance = deposit;
        this.accountNumber = setAccountNumber();


      if(Login(name,password) == true){
          this.user =  createUserName(name);
          this.password = accPass(scan,passwordLength);
      } else {
          this.user =  createUserName(name);
          this.password = accPass(scan,passwordLength);
      }




    }


    // creates account num for user
    private String setAccountNumber() {
        index++;
        String lastTwoSSN = socialSN.substring(socialSN.length()-2);
        int setID = index;
        int randomAccNum = (int)(Math.random() * Math.pow(10,3));


        return lastTwoSSN + setID + randomAccNum;
    }


    private boolean Login(String username, String pass){
      scan = new Scanner(System.in);
       System.out.println("WELCOME TO GENERIC BANK APP (trademark pending)");
        System.out.println("DO YOU HAVE A LOGIN, YES or NO?");
        String loginQuestion = scan.next();
        if(loginQuestion.equalsIgnoreCase("YES")){
            System.out.println("ENTER USERNAME:");
            String usern = scan.next();
            System.out.println("ENTER PASSWORD:");
            String passer = scan.next();
            if(usern.equals(user) && passer.equals(password)){
                info();
                return true;
            } else {
                System.out.println("WRONG INFO");
                return false;
            }
        } else if (loginQuestion.equalsIgnoreCase("NO")) {

                return false;
        } else{return false;}


    }

    //ASAP FOCUS AND WORK ON USERNAME CREATION METHOD
    protected String createUserName(String username){
        scan = new Scanner(System.in);
        System.out.println("CREATE A NEW USERNAME: Enter Yes to create one, or No to have one generated for you");
        String answer = scan.next();
        if(answer.equalsIgnoreCase("Yes")){
            System.out.println("ENTER YOUR USERNAME: ");
            return username = scan.next();
        } else if(answer.equalsIgnoreCase("No")){
            return new String(randomUserNameGen(username));
        } else{
            System.out.println("Invalid input, generating your username.......");
            return new String(randomUserNameGen(username));
        }

   }
   //this will generate a random username if "No" is selected or in the case of invalid input
   private String randomUserNameGen(String username){

       this.name = username;
       String[] user = username.split(" ");

       String characters = "";

       for(String letters : user){
           if(!letters.isEmpty()){
               characters += letters.charAt(0);
           }
       }
       Random randy = new Random();
       int rand = randy.nextInt(100);
       username = characters + rand;
       return username;
   }



    // accPass and randPass are for password creation
    protected String accPass(Scanner scanner, int password) {
        scanner = new Scanner(System.in);
        System.out.println("WOULD YOU LIKE TO CREATE YOUR OWN PASSWORD? Yes or No?");
         String answer = scanner.next();
        if (answer.equalsIgnoreCase("Yes")) {
            System.out.println("Enter a password: ");
           return scanner.next();

        } else if (answer.equalsIgnoreCase("No")) {
            randPassGenerator(password);
            return new String(randPassGenerator(password));

        } else{
            System.out.println("Invalid input, generating random password......");
            return randPassGenerator(password);
        }

    }
    // this will generate a random password for the user if they choose not to enter one or enter invalid input
    private String randPassGenerator(int password){
        char[] pass = new char[password];
        for (int i = 0; i < password; i++) {
            int randPassCreate = (int) (Math.random() * passwordCharacterList.length());
            pass[i] = passwordCharacterList.charAt(randPassCreate);
        }
        return new String(pass);
    }
    // password reset
    public String passwordReset(String newPassword){
         return this.password = newPassword;
    }






    // deposit, withdraw, transfer
    public void deposit(double input){
        balance = balance + input;
        System.out.println("DEPOSITING $" + input);
        System.out.printf("CURRENT BALANCE IS: $%.2f\n",balance);
    }
    public void withdraw(double input){
        balance = balance - input;
        System.out.println("WITHDRAWING $" + input);
        System.out.printf("CURRENT BALANCE IS: $%.2f\n",balance);
    }

    public void transfer(String location, double amount){
        balance = balance - amount;
        System.out.println("TRANSFERRING $" + amount + " TO "+location);
        System.out.printf("CURRENT BALANCE IS: $%.2f\n",balance);
    }

    public void info(){
        System.out.printf("USERNAME: %s \nNAME: %s \nACCOUNT: %s \nPASSWORD: %s \nBALANCE: $%.2f",user,name,accountNumber,password,balance);



    }


}
