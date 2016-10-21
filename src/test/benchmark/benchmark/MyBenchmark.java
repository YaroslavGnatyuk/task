package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ua.in.gnatyuk.merge_sort.MergeSort;
import ua.in.gnatyuk.quick_sort.QuickSort;

import java.util.Random;

/**
 * Created by yroslav on 10/21/16.
 */

@State(Scope.Thread)
public class MyBenchmark {
    private int[] unsortedArray;

    @Setup
    public void init(){
        unsortedArray = new Random().ints(3000000, 0, 100).toArray();
    }

    @Benchmark
    public void quickSort(){
        QuickSort.sort(unsortedArray);
    }

    @Benchmark
    public void mergeSort(){
        MergeSort.sort(unsortedArray);
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(MyBenchmark.class.getSimpleName()).threads(1)
                .forks(1)
                .shouldFailOnError(true)
                .warmupIterations(3)
                .shouldDoGC(true)
                .jvmArgs("-server")
                .build();
        new Runner(options).run();
    }
}
