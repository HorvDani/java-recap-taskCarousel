public class CompleteByRequestTask implements Task {


    private boolean isCompleted = false;
    private boolean isFinished = false;
    @Override
    public void execute() {
        if(isCompleted){
            isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void complete() {
       isCompleted = true;

    }
}
