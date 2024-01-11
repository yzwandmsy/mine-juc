/**
 * @author yaozw
 * @since 2023/12/27 16:20
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("a" + System.currentTimeMillis());
        Thread thread = new Thread(() -> {
            System.out.println("b" + System.currentTimeMillis());
            while (!Thread.currentThread().interrupted()) {
            }
            System.out.println("c" + System.currentTimeMillis());
            System.out.println("循环结束");
//            try {
//                Thread.sleep(4000);
//                System.out.println("x" + System.currentTimeMillis());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        });

        System.out.println("d" + System.currentTimeMillis());
        thread.start();
        thread.interrupt();

        System.out.println("e" + System.currentTimeMillis());
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
// 一段时间以后
        try {
//            Thread.sleep(10);
            System.out.println("f" + System.currentTimeMillis());
        } catch (Exception e) {
            System.out.println("123");
        }
    }

}
