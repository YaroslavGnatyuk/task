package ua.in.gnatyuk.merge_sort;

/**
 * Created by yroslav on 10/21/16.
 */
public class MergeSort {
    private static int[] theArray;

    public static int[] sort(int[] array){
        theArray = array;

        int[] workSpace = new int[theArray.length];
        recMergeSort(workSpace, 0, theArray.length-1);
        return theArray;
    }

    private static void recMergeSort(int[] workSpace, int lowerBound,
                              int upperBound)
    {
        if(lowerBound == upperBound)
            return;
        else
        {
            int mid = (lowerBound+upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid+1, upperBound);
            merge(workSpace, lowerBound, mid+1, upperBound);
        }
    }

    private static void merge(int[] workSpace, int lowPtr,
                       int highPtr, int upperBound)
    {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1;

        while(lowPtr <= mid && highPtr <= upperBound)
            if( theArray[lowPtr] < theArray[highPtr] )
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];

        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];

        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];

        for(j=0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];
    }
}
