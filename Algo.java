import java.util.Scanner;

class input
{
    static int[] Input_Program ()
    {
        @SuppressWarnings("resource")
        Scanner INPUT = new Scanner(System.in);
        System.out.print("Please Enter the Length of the array -> ");
        int siz = INPUT.nextInt();
        int Arr[] = new int[siz];
        int number;
        for (int i = 0; i < siz; i++)
        {
            number = INPUT.nextInt();
            Arr[i] = number;
        }
        return Arr;
    }
}

class Merge
{

    static void Sort (int _Arr[] , int start , int mid , int end)
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

    static void Merge_Sort (int _Arr[] , int start  , int end)
    {
        if (end <= start)
            return;
        int mid = (start + end) / 2;
        Merge_Sort(_Arr, start, mid);
        Merge_Sort(_Arr, mid + 1, end);
        Sort(_Arr , start , mid , end);
    }

    static void merge (int _Arr[])
    {
        Merge_Sort(_Arr , 0 , _Arr.length - 1);
    }

    int[] Finally_merge ()
    {
        System.out.println("Welcome To Our Small Algorithm Analysis Application");
        int Arr[];
        Arr = input.Input_Program();
        System.out.print("Array Before Merge Sort -> ");
        for (var it : Arr)
        {
            System.out.printf("%d ", it);
        }
        merge(Arr);
        System.out.println("\n----------\nArray After Merge Sort");
        for (int i = 0; i < Arr.length; i++)
        {
            System.out.printf("%d " , Arr[i]);
        }
        System.out.println("The Time Of Merge Method is O(n (log n))");
        return Arr;
    }
}


class Insertion_sort
{
    // private int Arr[];
    private int j;
    void InsSort (int Arr[])
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

    int[] Finally_Insertion ()
    {
        System.out.println("Welcome To Our Small Algorithm Analysis Application");
        int Arr[];
        Arr = input.Input_Program();
        System.out.print("Array Before Insertion Sort -> ");
        for (var it : Arr)
        {
            System.out.printf("%d ", it);
        }
        InsSort(Arr);
        System.out.println("\n----------\nArray After Insertion Sort");
        for (int i = 0; i < Arr.length; i++)
        {
            System.out.printf("%d " , Arr[i]);
        }
        System.out.println("The Time Of Insertion Method is O(n²)");
        return Arr;
    }
}

class BubbleSort
{
    // private int Arr[];
    // private int j;
    private void swap(int[] Arr, int i, int j) 
    {
        int temp = Arr[i];
        Arr[i] = Arr[j];
        Arr[j] = temp;
    }
    void BubSort (int Arr[])
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

    int[] Finally_BuB ()
    {
        System.out.println("Welcome To Our Small Algorithm Analysis Application");
        int Arr[];
        Arr = input.Input_Program();
        System.out.print("Array Before BubbleSort Sort -> ");
        for (var it : Arr)
        {
            System.out.printf("%d ", it);
        }
        BubSort(Arr);
        System.out.println("\n----------\nArray After BubbleSort Sort");
        for (int i = 0; i < Arr.length; i++)
        {
            System.out.printf("%d " , Arr[i]);
        }
        System.out.println("The Time Of BubbleSort Method is O(n²)");
        return Arr;
    }
}

class Search
{
    int Binary_Search (int _Arr[] , int _data)
    {
        int l = 0, r = _Arr.length , mid;
        while (l <= r)
        {
            mid = (l + r) / 2;
            if (_Arr[mid] == _data) return mid;
            else if (_Arr[mid] < _data)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return -1;
    }

    int Linear_Search (int _Arr[] , int _data)
    {
        int i = 0;
        for (var num : _Arr)
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
            System.out.println(" 🔥 Algorithm Analysis Tool - Main Menu 🔥");
            System.out.println("==========================================");
            System.out.println("1️⃣ Perform Merge Sort");
            System.out.println("2️⃣ Perform Insertion Sort");
            System.out.println("3️⃣ Perform Bubble Sort");
            System.out.println("4️⃣ Exit");
            System.out.println("==========================================");
            System.out.print("👉 Choose a sorting method: ");
            
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
                    System.out.println("🚀 Exiting the program... Goodbye!");
                    return;  
                default:
                    System.out.println("⚠️ Invalid choice! Please enter 1, 2, or 3.");
                    continue;
            }

            if (sortedArray != null) 
            {
                performSearch(sortedArray);
            }
        } while (true);
    }
    
        // Search menu after sorting
        static void performSearch(int[] sortedArray) 
        {
            @SuppressWarnings("resource")
            Scanner ss = new Scanner(System.in);
            int searchChoice;
    
            do 
            {
                System.out.println("\n==========================================");
                System.out.println(" 🔍 Choose a Searching Method 🔍");
                System.out.println("==========================================");
                System.out.println("1️⃣ Binary Search");
                System.out.println("2️⃣ Linear Search");
                System.out.println("3️⃣ Return to Main Menu");
                System.out.println("==========================================");
                System.out.print("👉 Enter your choice: ");
    
                searchChoice = ss.nextInt();
    
                switch (searchChoice) 
                {
                    case 1:
                        Search binarySearch = new Search();
                        System.out.print("Enter number to search: ");
                        int num = ss.nextInt();
                        int index = binarySearch.Binary_Search(sortedArray, num);
                        System.out.println(index == -1 ? " Element not found" : " Found at index: " + index);
                        System.out.println("Binary Search Method is log(n)");
                        // measureTime(,"binarySearch");
                        break;
                    case 2:
                        Search linearSearch = new Search();
                        System.out.print("Enter number to search: ");
                        num = ss.nextInt();
                        int pos = linearSearch.Linear_Search(sortedArray, num);
                        System.out.println(pos == -1 ? " Element not found" : " Found at index: " + pos);
                        System.out.println("Linear Search Method is (n)");
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println(" Invalid choice! Please enter 1, 2, or 3.");
                }
            } while (true);
        }
    
        void MainMenu ()
        {
            displayMenu();
            performSearch(sortedArray);
        }
}

class Algo  
{
    public static void main (String []argv)
    {
        MenuSystem mn = new MenuSystem();
        mn.MainMenu();
    }
}