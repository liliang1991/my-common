package common.cureent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQSDemo {
    static class Sync extends AbstractQueuedSynchronizer{
        int s = getState();

        /** State value representing that TRUE */
        private static final int  TRUE             = 1;
        /** State value representing that FALSE */
        private static final int  FALSE            = 2;

        private boolean isTrue(int state) {
            return (state & TRUE) != 0;
        }

        /**
         * 实现AQS的接口，获取共享锁的判断
         */
        protected int tryAcquireShared(int state) {
            // 如果为true，直接允许获取锁对象
            // 如果为false，进入阻塞队列，等待被唤醒
            return isTrue(getState()) ? 1 : -1;
        }

        /**
         * 实现AQS的接口，释放共享锁的判断
         */
        protected boolean tryReleaseShared(int ignore) {
            // 始终返回true，代表可以release
            return true;
        }
        void innerSetTrue() {
            for (;;) {
                int s = getState();
                if (s == TRUE) {
                    return; // 直接退出
                }
                if (compareAndSetState(s, TRUE)) {// cas更新状态，避免并发更新true操作
                    releaseShared(0);// 释放一下锁对象，唤醒一下阻塞的Thread
                    return;
                }
            }
        }

        void innerSetFalse() {
            for (;;) {
                int s = getState();
                if (s == FALSE) {
                    return; // 直接退出
                }
                if (compareAndSetState(s, FALSE)) {// cas更新状态，避免并发更新false操作
                    return;
                }
            }
        }
    }
}
