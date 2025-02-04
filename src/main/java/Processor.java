import model.Calculator;
import model.HistoryStorage;
import view.View;
import view.Command;

public class Processor {
    private final View view;
    private final Calculator calculator;
    private final HistoryStorage historyStorage;

    public Processor() {
        this.view = new View();
        this.calculator = new Calculator();
        this.historyStorage = new HistoryStorage();
    }

    public void start() {
        try {
            doService();
        } catch (RuntimeException e) {
            view.printErrorMessage(e.getMessage());
        }
    }

    private void doService() throws RuntimeException {
        view.printMenuMessage();
        switch (getCommand()) {
            case HISTORY_COMMAND -> viewHistory();
            case CALCULATE_COMMAND -> doCalculation();
        }
    }

    private Command getCommand() throws RuntimeException {
        Command command = view.commandReader();
        view.printNewLine();

        return command;
    }

    private void viewHistory() {
        String history = historyStorage.loadAll();
        view.printHistory(history);
        view.printNewLine();
    }

    private void doCalculation() throws RuntimeException {
        String expression = view.expressionReader();
        String result = calculator.calculate(expression);
        historyStorage.save(expression, result);
        view.printCalculationResult(result);
    }
}
