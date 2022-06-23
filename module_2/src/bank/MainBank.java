package bank;

import java.util.Scanner;

public class MainBank {

    public static void main(String[] args) {
        boolean exit = true;
        do {
            System.out.println("-------------------------------------------------");
            System.out.print("1: ShowInput");
            System.out.print("\t2: SortByAlpha");
            System.out.print("\t\t3: FindByName");
            System.out.print("\t\t0: EditAccount\n");
            System.out.print("4: AddMoney");
            System.out.print("\t\t5: WithdrawMoney");
            System.out.print("\t6: PassMoney");
            System.out.print("\t\t-: InsertAccount\n");
            System.out.print("7: DeleteAcc");
            System.out.print("\t8: AddAccount");
            System.out.print("\t\t9: showOutput");
            System.out.print("\t\tOut of list to exit!");
            System.out.print("\n-------------------------------------------------\nEnter your choice: ");
            Scanner sc = new Scanner(System.in);
            char choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                    Bank.showInput();
                    break;
                case '2':
                    Bank.sortByAlpha();
                    break;
                case '3':
                    Bank.findByName();
                    break;
                case '4':
                    Bank.addMoney();
                    break;
                case '5':
                    Bank.withdrawMoney();
                    break;
                case '6':
                    Bank.passMoney();
                    break;
                case '7':
                    Bank.deleteAccount();
                    break;
                case '8':
                    Bank.addAccount();
                    break;
                case '9':
                    Bank.showOutput();
                    break;
                case '0':
                    Bank.editInfo();
                    break;
                case '-':
                    Bank.insertAccount();
                    break;
                default:
                    exit = false;
            }
        } while (exit);
    }
}