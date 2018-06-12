import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemory {

    private static final long  MEGABYTE = 1024L * 1024L;
    private static List<Object> list = new ArrayList<>();

    public void trigger() {

        List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println("Running with: " + inputArguments);

        while(true) {
            getMemoryStatus();
            list.add(new int[1_000_000]);
        }
    }

    private void getMemoryStatus() {

        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Max Memory: " + bytesToMB(maxMemory) + " MB");

        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("Total Memory: " + bytesToMB(totalMemory) + " MB");

        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("Free Memory: " + bytesToMB(freeMemory) + " MB");

        System.out.println("=============================================");
    }

    private long bytesToMB(long bytes) {
        return bytes/MEGABYTE;
    }
}
