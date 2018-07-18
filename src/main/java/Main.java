public class Main {

    /**
     * java -XX:+PrintFlagsFinal -version (lets you find default memory allocation)
     *
     * Run this
     *  java -Xms256M -Xmx1024M Main (total memory available for heap is changed)
     *  java -Xms1024M -Xmx1024M Main (total memory and max memory available for heap)
     *
     *  get heapdump -> -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Data\products\java
     * @param args
     */
    public  static void main(String [] args) {
        Service service = new Service();
        service.executeBusinessLogic();
    }
}
