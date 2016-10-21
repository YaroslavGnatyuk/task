/**
 * Created by yroslav on 10/20/16.
 */

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import ua.in.gnatyuk.merge_sort.MergeSort;
import ua.in.gnatyuk.quick_sort.QuickSort;

import java.util.Random;

public class Sorting {
    private int [] unsortedArray;
    private int [] sortedArray;

    private long start;
    private long finish;

    Logger log = Logger.getLogger(Sorting.class);

    @Before
    public void fillTheArray(){
        unsortedArray = new Random().ints(3000000, 0, 100).toArray();
    }

    @Test
    public void quickSort(){
//        Arrays.stream(unsortedArray).boxed().map(l->String.valueOf(l) + " ").forEach(log::info);

        start = System.currentTimeMillis();
        sortedArray = QuickSort.sort(unsortedArray);
        finish = System.currentTimeMillis();

//        System.out.println();
//        Arrays.stream(sortedArray).boxed().map(l->String.valueOf(l) + " ").forEach(log::info);

        log.info("\nTotal time of quick sorting is:   " + (finish-start) + " milliseconds\n");
    }

    @Test
    public void mergeSort(){
//        Arrays.stream(unsortedArray).boxed().map(l->String.valueOf(l) + " ").forEach(log::info);
//        System.out.println();

        start = System.currentTimeMillis();
        sortedArray = MergeSort.sort(unsortedArray);
        finish = System.currentTimeMillis();

//        Arrays.stream(unsortedArray).boxed().map(l->String.valueOf(l) + " ").forEach(log::info);

        log.info("\nTotal time of merge sorting is:   " + (finish-start) + " milliseconds");
    }

}
