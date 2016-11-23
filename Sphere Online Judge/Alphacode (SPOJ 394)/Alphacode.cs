using System;
using System.Collections.Generic;

namespace Alphacode
{
    class Alphacode
    {
        Dictionary<string, int> cache = new Dictionary<string, int>();

        static void Main(string[] args)
        {
            Alphacode a = new Alphacode();
            a.Solve();
        }

        void Solve()
        {
            string input;
            while ((input = Console.ReadLine()) != "0")
            {
                int numOfDecodings = GetDecodings(input);
                Console.WriteLine(numOfDecodings);
            }
        }

        int GetDecodings(string code)
        {
            if (cache.ContainsKey(code))
                return cache[code];

            if (code.Length == 1)
            {
                cache[code] = 1;
                return 1;
            }

            string substring = code.Substring(1);
            int numOfDecodings = 0;
            if (substring[0] != '0')
            {
                numOfDecodings += GetDecodings(substring);
            }

            int digit = Convert.ToInt32(code.Substring(0, 2));
            if (digit < 27)
            {
                if (code.Length > 2)
                {
                    string substring2 = code.Substring(2);
                    if (substring2[0] == '0')
                    {
                        numOfDecodings += 0;
                    }
                    else
                    {
                        numOfDecodings += GetDecodings(substring2);
                    }
                }
                else
                {
                    numOfDecodings += 1;
                }
            }
            cache[code] = numOfDecodings;
            return numOfDecodings;
        }
    }
}
