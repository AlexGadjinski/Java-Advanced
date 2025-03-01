package bankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> bank = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Create" -> {
                    BankAccount account = new BankAccount();
                    bank.put(account.getId(), account);
                    System.out.printf("Account ID%d created\n", account.getId());
                }
                case "Deposit" -> {
                    int accountNum = Integer.parseInt(commands[1]);
                    if (bank.containsKey(accountNum)) {
                        double money = Double.parseDouble(commands[2]);
                        bank.get(accountNum).deposit(money);
                        System.out.printf("Deposited %.0f to ID%d\n", money, accountNum);
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
                case "SetInterest" -> BankAccount.setInterestRate(Double.parseDouble(commands[1]));
                case "GetInterest" -> {
                    int accountNum = Integer.parseInt(commands[1]);
                    if (bank.containsKey(accountNum)) {
                        System.out.printf("%.2f\n", bank.get(accountNum).getInterest(Integer.parseInt(commands[2])));
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
            }
        }
    }
}
