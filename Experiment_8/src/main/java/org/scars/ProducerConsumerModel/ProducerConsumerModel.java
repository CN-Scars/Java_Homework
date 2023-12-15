    package org.scars.ProducerConsumerModel;

    import java.util.LinkedList;
    import java.util.Queue;

    public class ProducerConsumerModel {
        private final int CAPACITY = 10;
        private final Queue<Integer> queue = new LinkedList<>();

        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    // 等待直到队列有空间
                    while (queue.size() == CAPACITY) {
                        wait();
                    }
                    queue.add(value);
                    System.out.println("Produced " + value);
                    value++;
                    // 通知消费者线程可以开始消费了
                    notify();
                    // 生产速度控制
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // 等待直到有消息可以读取
                    while (queue.isEmpty()) {
                        wait();
                    }
                    int value = queue.poll();
                    System.out.println("Consumed " + value);
                    // 通知生产者线程可以生产了
                    notify();
                    // 消费速度控制
                    Thread.sleep(1000);
                }
            }
        }

        public static void main(String[] args) {
            ProducerConsumerModel model = new ProducerConsumerModel();

            // 创建生产者线程
            Thread producer = new Thread(() -> {
                try {
                    model.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            // 创建消费者线程
            Thread consumer = new Thread(() -> {
                try {
                    model.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            // 启动线程
            producer.start();
            consumer.start();
        }
    }
