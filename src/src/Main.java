import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<bankAccount> accounts = new LinkedList<>();
        Stack<String> transactionHistory = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<bankAccount> accountRequests = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        bankAccount[] bankArray = new bankAccount[3];
        bankArray[0] = new bankAccount(2001, "Aruzhan", 10000);
        bankArray[1] = new bankAccount(2002, "Dias", 15000);
        bankArray[2] = new bankAccount(2003, "Madina", 20000);

        accounts.add(new bankAccount(1001, "Ali", 5000));
        accounts.add(new bankAccount(1002, "Sara", 7000));
        accounts.add(new bankAccount(1003, "Omar", 9000));

        int mainChoice;

        do {
            System.out.println("\n===== MINI BANKING SYSTEM =====");
            System.out.println("1. Enter Bank");
            System.out.println("2. Enter ATM");
            System.out.println("3. Admin Area");
            System.out.println("4. Show Array Accounts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1:
                    bankMenu(accounts, transactionHistory, billQueue, accountRequests, sc);
                    break;

                case 2:
                    atmMenu(accounts, transactionHistory, sc);
                    break;

                case 3:
                    adminMenu(accounts, transactionHistory, billQueue, accountRequests, sc);
                    break;

                case 4:
                    System.out.println("\nArray Accounts:");
                    for (int i = 0; i < bankArray.length; i++) {
                        System.out.println(bankArray[i]);
                    }
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (mainChoice != 5);

        sc.close();
    }

    public static void bankMenu(LinkedList<bankAccount> accounts, Stack<String> transactionHistory, Queue<String> billQueue, Queue<bankAccount> accountRequests, Scanner sc) {
        int choice;

        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Display all accounts");
            System.out.println("2. Search by username");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Add bill payment");
            System.out.println("6. Add account opening request");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAll Bank Accounts:");
                    for (bankAccount acc : accounts) {
                        System.out.println(acc);
                    }
                    break;

                case 2:
                    System.out.print("Enter username to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (bankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(searchName)) {
                            System.out.println("Account found:");
                            System.out.println(acc);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter username for deposit: ");
                    String depositName = sc.nextLine();
                    boolean depositFound = false;
                    for (bankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(depositName)) {
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = sc.nextDouble();

                            sc.nextLine();
                            acc.balance += depositAmount;
                            transactionHistory.push("Deposited " + depositAmount + " to " + acc.username);

                            System.out.println("Deposit successful.");
                            System.out.println("Updated account: " + acc);
                            depositFound = true;
                            break;
                        }
                    }
                    if (!depositFound) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter username for withdrawal: ");
                    String withdrawName = sc.nextLine();
                    boolean withdrawFound = false;
                    for (bankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(withdrawName)) {
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = sc.nextDouble();
                            sc.nextLine();
                            if (withdrawAmount <= acc.balance) {
                                acc.balance -= withdrawAmount;
                                transactionHistory.push("Withdrew " + withdrawAmount + " from " + acc.username);
                                System.out.println("Withdrawal successful.");
                                System.out.println("Updated account: " + acc);
                            } else {
                                System.out.println("Insufficient balance.");
                            }
                            withdrawFound = true;
                            break;
                        }
                    }
                    if (!withdrawFound) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter bill name: ");
                    String billName = sc.nextLine();
                    billQueue.offer(billName);
                    transactionHistory.push("Added bill payment: " + billName);
                    System.out.println("Bill added to queue.");
                    break;

                case 6:
                    System.out.print("Enter new account number: ");
                    int newAccountNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new username: ");
                    String newUsername = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double newBalance = sc.nextDouble();
                    sc.nextLine();

                    bankAccount newRequest = new bankAccount(newAccountNumber, newUsername, newBalance);
                    accountRequests.offer(newRequest);
                    transactionHistory.push("New account request added for " + newUsername);
                    System.out.println("Account opening request added.");
                    break;

                case 7:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }

    public static void atmMenu(LinkedList<bankAccount> accounts, Stack<String> transactionHistory, Scanner sc) {
        int choice;

        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String balanceName = sc.nextLine();
                    boolean found = false;
                    for (bankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(balanceName)) {
                            System.out.println("Current balance: " + acc.balance);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String withdrawName = sc.nextLine();
                    boolean withdrawFound = false;
                    for (bankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(withdrawName)) {
                            System.out.print("Enter withdrawal amount: ");
                            double amount = sc.nextDouble();
                            sc.nextLine();
                            if (amount <= acc.balance) {
                                acc.balance -= amount;
                                transactionHistory.push("ATM withdrawal of " + amount + " from " + acc.username);
                                System.out.println("Withdrawal successful.");
                                System.out.println("Remaining balance: " + acc.balance);
                            } else {
                                System.out.println("Insufficient balance.");
                            }
                            withdrawFound = true;
                            break;
                        }
                    }
                    if (!withdrawFound) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public static void adminMenu(LinkedList<bankAccount> accounts, Stack<String> transactionHistory, Queue<String> billQueue, Queue<bankAccount> accountRequests, Scanner sc) {

        int choice;

        do {
            System.out.println("\n--- ADMIN AREA ---");
            System.out.println("1. Process next bill");
            System.out.println("2. Display bill queue");
            System.out.println("3. Process account opening request");
            System.out.println("4. Display account requests");
            System.out.println("5. Show last transaction");
            System.out.println("6. Undo last transaction");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (!billQueue.isEmpty()) {
                        String processedBill = billQueue.poll();
                        transactionHistory.push("Processed bill payment: " + processedBill);
                        System.out.println("Processed bill: " + processedBill);
                    } else {
                        System.out.println("No bills in queue.");
                    }
                    break;

                case 2:
                    if (!billQueue.isEmpty()) {
                        System.out.println("Bills in queue:");
                        for (String bill : billQueue) {
                            System.out.println(bill);
                        }
                    } else {
                        System.out.println("Bill queue is empty.");
                    }
                    break;

                case 3:
                    if (!accountRequests.isEmpty()) {
                        bankAccount approvedAccount = accountRequests.poll();
                        accounts.add(approvedAccount);
                        transactionHistory.push("Processed account request for " + approvedAccount.username);
                        System.out.println("Account request processed.");
                        System.out.println("Added to bank accounts: " + approvedAccount);
                    } else {
                        System.out.println("No account requests in queue.");
                    }
                    break;

                case 4:
                    if (!accountRequests.isEmpty()) {
                        System.out.println("Pending account requests:");
                        for (bankAccount request : accountRequests) {
                            System.out.println(request);
                        }
                    } else {
                        System.out.println("No pending account requests.");
                    }
                    break;

                case 5:
                    if (!transactionHistory.isEmpty()) {
                        System.out.println("Last transaction: " + transactionHistory.peek());
                    } else {
                        System.out.println("No transactions found.");
                    }
                    break;

                case 6:
                    if (!transactionHistory.isEmpty()) {
                        System.out.println("Removed transaction: " + transactionHistory.pop());
                    } else {
                        System.out.println("No transactions to undo.");
                    }
                    break;

                case 7:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }
}