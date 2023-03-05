package model.Operations;

import java.util.List;

public class Sum extends CallableWithFuture {

    private final List<Integer> numbers;

    public Sum(List<Integer> numbers) {
        this.numbers = numbers;
    }


    @Override
    public Long call() {
        long result = 0;
        for(Integer number : numbers){
            result+=number;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[Сложение чисел] ");
        for(int i=0;i<numbers.size();i++){
            builder.append(numbers.get(i));
            builder.append(i==numbers.size()-1?"=":"+");
        }
        return builder.toString();
    }
}
