package common.cureent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQSTest {

    private Head head;
    private Tail tail;
    private static class Tail{

    }
    private static class Head {

    }
    private static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
    public static void main(String[] args) throws Exception {
        Unsafe unsafe =getUnsafeInstance();
        long headOffset = unsafe.objectFieldOffset
                (AQSTest.class.getDeclaredField("head"));
        long tailOffset = unsafe.objectFieldOffset
                (AQSTest.class.getDeclaredField("tail"));
        System.out.println(headOffset);
        System.out.println(tailOffset);

    }
}
