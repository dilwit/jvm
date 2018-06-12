public class Main {

    /**
     * java -XX:+PrintFlagsFinal -version (lets you find default memory allocation)
     *
     * Run this
     *  java -Xms256M -Xmx1024M Main (This will how total memory available for heap is changed)
     *  java -Xms1024M -Xmx1024M Main (This will how total memory and max memory available for heap)
     * @param args
     */
    public  static void main(String [] args) {
        OutOfMemory oom = new OutOfMemory();
        oom.trigger();
    }

}
