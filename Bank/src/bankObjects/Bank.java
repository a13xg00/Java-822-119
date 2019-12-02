package bankObjects;

public class Bank {
    //functionality:
    //o get balance - this operation must calculate the balance
    //each time the operation is called. The balance is calculated
    //by summing the total client balance and the total accounts
    //balance
    //o add / remove client (effects bank total balance & should be
    //logged)
    //o get client list
    //o view logs – allows to view activities
    //o start account updater process

    public static double getBalance(){
        return Client.getBalance();
    }

    public static void addClient(String name, double balance){
        Client.setName(name);
        Client.setBalance(balance);
    }

    public static void removeClient(){}

    public static void listClients(){}

    public static void viewLogs(){}

    public static void startUpdater(){}

}
