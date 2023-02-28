package Model.Operations;

import java.util.List;

public class Multiplication extends CallableWithFuture {

    private final List<Integer> numbers;

    public Multiplication(List<Integer> numbers) {
        this.numbers = numbers;
    }


    @Override
    public Long call() throws Exception {
        long result = 1;
        for(Integer number : numbers){
            result*=number;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[Умножение чисел] ");
        for(int i=0;i<numbers.size();i++){
            builder.append(numbers.get(i));
            builder.append(i==numbers.size()-1?"=":"*");
        }
        return builder.toString();
    }
}