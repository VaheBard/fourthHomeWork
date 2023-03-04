import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int income = 0;
        int outcome = 0;

        while (true){
            System.out.println("""
                    Choose the operation :
                    1. Enter new income
                    2. Enter new outcome
                    3. Choose tax system""");
            String entered = sc.nextLine();

            if(entered.equals("end")){
                System.out.println("The program is finished");
                break;
            }

            int intEntered = Integer.parseInt(entered);
            switch (intEntered){
                case 1:
                    System.out.println("Enter income!");
                    String incomeSt = sc.nextLine();
                    int inputIncome = Integer.parseInt(incomeSt);
                    income += inputIncome;
                    break;
                case 2:
                    System.out.println("Enter outcome!");
                    String outcomeSt = sc.nextLine();
                    int inputOutcome = Integer.parseInt(outcomeSt);
                    outcome += inputOutcome;
                    break;
                case 3:
                   int incomeTax = calcSurplusTax(income);
                   int incomeMinusOutcomeTax = calcSurplusMinusSpendingTax(income,outcome);
                    System.out.println("We recommended you " + ((incomeTax > incomeMinusOutcomeTax) ? "incomeMinusOutcomeTax" : "incomeTax"));
                    System.out.println("Your tax will be " + ((incomeTax > incomeMinusOutcomeTax) ? incomeMinusOutcomeTax : incomeTax) +
                            "\nThe tax by other system will be " + ((incomeTax < incomeMinusOutcomeTax) ? incomeMinusOutcomeTax : incomeTax) +
                            "\nYou can save " + Math.abs(incomeTax - incomeMinusOutcomeTax));
                    break;

            }

        }

    }
    public static int calcSurplusTax(int income){
        return (income * 6) / 100;
    }
    public static int calcSurplusMinusSpendingTax(int income, int outcome){
        return (income - outcome) * 15 / 100;
    }
}
