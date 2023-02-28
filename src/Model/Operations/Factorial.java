package Model.Operations;


public class Factorial extends CallableWithFuture {

    private final int number;

    public Factorial(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        return number==0 ? 1 : factorial(number);
    }

    private long factorial(int number){
        return number==1 ? number : number*factorial(number-1);
    }

    @Override
    public String toString() {
        return "[Факториал числа] !" + number + "=";
    }
}
