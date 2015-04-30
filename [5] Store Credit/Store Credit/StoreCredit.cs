using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Store_Credit
{
    /// <summary>
    /// Google Code Jam 2010 - Qualification Round
    /// 
    /// In each case, program finds the indices of the two values which equal the desired total value.
    /// </summary>
    class StoreCredit
    {
        public int numberOfCases;
        public StreamReader input;
        public StreamWriter output;

        /// <summary>
        /// Method reads from the inputFile, runs program logic, and outputs to the outputFile.
        /// </summary>
        /// <param name="inputFile">The input file to read from.</param>
        /// <param name="outputFile">The output file to read from.</param>
        public void Run(string inputFile, string outputFile)
        {
            // Try and load the inputs and outputs. Terminate if failure.
            try
            {
                input = new StreamReader(inputFile);
                output = new StreamWriter(outputFile);
            }
            catch (Exception)
            {
                Console.WriteLine("File not found. Terminating program");
                Console.WriteLine("Press any key to continue.");
                Console.ReadKey();
                Environment.Exit(0);
            }

            numberOfCases = int.Parse(input.ReadLine());

            for (int i = 0; i < numberOfCases; i++)
            {
                int totalValue = int.Parse(input.ReadLine());
                int numberOfItems = int.Parse(input.ReadLine());
                int[] itemValues = parseArray(input.ReadLine());

                int[] result = findPair(itemValues, totalValue);

                Console.WriteLine("Case #" + (i + 1) + ": " + result[0] + " " + result[1]);
                output.WriteLine("Case #" + (i + 1) + ": " + result[0] + " " + result[1]);
            }

            output.Flush();
            Console.WriteLine("\nPress any key to continue.");
            Console.ReadKey();
        }

        /// <summary>
        /// Method converts a line of input into an array of integers which represent the item values.
        /// </summary>
        /// <param name="line">The input line that is read from the file.</param>
        /// <returns>An integer array which represents the item values for the case.</returns>
        public int[] parseArray(string line)
        {
            string[] costs = line.Split(' ');
            int[] itemValues = new int[costs.Length];

            for (int i = 0; i < costs.Length; i++)
                itemValues[i] = int.Parse(costs[i]);

            return itemValues;
        }

        /// <summary>
        /// Method finds the indicies of the pair of items which total the desired value.
        /// </summary>
        /// <param name="values">Array of item values in the store.</param>
        /// <param name="total">Desired total value that method matches to.</param>
        /// <returns>An int array which holds the two indicies of the items desired.</returns>
        public int[] findPair(int[] values, int total)
        {
            for (int i = 0; i < values.Length; i++)
                for (int j = i + 1; j < values.Length; j++)
                {
                    if ((values[i] + values[j]) == total)
                    {
                        int[] pair = {i+1, j+1};
                        return pair;
                    }
                }
            return null;
        }

        /// <summary>
        /// Main driver method for the program.
        /// </summary>
        static void Main()
        {
            new StoreCredit().Run("../../A-small-practice.in", "../../A-small-output.txt");
            new StoreCredit().Run("../../A-large-practice.in", "../../A-large-output.txt");
        }
    }
}
