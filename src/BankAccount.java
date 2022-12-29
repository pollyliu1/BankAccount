public class BankAccount {
    private String name;
    private String accNum;
    private double balance;
    private double interest;

    // Constructor
    /**
     * Constructs an instance of the object BankAccount.
     *
     * @param name The account holder's name
     * @param accNum The account number
     * @param balance The balance in the account
     * @param interest The interest rate of the account
     */
    public BankAccount(String name, String accNum, double balance, double interest) {
        this.name = name;
        this.accNum = accNum;
        this.balance = balance;
        this.interest = interest;
    }

    // Accessors and Mutators
    /**
     * Returns the account holder's name.
     *
     * @return The account holder's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the account number.
     *
     * @return The account number.
     */
    public String getAccNum() {
        return accNum;
    }

    /**
     * Returns the account balance.
     *
     * @return The account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the account's interest rate.
     *
     * @return The account's interest rate
     */
    public double getInterest() {
        return interest;
    }

    /**
     * Sets the account holder name to new name, name.
     *
     * @param name The account holder's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the account number to new account number, accNum.
     *
     * @param accNum The account number
     */
    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    /**
     * Sets the account's interest rate to new interest, interest.
     *
     * @param interest The account's interest rate
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    // Instance methods (Non-static)
    /**
     * Compares two bank accounts by their names and account numbers. Returns true if
     * equal and false if not.
     *
     * @param other The bank account to be compared to
     * @return Whether the bank accounts are equal or not
     */
    public boolean equals(BankAccount other) {
        if (this.name.equals(other.name) && this.accNum.equals(other.accNum)) {
            return true;
        }
        return false;
    }

    /**
     * Deposits "amount" amount of money into the called account.
     *
     * @param amount The amount of money to be deposited
     * @return None
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraws "amount" amount of money from the called account.
     *
     * @param amount The amount of money to be withdrawn
     * @return None
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Transfers "amount" amount of money from one account to the other.
     *
     * @param amount The amount of money to be transferred
     * @param other The bank account that receives the transferred money
     * @return None
     */
    public void transfer(double amount, BankAccount other) {
        this.balance -= amount;
        other.balance += amount;
    }

    /**
     * Returns the account's balance plus the simple interest earned.
     *
     * @param months The number of months that the interest is earned on
     * @return The account's balance plus earned simple interest
     */
    public double simpInterest(int months) {
        // Formula for simple interest: A = P(1 + rt)
        // A = accrued amount (principal + interest) -> directly returned
        // P = principal -> balance
        // r = interest rate in decimal (annually) -> interest
        // t = time period in years -> months
        double newBalance = balance * (1 + (interest/100) * ((double)months/12));
        balance = newBalance;
        return newBalance;
    }

    /**
     * Returns the account's balance plus the compound interest earned.
     *
     * @param months The number of months that the interest is earned on
     * @param periods The number of compounding periods per year
     * @return The account's balance plus earned compound interest
     */
    public double compInterest(int months, int periods) {
        // Formula for compound interest: A = P(1 + r/n)^nt
        // A = accrued amount (principal + interest) -> directly returned
        // P = principal -> balance
        // r = interest rate in decimal (annually) -> interest
        // t = time period in years -> months
        // n = number of compounding periods per year -> periods
        double newBalance = balance * Math.pow(1 + (interest/100 /periods), (double) periods * months / 12);
        balance = newBalance;
        return newBalance;
    }

    // Class Method
    /**
     * Transfers "amount" amount of money from transferor to transferee.
     *
     * @param amount The amount of money to be transferred
     * @param transferor The account transferring money
     * @param transferee The account receiving the transferred money
     */
    public static void transfer(double amount, BankAccount transferor, BankAccount transferee) {
        transferor.withdraw(amount);
        transferee.deposit(amount);
    }

    // Print formatting
    /**
     * Override for toString method.
     *
     * @return String of the bank account information formatted nicely
     */
    @Override
    public String toString() {
        String toPrint = "\nBank account information:"
                + "\n Account holder: " + name
                + "\n Account number: " + accNum
                // String.format allows rounding to two decimals while concatenating.
                + String.format("\n Balance: $%.2f", balance)
                + String.format("\n Interest: %.2f%%", interest);
        return toPrint;
    }
}