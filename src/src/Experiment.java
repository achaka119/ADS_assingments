import java.util.Arrays;

public class Experiment {
    private Sorter sorter;
    private Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        long startTime = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(arr);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(arr);
        } else {
            System.out.println("Invalid sorting type. Use 'basic' or 'advanced'.");
        }
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        int result = searcher.search(arr, target);
        long endTime = System.nanoTime();
        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found.");
        }

        return endTime - startTime;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        System.out.println("====================================");
        System.out.println("Sorting and Searching Experiments");
        System.out.println("Algorithms:");
        System.out.println("Basic Sort: Insertion Sort");
        System.out.println("Advanced Sort: Heap Sort");
        System.out.println("Search: Binary Search");
        System.out.println("====================================");

        for (int size : sizes) {
            System.out.println("\nArray Size: " + size);
            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = Arrays.copyOf(randomArray, randomArray.length);
            Arrays.sort(sortedArray);

            runExperimentForArray("Random Array", randomArray);
            runExperimentForArray("Sorted Array", sortedArray);
        }
    }

    private void runExperimentForArray(String arrayType, int[] originalArray) {
        System.out.println("\nInput Type: " + arrayType);

        int[] arrayForInsertionSort = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrayForHeapSort = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrayForBinarySearch = Arrays.copyOf(originalArray, originalArray.length);

        long insertionSortTime = measureSortTime(arrayForInsertionSort, "basic");
        long heapSortTime = measureSortTime(arrayForHeapSort, "advanced");
        Arrays.sort(arrayForBinarySearch);
        int target = arrayForBinarySearch[arrayForBinarySearch.length / 2];
        long binarySearchTime = measureSearchTime(arrayForBinarySearch, target);

        System.out.println("Insertion Sort Time: " + insertionSortTime + " ns");
        System.out.println("Heap Sort Time: " + heapSortTime + " ns");
        System.out.println("Binary Search Time: " + binarySearchTime + " ns");
    }
}