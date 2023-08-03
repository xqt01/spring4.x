package com.smart.basic;

public class SequenceNumber {

    /**
     * 通过匿名内部类覆盖ThreadLocal的initialValue()方法, 指定初始值
     */
    private static final ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        @Override
		public Integer initialValue() {
            return 0;
        }
    };

    /**
     * 3个线程共享sn, 各自产生序列号
     */
    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {

        private final SequenceNumber sn;

        public TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        /**
         * 每个线程打出3个序列值
         */
        @Override
		public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "] sn[" + sn.getNextNum() + "]");
            }
        }
    }

    /**
     * 获取下一个序列值
     */
    private int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }
}
