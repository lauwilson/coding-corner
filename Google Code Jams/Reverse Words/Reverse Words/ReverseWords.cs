using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Reverse_Words
{
    class ReverseWords
    {
        public int numberOfCases;
        public StreamReader input;
        public StreamWriter output;

        public void Run(string inputFile, string outputFile)
        {
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
                string caseInput = input.ReadLine();
                string[] listOfWords = caseInput.Split(' ');
                StringBuilder sb = new StringBuilder();

                for (int j = listOfWords.Length; j > 0; j--)
                    sb.Append(listOfWords[j - 1] + " ");

                Console.WriteLine("Case #" + (i + 1) + ": " + sb.ToString());
                output.WriteLine("Case #" + (i + 1) + ": " + sb.ToString());

            }
            output.Flush();
            Console.WriteLine("\nPress any key to continue.");
            Console.ReadKey();
        }

        static void Main(string[] args)
        {
            new ReverseWords().Run("../../B-small-practice.in", "../../B-small-output.txt");
            new ReverseWords().Run("../../B-large-practice.in", "../../B-large-output.txt");
        }
    }
}
