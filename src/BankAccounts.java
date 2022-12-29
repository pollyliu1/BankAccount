public class BankAccounts {

    public static void main(String[] args) {
        // Using constructor
        System.out.println("--Creating three BankAccount instances...");
        BankAccount acc1 = new BankAccount("Goldman", "00001", 6135.2, 3.14);
        BankAccount acc2 = new BankAccount("Sachs", "00002", 4345.4, 2.78);
        BankAccount acc3 = new BankAccount("McMaster", "00003", 2355.9, 5.92);
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println("");

        // Using accessors and mutators
        System.out.println("--Getting Goldman's balance and McMaster's account number...\n");
        System.out.println("Goldman's balance: $" + acc1.getBalance());
        System.out.println("McMaster's account number: " + acc3.getAccNum());
        System.out.println("");

        System.out.println("--Setting Sachs' interest rate to 1.99% and account number to 00012...");
        acc2.setInterest(1.99);
        acc2.setAccNum("00012");
        System.out.println(acc2);
        System.out.println("");

        System.out.println("--Getting the first account holder's name...");
        System.out.println("Name: " + acc1.getName());
        System.out.println("");

        System.out.println("--McMaster legally changed his name to 'McGill'...");
        System.out.println("\nBefore:" + acc3);
        acc3.setName("McGill");
        System.out.println("\nAfter:" + acc3);
        System.out.println("");

        System.out.println("--Are the first and second accounts equal (same name and account number)?");
        System.out.printf("\nFirst account's name: %s, account number: %s", acc1.getName(), acc1.getAccNum());
        System.out.printf("\nSecond account's name: %s, account number: %s\n", acc2.getName(), acc2.getAccNum());
        boolean areEqual = acc1.equals(acc2);
        if (areEqual) {
            System.out.println("They have equal bank accounts.");
        } else{
            System.out.println("They do not have equal bank accounts.");
        }
        System.out.println("");

        // Using instance methods
        System.out.println("--Transferring $983.24 from Goldman to Sachs...");
        acc1.transfer(983.24, acc2);
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println("");

        System.out.println("--McGill earns simple interest over 9 months...");
        System.out.printf("\nBalance before: $%.2f", acc3.getBalance());
        acc3.simpInterest(9);
        System.out.printf("\nBalance after: $%.2f", acc3.getBalance());
        System.out.println("\n");

        System.out.println("--Sachs earns compound interest over 24 months with 2 compounding periods per year...");
        System.out.printf("\nBalance before: $%.2f", acc2.getBalance());
        acc2.compInterest(24, 2);
        System.out.printf("\nBalance after: $%.2f", acc2.getBalance());
        System.out.println("\n");

        // Using class method
        System.out.println("--Goldman tricks a scammer into giving him $300 instead...");
        BankAccount.transfer(300, new BankAccount("Scammer", "123456",3234236.23, 4.23), acc1);
        System.out.println(acc1);
    }
}