

public class Main {
    public static void main(String[] args) {
        IndividualHolder individual = new IndividualHolder(123,"16630 pocono", "Siva", "123-345-678");
        CorporateHolder corp = new CorporateHolder(456, "1 Microsoft way", "9092358999");
        String upper_case = individual.convertNameUpperCase("siva");
        System.out.println("Random getNextID(): "+ individual.getNextID());
        System.out.println("Random getNextID(): "+ individual.getNextID());
        System.out.println("Upper case: " + upper_case);
        System.out.println("getName(): "+individual.getName());
        System.out.println("getSSN(): "+individual.getSSN());
        System.out.println("Setting Name..");
        individual.setName("SivaCPP");
        System.out.println("Setting SSN..");
        individual.setSSN("888-777-666");
        System.out.println("getName(): "+individual.getName());
        System.out.println("getSSN(): "+individual.getSSN());
        System.out.println("corporate getContact(): "+corp.getContact());
        System.out.println("corporate setting contact..: ");
        corp.setContact("1 Infinity loop");
        System.out.println("corporate getContact(): "+corp.getContact());

        Account account = new Account(5000.00, individual);
        System.out.println("getBalance(): "+account.getBalance());
        System.out.println("setting balance..");
        account.setBalance(10000.00);
        System.out.println("getBalance(): "+account.getBalance());
        System.out.println("Withdrawing 200");
        account.withdraw(200);
        System.out.println("getBalance(): "+account.getBalance());
        System.out.println("Depositing 700");
        account.deposit(700);
        System.out.println("getBalance(): "+account.getBalance());
        System.out.println("Setting holder...");
        account.setHolder(corp);
        System.out.println("Getting holder..."+account.getHolder().getClass().getName());
    }
}