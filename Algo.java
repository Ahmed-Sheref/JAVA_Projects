import java.util.Random;
import java.util.Scanner;

class input 
{
    static int[] Input_Program() 
    {
        @SuppressWarnings("resource")
        Scanner INPUT = new Scanner(System.in);
        System.out.print("Please Enter the Length of the array -> ");
        int siz = INPUT.nextInt();
        int Arr[] = new int[siz];
        int number;
        for (int i = 0; i < siz; i++) 
        {
            System.out.printf("number [%d] -> ", i + 1);
            number = INPUT.nextInt();
            Arr[i] = number;
        }
        return Arr;
    }

    static int[] GenerateRandomArray(int size) 
    {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) 
        {
            arr[i] = rand.nextInt(1000); // Generate random numbers between 0 and 999
        }
        return arr;
    }

    static void PrintArray(int[] arr) 
    {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.print(arr[i]);
            if (i < arr.length - 1) 
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

class Merge 
{
    static void Sort(int _Arr[], int start, int mid, int end) 
    {
        int Left_length = mid - start + 1;
        int Right_length = end - mid;
        int Left_array[] = new int[Left_length];
        int Right_array[] = new int[Right_length];
        for (int i = 0; i < Left_length; i++) 
        {
            Left_array[i] = _Arr[start + i];
        }
        for (int j = 0; j < Right_length; j++) 
        {
            Right_array[j] = _Arr[mid + j + 1];
        }
        int i = 0, j = 0, k = start;
        while (i < Left_length && j < Right_length) 
        {
            if (Left_array[i] <= Right_array[j]) 
            {
                _Arr[k] = Left_array[i];
                i++;
            } 
            else 
            {
                _Arr[k] = Right_array[j];
                j++;
            }
            k++;
        }
        while (i < Left_length) 
        {
            _Arr[k] = Left_array[i];
            i++;
            k++;
        }
        while (j < Right_length) 
        {
            _Arr[k] = Right_array[j];
            j++;
            k++;
        }
    }

    static void Merge_Sort(int _Arr[], int start, int end) 
    {
        if (end <= start) return;
        int mid = (start + end) / 2;
        Merge_Sort(_Arr, start, mid);
        Merge_Sort(_Arr, mid + 1, end);
        Sort(_Arr, start, mid, end);
    }

    void merge(int _Arr[]) 
    {
        Merge_Sort(_Arr, 0, _Arr.length - 1);
    }
    int[] Finally_merge() 
    {
        int Arr[];
        Arr = input.Input_Program();
        System.out.print("Array Before Merge Sort -> ");
        input.PrintArray(Arr);
        merge(Arr);
        System.out.println("Time of Merge Sort -> O(n (log n))");
        PerformanceAnalyzer.measureTime(() -> merge(Arr), "Merge Sort");
        System.out.print("\nArray After Merge Sort -> ");
        input.PrintArray(Arr);
        return Arr;
    }
}
class Insertion_sort 
{
    private int j;

    void InsSort(int Arr[]) 
    {
        for (int i = 0; i < Arr.length; i++) 
        {
            int number = Arr[i];
            for (j = i - 1; j >= 0; j--) 
            {
                if (number < Arr[j]) 
                {
                    Arr[j + 1] = Arr[j];
                } 
                else 
                {
                    break;
                }
            }
            Arr[j + 1] = number;
        }
    }

    int[] Finally_Insertion() 
    {
        int Arr[];
        Arr = input.Input_Program();
        System.out.print("Array Before Insertion Sort -> ");
        input.PrintArray(Arr);
        InsSort(Arr);
        System.out.println("Time of Insertion Sort -> O(n ^ 2)");
        PerformanceAnalyzer.measureTime(() -> InsSort(Arr), "Insertion Sort");
        System.out.print("\nArray After Insertion Sort -> ");
        input.PrintArray(Arr);
        return Arr;
    }
}
        
class BubbleSort 
{
    private void swap(int[] Arr, int i, int j) 
    {
        int temp = Arr[i];
        Arr[i] = Arr[j];
        Arr[j] = temp;
    }

    void BubSort(int Arr[]) 
    {
        int n = Arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (Arr[j] > Arr[j + 1]) 
                {
                    swap(Arr, j, j + 1);
                }
            }
        }
    }

    int[] Finally_BuB() 
    {
        int Arr[];
        Arr = input.Input_Program();
        System.out.print("Array Before BubbleSort Sort -> ");
        input.PrintArray(Arr);
        BubSort(Arr);
        System.out.println("Time of Bubble Sort -> O(n ^ 2)");
        PerformanceAnalyzer.measureTime(() -> BubSort(Arr), "Bubble Sort");
        System.out.print("\nArray After BubbleSort Sort -> ");
        input.PrintArray(Arr);
        return Arr;
    }
}
        
