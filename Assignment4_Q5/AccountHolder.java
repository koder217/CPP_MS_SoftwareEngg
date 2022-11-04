import java.util.Random;
public class AccountHolder{
    protected int ID;
    protected String address;

    public AccountHolder(int ID, String address){
        this.ID = ID;
        this.address = address;
    }

    public int getNextID(){
        Random random = new Random();
        // Generates random integers 0 to 1000000
        int x = random.nextInt(1000000);
        return x;
    }
}