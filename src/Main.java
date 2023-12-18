public class Main {
    public static void main(String[] args) {
        TaskCarousel carousel = new TaskCarousel(4);

        System.out.println(carousel.isEmpty()); //true
        System.out.println(carousel.isFull()); //false
        System.out.println(carousel.execute()); //false

        CountDownTask task = new CountDownTask(2);
        System.out.println(carousel.addTask(task)); //true

        System.out.println(carousel.isEmpty()); //false
        System.out.println(carousel.isFull()); // false

        System.out.println(task.getValue()); //2
        System.out.println(carousel.execute()); //true
        System.out.println(task.getValue()); //1
        System.out.println(carousel.execute()); //true
        System.out.println(task.getValue()); //0

        System.out.println(carousel.execute()); //false
        System.out.println(carousel.isEmpty()); //true



        TaskCarousel carousel2  = new TaskCarousel(3);

        CountDownTask task1 = new CountDownTask(2);
        CountDownTask task2 = new CountDownTask(2);
        CompleteByRequestTask task3 = new CompleteByRequestTask();

        System.out.println(carousel2.addTask(task1)); //true
        System.out.println(carousel2.addTask(task2)); //true
        System.out.println(carousel2.addTask(task3)); //true

        System.out.println(carousel2.isFull()); // true

        for(int i = 0; i < 100; i++){
            System.out.println(carousel2.execute()); // true
        }

        System.out.println(task1.isFinished()); // true
        System.out.println(task2.isFinished()); // true
        System.out.println(task3.isFinished()); // false

        task3.complete();

        System.out.println(task3.isFinished()); // false
        System.out.println(carousel2.execute()); // true
        System.out.println(task3.isFinished()); // true

        System.out.println(carousel2.isEmpty()); // true
    }
}