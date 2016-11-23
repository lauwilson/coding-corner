using System;

namespace Inversions
{
    class Inversions
    {
        static void Main(string[] args)
        {
            Inversions inv = new Inversions();
            inv.Solve();
            Console.ReadLine();
        }

        void Solve()
        {
            int numTests = Convert.ToInt32(Console.ReadLine());
            int numElements;
            Console.ReadLine();
            for (int i = 0; i < numTests; i++)
            {
                numElements = Convert.ToInt32(Console.ReadLine());
                long[] array = new long[numElements];
                for (int j = 0; j < numElements; j++)
                {
                    array[j] = Convert.ToInt64(Console.ReadLine());
                }

                long numOfInversions = 0;
                mergeSort(ref array, 0, array.Length - 1, ref numOfInversions);
                Console.WriteLine(numOfInversions);
                Console.ReadLine();
            }
            Console.ReadLine();
        }

        void mergeSort(ref long[] array, int low, int high, ref long numOfInversions)
        {
            if (low >= high)
            {
                return;
            }

            int mid = ((high + low) / 2);
            mergeSort(ref array, low, mid, ref numOfInversions);
            mergeSort(ref array, mid+1, high, ref numOfInversions);

            long[] tempArray = new long[high - low + 1];

            int i = low;
            int j = mid + 1;
            int k = 0;

            while (i <= mid && j <= high)
            {
                if (array[j] < array[i])
                {
                    numOfInversions += (mid + 1 - i);
                    tempArray[k++] = array[j++];
                }
                else
                {
                    tempArray[k++] = array[i++];
                }
            }

            while (i <= mid)
            {
                tempArray[k++] = array[i++];
            }
            while (j <= high)
            {
                tempArray[k++] = array[j++];
            }

            Array.Copy(tempArray, 0, array, low, tempArray.Length);
        }
    }
}
