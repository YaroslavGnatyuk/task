import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import ua.in.gnatyuk.merge_sort.MergeSort;
import ua.in.gnatyuk.quick_sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    private int [] unsortedArray;
    private int [] sortedArray;

    private long start;
    private long finish;

    private static Logger log = Logger.getLogger(Sorting.class);

    @Before
    public void fillTheArray(){
        unsortedArray = new Random().ints(300, 0, 100).toArray();
    }

    @Test
    public void quickSort(){
//        Arrays.stream(unsortedArray).boxed().map(l->String.valueOf(l) + " ").forEach(log::info);
//        System.out.println();

        start = System.currentTimeMillis();
        sortedArray = QuickSort.getLargest(unsortedArray,10);
        finish = System.currentTimeMillis();

        Arrays.stream(sortedArray).boxed().map(l->String.valueOf(l) + " ").forEach(log::info);

        log.info("\nTotal time of quick sorting is:   " + (finish-start) + " milliseconds\n");
    }

    @Test
    public void mergeSort(){
//        Arrays.stream(unsortedArray).boxed().map(l->String.valueOf(l) + " ").forEach(log::info);
//        System.out.println();

        start = System.currentTimeMillis();
        sortedArray = MergeSort.getLargest(unsortedArray, 7);
        finish = System.currentTimeMillis();

        Arrays.stream(sortedArray).boxed().map(l->String.valueOf(l) + " ").forEach(log::info);

        log.info("\nTotal time of merge sorting is:   " + (finish-start) + " milliseconds");
    }

}
