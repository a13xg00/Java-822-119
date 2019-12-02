package bankObjects;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString

public class Client {
    @NonNull @Getter private int id;
    @NonNull private String rank;
    @Getter @Setter private static String name;
    @Getter @Setter private static double balance;
    @Getter private static int[] accounts;

    public final static String[] ranks = {"regular", "gold", "platinum"};
    private final static int regularCommissionRate = 3;
    private final static int goldCommissionRate = 2;
    private final static int platinumCommissionRate =1;
    private final static double regularInterestRate = 0.1;
    private final static double goldInterestRate = 0.3;
    private final static double platinumInterestRate = 0.5;

    //returns the sum of client balance + total
    //account balance
    public double getFortune(double balance, int[] accounts){return 0.0;}

    //add account
    public static void addAccount(int id, double balance){
        Account.setId(id);
        Account.setBalance(balance);
    }

    //remove account – money is transferred to the clients
    //balance – no change in the bank total balance
    public static void removeAccount(){}

    //deposit & withdraw – adds & removes money to clients
    //balance – each action adds a commission to the bank total
    //according to the following:
    //- regular clients pays a commission rate of 3%
    //- gold clients pays a commission rate of 2%
    //- platinum clients pays a commission rate of 1%

    public static void deposit(double deposit){
        Client.setBalance(Client.getBalance() + deposit);
    }

    public static void withdraw(double withdraw){
        Client.setBalance(Client.getBalance() - withdraw);
    }

    //update accounts balance (daily auto process)
    //- regular clients gets a daily interest rate of 0.1%
    //- gold clients gets a daily interest rate of 0.3%
    //- platinum clients gets a daily interest rate of 0.5%
    public static void updateAccount(){}

}
