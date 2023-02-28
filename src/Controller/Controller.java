package Controller;

import Model.Model;
import View.View;

import java.util.concurrent.ExecutionException;

public class Controller {
    private static final Model model = new Model();
    private static final View view = new View();

    public void execute() throws ExecutionException, InterruptedException {
        while(true){
            String command = view.printMenuAndGetCommand().trim();
            switch (command){
                case "1"-> view.printCommandStatus(model.addMathOperation(view.readNumbers(), Model.MathOperations.SUM));
                case "2"-> view.printCommandStatus(model.addMathOperation(view.readNumbers(), Model.MathOperations.SUBTRACTION));
                case "3"-> view.printCommandStatus(model.addMathOperation(view.readNumbers(), Model.MathOperations.MULTIPLICATION));
                case "4"-> view.printCommandStatus(model.addMathOperation(view.readNumbers(), Model.MathOperations.FACTORIAL));
                case "5"-> {
                    model.startCalculations();
                    return;
                }
                case default -> view.wrongCommand();
            }

        }
    }
}
