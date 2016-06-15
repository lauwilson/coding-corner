using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Minimum_Scalar
{
    class MinimumScalar
    {
        public int numTestCases;

        void Run(string inputFile, string outputFile)
        {
            using (StreamReader input = new StreamReader(inputFile))
            using (StreamWriter output = new StreamWriter(outputFile))
            {
                numTestCases = int.Parse(input.ReadLine());

                for (int i = 0; i < numTestCases; i++)
                {
                    long sum = 0;
                    int coordinateLength = int.Parse(input.ReadLine());

                    long[] vector1 = ParseArray(input.ReadLine());
                    long[] vector2 = ParseArray(input.ReadLine());

                    Array.Sort(vector1);
                    Array.Sort(vector2);

                    for (int j = 0, k = coordinateLength - 1; j < coordinateLength; j++, k--)
                    {
                        sum += vector1[j] * vector2[k];
                    }
                    Console.WriteLine("Case #" + (i + 1) + ": " + sum);
                    output.WriteLine("Case #" + (i + 1) + ": " + sum);
                }
                output.Flush();
            }
            Console.WriteLine("\nPress any key to continue.");
            Console.ReadKey();
        }

        long[] ParseArray(string arrayString)
        {
            long[] result;
            string[] temp = arrayString.Split(' ');
            result = new long[temp.Length];
            for (int i = 0; i < temp.Length; i++)
                result[i] = long.Parse(temp[i]);

            return result;
        }

        static void Main(string[] args)
        {
            new MinimumScalar().Run("../../A-small-practice.in", "../../A-small-output.txt");
            new MinimumScalar().Run("../../A-large-practice.in", "../../A-large-output.txt");
        }
    }
}
