using System;
using System.Linq;

namespace DieHard
{
    enum Location
    {
        Air,
        Fire,
        Water
    }
    class DieHard
    {
        private int _moveNumber = 0;
        private int _health;
        private int _armor;
        private Location _location;

        static void Main(string[] args)
        {
            (new DieHard()).Solve();
        }
        void Solve()
        {
            int numTests = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < numTests; i++)
            {
                int[] inputs = Console.ReadLine().Split(' ').Select(num => Convert.ToInt32(num)).ToArray();
                PlayGame(inputs[0], inputs[1]);
            }
        }
        void PlayGame(int startingHealth, int startingArmor)
        {
            _health = startingHealth + 3;
            _armor = startingArmor + 2;
            _location = Location.Air;
            _moveNumber = 1;

            while (_health > 0 && _armor > 0)
            {
                MakeMove();
            }
            Console.WriteLine(_moveNumber);
        }
        void MakeMove()
        {
            switch (_location)
            {
                case Location.Fire:
                case Location.Water:
                    _location = Location.Air;
                    _health += 3;
                    _armor += 2;
                    _moveNumber++;
                    break;
                case Location.Air:
                    if (_health > 5 && _armor > 10)
                    {
                        _location = Location.Water;
                        _health -= 5;
                        _armor -= 10;
                        _moveNumber++;
                    }
                    else if (_health > 20)
                    {
                        _location = Location.Fire;
                        _health -= 20;
                        _armor += 5;
                        _moveNumber++;
                    }
                    else
                    {
                        _health = 0;
                    }
                    break;
            }

        }

    }
}
