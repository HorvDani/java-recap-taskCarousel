public class CountDownTask implements Task{

    private int value;
    public CountDownTask(int value) {
        if(value < 0){
            value = 0;
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute() {
        if(!isFinished()){
            this.value -= 1;
        }


    }

    @Override
    public boolean isFinished() {
        return this.value == 0;
    }
}