class Search 
{
    int Binary_Search(int _Arr[], int _data) 
    {
        int l = 0, r = _Arr.length - 1, mid;
        while (l <= r) 
        {
            mid = (l + r) / 2;
            if (_Arr[mid] == _data) return mid;
            else if (_Arr[mid] < _data) 
            {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    int Linear_Search(int _Arr[], int _data) 
    {
        int i = 0;
        for (int num : _Arr) 
        {
            if (num == _data) 
            {
                return i + 1;
            }
            i++;
        }
        return -1;
    }
}
        
class PerformanceAnalyzer 
{
    static void measureTime(Runnable algorithm, String algoName) 
    {
        long startTime = System.nanoTime();
        algorithm.run();
        long endTime = System.nanoTime();
        System.out.println(" Execution time of " + algoName + " → " + (endTime - startTime) / 1e6 + " ms");
    }
}
        
class MenuSystem 
{
    public static int[] sortedArray = null;

    static void displayMenu() 
    {
        @SuppressWarnings("resource")
        Scanner ss = new Scanner(System.in);
        int choice;
        do 
        {
            System.out.println("\n==========================================");
            System.out.println(" Algorithm Analysis Tool - Main Menu ");
            System.out.println("==========================================");
            System.out.println("1 Perform Merge Sort");
            System.out.println("2 Perform Insertion Sort");
            System.out.println("3 Perform Bubble Sort");
            System.out.println("4 Show Time Complexity Table");
            System.out.println("5 Generate and Sort Random Array");
            System.out.println("6 Generate all method");
            System.out.println("7 Exit");
            System.out.println("==========================================");
            System.out.print(" Choose a sorting method: ");
            choice = ss.nextInt();
            switch (choice) 
            {
                case 1:
                    Merge mSort = new Merge();
                    sortedArray = mSort.Finally_merge();
                    break;
                case 2:
                    Insertion_sort iSort = new Insertion_sort();
                    sortedArray = iSort.Finally_Insertion();
                    break;
                case 3:
                    BubbleSort BSort = new BubbleSort();
                    sortedArray = BSort.Finally_BuB();
                    break;
                case 4:
                    showTimeComplexityTable();
                    break;
                case 5:
                    System.out.print("Enter size of random array: ");
                    int randomSize = ss.nextInt();
                    sortedArray = input.GenerateRandomArray(randomSize);
                    System.out.print("Generated Array: ");
                    input.PrintArray(sortedArray);
                    System.out.println("Sorting with Merge Sort...");
                    Merge mSortRandom = new Merge();
                    mSortRandom.merge(sortedArray);
                System.out.print("Sorted Array: ");
                input.PrintArray(sortedArray);
                break;
                case 6:
                @SuppressWarnings("unused") Scanner scanner = new Scanner(System.in);
                // System.out.print("Enter size of array: ");
                int[] arr = input.Input_Program();
                System.out.println("Original Array: ");
                input.PrintArray(arr);
                long start, end;
                int[] mergeArr = arr.clone();
                start = System.nanoTime();
                Merge.Merge_Sort(mergeArr, 0, mergeArr.length - 1);
                end = System.nanoTime();
                System.out.println("Sorted using Merge Sort (Time: " + (end - start) / 1e6 + " ms): ");
                input.PrintArray(mergeArr);
                System.out.println("---------------------------------------------------");
                //TODO____________________________________________________________________________________________
                int[] insertionArr = arr.clone();
                start = System.nanoTime();
                Insertion_sort ins = new Insertion_sort();
                ins.InsSort(insertionArr);
                end = System.nanoTime();
                System.out.println("Sorted using Insertion Sort (Time: " + (end - start) / 1e6 + " ms): ");
                input.PrintArray(insertionArr);
                System.out.println("---------------------------------------------------");
                //TODO____________________________________________________________________________________________
                int[] bubbleArr = arr.clone();
                start = System.nanoTime();
                BubbleSort bub = new BubbleSort();
                bub.BubSort(bubbleArr);
                end = System.nanoTime();
                System.out.println("Sorted using Bubble Sort (Time: " + (end - start) / 1e6 + " ms): ");
                input.PrintArray(bubbleArr);
                break;
                case 7:
                    System.out.println(" Exiting the program... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println(" Invalid choice! Please enter 1, 2, 3, 4, 5 or 6.");
                    continue;
            }
            if (sortedArray != null) 
            {
                performSearch(sortedArray);
            }
        } while (true);
    }

    static void performSearch(int[] sortedArray) 
    {
        @SuppressWarnings("resource")
        Scanner ss = new Scanner(System.in);
        int searchChoice;
        do 
        {
            System.out.println("\n==========================================");
            System.out.println(" Choose a Searching Method ");
            System.out.println("==========================================");
            System.out.println("1 Binary Search");
            System.out.println("2 Linear Search");
            System.out.println("3 Show Search Time Complexity Table");
            System.out.println("4 Return to Main Menu");
            System.out.println("==========================================");
            System.out.print(" Enter your choice: ");
            searchChoice = ss.nextInt();
            switch (searchChoice) 
            {
                case 1 -> 
                {
                    Search binarySearch = new Search();
                    System.out.print("Enter number to search: ");
                    int num = ss.nextInt();
                    int index = binarySearch.Binary_Search(sortedArray, num);
                    System.out.println("Time Binary Search -> O(log n)");
                    // PerformanceAnalyzer.measureTime(() -> Binary_Search(sortedArray ,num), "Binary_Search Sort");
                    System.out.println(index == -1 ? " Element not found" : " Found at index: " + index);
                }
                case 2 -> 
                {
                    Search linearSearch = new Search();
                    System.out.print("Enter number to search: ");
                    int num = ss.nextInt();
                    int pos = linearSearch.Linear_Search(sortedArray, num);
                    System.out.println("Time Linear Search -> O(n)");
                    System.out.println(pos == -1 ? " Element not found" : " Found at index: " + pos);
                }
                case 3 -> showSearchTimeComplexityTable();
                case 4 -> 
                {
                    return;
                }
                default -> System.out.println(" Invalid choice! Please enter 1, 2, 3 or 4.");
            }
        } while (true);
    }

    static void showTimeComplexityTable() 
    {
        System.out.println("\n=================================================");
        System.out.println("  Time Complexity Table (Sorting)");
        System.out.println("=================================================");
        System.out.println(" Algorithm Time Complexity");
        System.out.println("-------------------------------------------------");
        System.out.println(" Merge Sort O(n log n)");
        System.out.println(" Insertion Sort O(n^2)");
        System.out.println(" Bubble Sort O(n^2)");
        System.out.println("=================================================");
    }

    static void showSearchTimeComplexityTable() 
    {
        System.out.println("\n=================================================");
        System.out.println("  Time Complexity Table (Searching)");
        System.out.println("=================================================");
        System.out.println(" Algorithm Time Complexity");
        System.out.println("-------------------------------------------------");
        System.out.println(" Binary Search O(log n)");
        System.out.println(" Linear Search O(n)");
        System.out.println("=================================================");
    }

    void MainMenu() 
    {
        displayMenu();
        performSearch(sortedArray);
    }
}

@SuppressWarnings("unused")
class Algo 
{
    public static void main(String[] argv) 
    {
        MenuSystem mn = new MenuSystem();
        mn.MainMenu();
    }
}