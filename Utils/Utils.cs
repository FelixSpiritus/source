
namespace Utils
{
    using System;

    public class Utils
    {
        // Calculate factorial
        // and return the result as an out parameter
        public static bool Factorial(int n, out int answer)
        {
            int k; // Loop counter
            int f; // Working value
            bool ok = true; // True if okay, false if not
                            // Check the input value
            if (n < 0)
                ok = false;
            // Calculate the factorial value as the
            // product of all of the numbers from 2 to n
            try
            {
                checked
                {
                    f = 1;
                    for (k = 2; k <= n; ++k)
                    {
                        f = f * k;
                    }
                }
            }
            catch (Exception)
            {
                f = 0;
                ok = false;
            }
            answer = f;
            return ok;
        }
        public static void Reverse(ref string s)
        {
            string sRev = "";
            for (int k = s.Length - 1; k >= 0; k--)
                sRev = sRev + s[k];
            // Return result to caller
            s = sRev;
        }
        public static bool IsItFormattable(object x)
        {
            if (x is IFormattable)
                return true;
            else
                return false;
        }



    }

}
