package bank;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Bank {
    private int position;
    private int numberAccount;
    private String nameAccount;
    private double money = 50;
    static Scanner scanner = new Scanner(System.in);
    static Bank banks[];
    static int quantity;

    public Bank() {
    }

    public Bank(int numberAccount, String nameAccount, int money) {
        this.numberAccount = numberAccount;
        this.nameAccount = nameAccount;
        this.money = money;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    void input(Bank o) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        while (true) {
            System.out.print("numberAccount: ");
            String txt = scanner.nextLine();
            if (pattern.matcher(txt).find()) {
                int number = Integer.parseInt(txt);
                o.setNumberAccount(number);
                break;
            } else {
                System.out.println("-------------------------------------------------");
                System.out.println("NumberAccount must be numeric characters!");
                System.out.println("-------------------------------------------------");
            }
        }
        System.out.print("nameAccount: ");
        o.setNameAccount(scanner.nextLine());
    }

    void output() {
        System.out.println(getPosition() + "\t\t\t" +
                numberAccount + "\t\t\t\t" +
                nameAccount + "\t\t\t\t$" +
                money);
    }

    static void showInput() {
        System.out.print("Enter amount of customer: ");
        quantity = scanner.nextInt();
        banks = new Bank[quantity];
        for (int i = 0; i < banks.length; i++) {
            System.out.println("-------------------------------------------------\nCustomer " + (i + 1));
            banks[i] = new Bank();
            banks[i].input(banks[i]);
        }
        for (int i = 0; i < banks.length; i++) {
            banks[i].setPosition(i);
        }
    }

    static void sortByAlpha() {
        if (banks != null) {
            Bank temp;
            for (int i = 0; i < banks.length; i++) {
                for (int j = i + 1; j < banks.length; j++) {
                    if (banks[i].getNameAccount().compareTo(banks[j].getNameAccount()) > 0) {
                        temp = banks[i];
                        banks[i] = banks[j];
                        banks[j] = temp;
                    }
                }
            }
            System.out.println("Sort By Alpha Successfully!");
            for (int i = 0; i < banks.length; i++) {
                banks[i].setPosition(i);
            }
        } else {
            System.out.println("Empty list!");
        }
    }

    static void addMoney() {
        if (banks != null) {
            boolean check = true;
            Pattern pattern = Pattern.compile("^[0-9]+$");
            int findNum;
            while (true) {
                System.out.println("Enter the NumberAccount you wanna add money: ");
                String txt = scanner.nextLine();
                if (pattern.matcher(txt).find()) {
                    int number = Integer.parseInt(txt);
                    findNum = number;
                    break;
                }
            }
            for (int i = 0; i < banks.length; i++) {
                if (findNum == banks[i].getNumberAccount()) {
                    System.out.print("Enter amount of money you wanna add: ");
                    double amount = scanner.nextDouble();
                    banks[i].setMoney(amount + banks[i].getMoney());
                    check = false;
                    System.out.println("-------------------------------------------------");
                    System.out.print("Position\t");
                    System.out.print("NumberAccount\t");
                    System.out.print("NameAccount\t\t");
                    System.out.println("Money");
                    banks[i].output();
                }
            }
            if (check)
                System.out.println("-------------------------------------------------\nThe NumberAccount you need is not found!");
            for (int i = 0; i < banks.length; i++) {
                banks[i].setPosition(i);
            }
        } else {
            System.out.println("Empty list!");
        }
    }

    static void withdrawMoney() {
        if (banks != null) {
            boolean check = true;
            System.out.print("-------------------------------------------------\nEnter the NumberAccount you wanna withdraw money: ");
            int findNum = scanner.nextInt();
            for (int i = 0; i < banks.length; i++) {
                if (findNum == banks[i].getNumberAccount()) {
                    System.out.print("Enter amount of money you wanna withdraw: ");
                    double amount = scanner.nextDouble();
                    if (amount <= banks[i].getMoney())
                        banks[i].setMoney(banks[i].getMoney() - amount);
                    else
                        System.out.println("-------------------------------------------------\nAmount of money in the account is not enough!");
                    check = false;
                    System.out.println("-------------------------------------------------");
                    System.out.print("Position\t");
                    System.out.print("NumberAccount\t");
                    System.out.print("NameAccount\t\t");
                    System.out.println("Money");
                    banks[i].output();
                }
            }
            if (check)
                System.out.println("-------------------------------------------------\nThe NumberAccount you need is not found!");
            for (int i = 0; i < banks.length; i++) {
                banks[i].setPosition(i);
            }
        } else {
            System.out.println("Empty list!");
        }
    }

    static void findByName() {
        if (banks != null) {
            System.out.println("-------------------------------------------------");
            System.out.print("Enter someone's name you wanna find: ");
            String find = scanner.nextLine();
            boolean check = true;
            for (int i = 0; i < banks.length; i++) {
                if (banks[i].getNameAccount().equals(find)) {
                    System.out.println("-------------------------------------------------");
                    banks[i].output();
                    check = false;
                }
            }
            if (check)
                System.out.println("-------------------------------------------------\nThe one you need is not found!");
            for (int i = 0; i < banks.length; i++) {
                banks[i].setPosition(i);
            }
        } else {
            System.out.println("Empty list!");
        }
    }

    static boolean include(Bank arr[], int value) {
        byte check = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getNumberAccount() == value) {
                check = 1;
            }
        }
        if (check == 1) {
            return true;
        } else {
            return false;
        }
    }

    static void passMoney() {
        if (banks != null) {
            if (banks.length > 1) {
                System.out.println("-------------------------------------------------\nEnter the taken NumberAccount: ");
                int numTaken = scanner.nextInt();
                if (include(banks, numTaken) == true) {
                    System.out.println("Enter the got NumberAccount: ");
                    int numGot = scanner.nextInt();
                    int taken = 0, got = 0;
                    boolean checkTaken = true;
                    boolean checkGot = true;
                    for (int i = 0; i < banks.length; i++) {
                        if (banks[i].getNumberAccount() == numTaken) {
                            checkTaken = false;
                            taken = i;
                        }
                        if (banks[i].getNumberAccount() == numGot) {
                            checkGot = false;
                            got = i;
                        }
                    }
                    if (!(checkGot && checkTaken)) {
                        System.out.print("Enter amount of money you wanna pass: ");
                        int amount = scanner.nextInt();
                        if (amount <= banks[taken].getMoney()) {
                            banks[taken].setMoney(banks[taken].getMoney() - amount);
                            banks[got].setMoney(banks[got].getMoney() + amount);
                        } else {
                            System.out.println("-------------------------------------------------\nThe taken account doesn't have enough money!");
                        }
                    } else {
                        System.out.println("-------------------------------------------------\nThis account is not found!: ");
                    }
                } else {
                    System.out.println("-------------------------------------------------\nThis account is not found!: ");
                }
            } else {
                System.out.println("-------------------------------------------------\nQuantity of account isn't enough!");
            }
            for (int i = 0; i < banks.length; i++) {
                banks[i].setPosition(i);
            }
        } else {
            System.out.println("Empty list!");
        }
    }

    static void showOutput() {
        if (banks == null) {
            System.out.println("Empty list!");
        } else if (banks.length == 0) {
            System.out.println("Empty list!");
        } else {
            System.out.println("-------------------------------------------------");
            System.out.print("Position\t");
            System.out.print("NumberAccount\t");
            System.out.print("NameAccount\t\t");
            System.out.print("Money\n");
            for (int i = 0; i < banks.length; i++) {
                banks[i].output();
            }
            for (int i = 0; i < banks.length; i++) {
                banks[i].setPosition(i);
            }
        }
    }

    static void deleteAccount() {
        if (banks == null) {
            System.out.println("Empty list!");
        } else {
            System.out.print("-------------------------------------------------\nEnter NumberAccount of Account you wanna delete: ");
            int del = scanner.nextInt();
            int temp = -1;
            if (banks.length > 1) {
                if (include(banks, del) == false) {
                    System.out.println("-------------------------------------------------\nThis account is not found!: ");
                } else {
                    Bank[] bank = new Bank[banks.length - 1];
                    for (int i = 0; i < banks.length; i++) {
                        if (del == banks[i].getNumberAccount())
                            temp = i;
                    }
                    for (int i = 0; i < temp; i++) {
                        bank[i] = banks[i];
                    }
                    for (int i = temp; i < bank.length; i++) {
                        bank[i] = banks[i + 1];
                    }
                    banks = new Bank[bank.length - 1];
                    banks = bank;
                }
            } else {
                if (include(banks, del) == true) {
                    banks = null;
                } else {
                    System.out.println("-------------------------------------------------\nThis account is not found!: ");
                }
            }
            for (int i = 0; i < banks.length; i++) {
                banks[i].setPosition(i);
            }
        }
    }

    static void addAccount() {
        if (banks == null) {
            banks = new Bank[1];
            banks[0] = new Bank();
            banks[0].input(banks[0]);
        } else {
            System.out.println("-------------------------------------------------\nEnter info of Account you wanna add: ");
            Bank[] newBank = new Bank[banks.length + 1];
            for (int i = 0; i < banks.length; i++) {
                newBank[i] = new Bank();    /* very important*/
                newBank[i] = banks[i];
            }
            newBank[newBank.length - 1] = new Bank();    /* very important*/
            newBank[newBank.length - 1].input(newBank[newBank.length - 1]);
            banks = new Bank[newBank.length];
            banks = newBank;
            for (int i = 0; i < banks.length; i++) {
                banks[i].setPosition(i);
            }
        }
    }

    static void editInfo() {
        if (banks == null) {
            System.out.println("Empty list!");
        } else {
            System.out.print("-------------------------------------------------\nEnter Account Number you wanna edit: ");
            int e = scanner.nextInt();
            for (int i = 0; i < banks.length; i++) {
                if (e == banks[i].getNumberAccount()) {
                    System.out.println("-------------------------------------------------");
                    System.out.print("Position\t");
                    System.out.print("NumberAccount\t");
                    System.out.print("NameAccount\t\t");
                    System.out.print("Money\n");
                    banks[i].output();
                    System.out.print("Edit name: " + scanner.nextLine());
                    banks[i].setNameAccount(scanner.nextLine());
                    break;
                } else {
                    System.out.println("-------------------------------------------------\nThis account is not found!: ");
                    break;
                }
            }
            for (int i = 0; i < banks.length; i++) {
                banks[i].setPosition(i);
            }
        }
    }

    static void insertAccount() {
        if (banks == null) {
            System.out.println("Empty list!");
        } else {
            System.out.print("-------------------------------------------------\nEnter position you wanna insert account: ");
            int ins = scanner.nextInt();
            if (ins > banks.length || ins < 0) {
                System.out.println("There is no this position in list!");
            } else {
                Bank[] newBank = new Bank[banks.length + 1];

                newBank[ins] = new Bank();    /* very important*/
                newBank[ins].input(newBank[ins]);

                for (int i = 0; i < ins; i++) {
                    newBank[i] = new Bank();    /* very important*/
                    newBank[i] = banks[i];
                }
                for (int i = ins + 1; i < banks.length + 1; i++) {
                    newBank[i] = new Bank();    /* very important*/
                    newBank[i] = banks[i - 1];
                }
                banks = new Bank[banks.length + 1];
                banks = newBank;
                for (int i = 0; i < banks.length; i++) {
                    banks[i].setPosition(i);
                }
            }
        }
    }
}

