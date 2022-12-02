public class Prime {
    public Boolean isPrime(int number){
        // Check if number is <= 1
        if (number <= 1) return false;

        // Check for factors
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
