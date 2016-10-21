package ua.in.gnatyuk.quick_sort;

import org.apache.log4j.Logger;

public class QuickSort {
    private static int[] theArray;
    private static Logger log = Logger.getLogger(QuickSort.class);

    private QuickSort() {
    }

    public static int[] getLargest(int[] array, int quantity){
        theArray = array;
        recQuickSort(0, theArray.length-1);
        return getMaxElements(quantity);
    }

    private static void recQuickSort(int left, int right){
        int size = right - left + 1;

        if(size<=3){
            manualSort(left, right);
        }else{
            long median = median(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private static int median(int left, int right){
        int center = (left + right) / 2;

        if(theArray[left]>theArray[center])
            swap(left, center);

        if(theArray[left]>theArray[right])
            swap(left, right);

        if(theArray[center]>theArray[right])
            swap(center, right);

        swap(center, right - 1);

        return theArray[right - 1];
    }

    private static int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left;
        int rightPtr = right - 1;
        while(true)
        {
            while(theArray[++leftPtr] < pivot);

            while(theArray[--rightPtr] > pivot);

            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right-1);
        return leftPtr;
    }

    private static void swap(int index1, int index2)
    {
        int temp;
        temp = theArray[index1];
        theArray[index1] = theArray[index2];
        theArray[index2] = temp;
    }

    private static void manualSort(int left, int right){
        int size = right - left + 1;

        if(size <= 1)
            return;

        if(size == 2){
            if (theArray[left] >theArray[right])
                swap(left, right);
            return;
        }

        else
        {
            if (theArray[left] > theArray[right - 1])
                swap(left, right - 1);

            if (theArray[left] > theArray[right])
                swap(left, right);

            if (theArray[right - 1] > theArray[right])
                swap(right - 1, right);
        }
    }

    public static int[] getMaxElements(int quantity) throws NullPointerException{
        if(isValidQuantity(quantity)){

            int[] maxElement = new int[quantity];
            int length = theArray.length-1;

            for (int i = 0; i < quantity ; i++) {
                maxElement[i] = theArray[length-i];
            }

            return maxElement;
        }
        else {
            log.info(" The value of quantity doesn't valid ");
            return null;
        }
    }

    public static boolean isValidQuantity(int quantity){
        return (quantity >= 0) && (quantity <= theArray.length);
    }
}
