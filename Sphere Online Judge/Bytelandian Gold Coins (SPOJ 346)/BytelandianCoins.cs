using System;
using System.Collections.Generic;
using System.Text;

    public class BytelandianCoins
    {

        Dictionary<long, long> cache = new Dictionary<long, long>();

        static void Main(string[] args)
        {
            BytelandianCoins b = new BytelandianCoins();
            b.Solve();
        }

        void Solve()
        {
            for (int i = 0; i < 10; i++)
            {
                string testInputString;
                if ((testInputString = Console.ReadLine()) != null)
                {
                    try
                    {
                        long coinValue = Convert.ToInt64(testInputString);
                        Console.WriteLine(GetValue(coinValue));
                    }
                    catch (Exception e)
                    {
                    }
                }
            }
        }

        long GetValue(long n)
        {
            if (n == 0)
                return 0;
            if (cache.ContainsKey(n))
                return cache[n];
            long tradeValue;
            tradeValue = GetValue(n / 2) + GetValue(n / 3) + GetValue(n / 4);
            if (tradeValue > n)
            {
                cache[n] = tradeValue;
                return tradeValue;
            }
            else
            {
                cache[n] = n;
                return n;
            }
        }
    }
