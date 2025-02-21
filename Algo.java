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

    void Finally_merge ()
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

    void Finally_Insertion ()
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

    void Finally_BuB ()
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

class MenuSystem 
{
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
            System.out.println("3️⃣ Perform Binary Search");
            System.out.println("4️⃣ Perform Linear Search");
            System.out.println("5️⃣ Exit");
            System.out.println("==========================================");
            System.out.print("👉 Enter your choice: ");
            
            choice = ss.nextInt();

            switch (choice) 
            {
                case 1:
                    Merge mSort = new Merge();
                    mSort.Finally_merge();
                    break;
                case 2:
                    Insertion_sort iSort = new Insertion_sort();
                    iSort.Finally_Insertion();
                    break;
                case 3:
                    Search binarySearch = new Search();
                    System.out.print("Enter number to search: ");
                    int num = ss.nextInt();
                    int[] sortedArray = {10, 20, 30, 40, 50};  
                    int index = binarySearch.Binary_Search(sortedArray, num);
                    System.out.println(index == -1 ? "❌ Element not found" : "✅ Found at index: " + index);
                    break;
                case 4:
                    Search linearSearch = new Search();
                    System.out.print("Enter number to search: ");
                    num = ss.nextInt();
                    int[] arr = {5, 15, 25, 35, 45};
                    int pos = linearSearch.Linear_Search(arr, num);
                    System.out.println(pos == -1 ? "❌ Element not found" : "✅ Found at index: " + pos);
                    break;
                case 5:
                    System.out.println("🚀 Exiting the program... Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice! Please enter a number between 1-5.");
            }
        } while (choice != 5);
    }
}

class Algo  
{
    public static void main (String []argv)
    {
        Insertion_sort M1 = new Insertion_sort();
        M1.Finally_Insertion();
    }
}