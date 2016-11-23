using System;
using System.Linq;

class TLD
{
    static void Main(string[] args)
    {
        (new TLD()).Go();
    }

    void Go()
    {
        int numTests = Convert.ToInt32(Console.ReadLine());
        for (int i = 0; i < numTests; i++)
        {
            int[] inputs = Console.ReadLine().Split(' ').Select(num => Convert.ToInt32(num)).ToArray();
            if (inputs[1] == 0)
            {
                Console.WriteLine(1);
                continue;
            }
            int pow = (inputs[1] % 4 == 0 ? 4 : inputs[1] % 4);
            Console.WriteLine(Math.Pow(inputs[0] % 10, pow) % 10);
        }
    }
}
