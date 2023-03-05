package model.Operations;

import java.util.List;


public class Subtraction extends CallableWithFuture {

    private final List<Integer> numbers;

    public Subtraction(List<Integer> numbers) {
        this.numbers = numbers;
    }


    @Override
    public Long call() {
        long result = numbers.get(0);
        if(numbers.size()>1){
            for(int i=1;i<numbers.size();i++){
                result-=numbers.get(i);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[Вычитание чисел] ");
        for(int i=0;i<numbers.size();i++){
            builder.append(numbers.get(i));
            builder.append(i==numbers.size()-1?"=":"-");
        }
        return builder.toString();
    }
}
