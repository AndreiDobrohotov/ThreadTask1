package controller;

import model.Model;
import model.Operations.TypeOfMathOperation;
import view.View;

import java.util.concurrent.ExecutionException;

public class Controller {
    private final Model model;
    private final View view;

    public Controller() {
        model = new Model();
        view = new View();
    }

    public void execute() throws ExecutionException, InterruptedException {
        while(true){
            String command = view.printMenuAndGetCommand().trim();
            switch (command){
                case "1"-> view.printCommandStatus(model.addMathOperation(view.readNumbers(), TypeOfMathOperation.SUM));
                case "2"-> view.printCommandStatus(model.addMathOperation(view.readNumbers(), TypeOfMathOperation.SUBTRACTION));
                case "3"-> view.printCommandStatus(model.addMathOperation(view.readNumbers(), TypeOfMathOperation.MULTIPLICATION));
                case "4"-> view.printCommandStatus(model.addMathOperation(view.readNumbers(), TypeOfMathOperation.FACTORIAL));
                case "5"-> {
                    model.startCalculations();
                    return;
                }
                case default -> view.wrongCommand();
            }

        }
    }
}
