package model;

import model.Operations.*;

import java.util.*;
import java.util.concurrent.*;

public class Model {//name is not accurate ??
    //коллекция для всех мат. операций
    private final Set<CallableWithFuture> futureSet = new HashSet<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    //метод модели для добавление мат. операций в коллекцию
    public boolean addMathOperation(String numbers, TypeOfMathOperation operation){
        List<Integer> intNumbers = stringLineToIntegerList(numbers);
        if(intNumbers.size()<2 && operation!= TypeOfMathOperation.FACTORIAL) return false;
        switch (operation){
            case SUM -> futureSet.add(new Sum(intNumbers));
            case MULTIPLICATION -> futureSet.add(new Multiplication(intNumbers));
            case SUBTRACTION ->  futureSet.add(new Subtraction(intNumbers));
            case FACTORIAL -> {
                boolean isAdded = false;
                for(Integer number : intNumbers){
                    if(number>=0){
                        futureSet.add(new Factorial(number));
                        isAdded = true;
                    }
                }
                return isAdded;
            }
        }
        return true;
    }

    //запуск вычислений - старт всех потоков
    public void startCalculations() throws ExecutionException, InterruptedException {
        for(CallableWithFuture callable : futureSet){
            callable.setFuture(executorService.submit(callable));
        }
        executorService.shutdown();
        if(!executorService.awaitTermination(60, TimeUnit.SECONDS)){
            executorService.shutdownNow();
        }
        for(CallableWithFuture callable : futureSet){
            System.out.println(callable.toString() + callable.getFuture().get());
        }
    }

    //переводит строку в числа, все некорректные вводы игнорирует
    private List<Integer> stringLineToIntegerList(String numbers){
        List<Integer> result = new ArrayList<>();
        for(String number : numbers.split(" ")){
            try{
                result.add(Integer.parseInt(number));
            }
            catch (NumberFormatException ignore){}
        }
        return result;
    }

}
