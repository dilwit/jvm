public class OutOfMemory {

    private static final long  MEGABYTE = 1024L * 1024L;

    public void trigger() {

        getMemoryStatus();

        int dummyArraySize = 15;
        long memoryConsumed = 0;

        try {
            long[] memoryAllocated = null;
            for (int loop = 0; loop < Integer.MAX_VALUE; loop++) {

                memoryAllocated = new long[dummyArraySize];
                memoryConsumed += dummyArraySize * Long.BYTES;
                System.out.println("Memory Consumed till now: " + bytesToMB(memoryConsumed) + " MB");
                dummyArraySize *= dummyArraySize * 2;
            }
        } catch (OutOfMemoryError outofMemory) {
            System.out.println("Catching out of memory error");
            //Log the information,so that we can generate the statistics (latter on).
            throw outofMemory;
        }
    }

    private void getMemoryStatus() {

        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Max Memory: " + bytesToMB(maxMemory) + " MB");

        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("Total Memory: " + bytesToMB(totalMemory) + " MB");

        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("Free Memory: " + bytesToMB(freeMemory) + " MB");
    }

    private long bytesToMB(long bytes) {
        return bytes/MEGABYTE;
    }
}
