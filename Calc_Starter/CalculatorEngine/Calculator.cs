using System.Reflection;

namespace Calculator
{

	using System;

	public class CalcEngine
	{
		//
		// Operation Constants.
		//
		public enum Operator : int
		{
			eUnknown = 0,
			eAdd = 1,
			eSubtract = 2,
			eMultiply = 3,
			eDivide = 4,
			ePow = 5,
			eSqrt = 6,
			eInverse = 7,
			eSquare = 8,
			eFact = 9,
			eCubroot = 10


		}
		public class Ecoef
        {
			public double Acoef { get; set; }
			public double Bcoef { get; set; }
			public double Ccoef { get; set; }
		}

		//
		// Module-Level Constants
		//

		private static double negativeConverter = -1;
		// TODO: Upgrade the version number to 3.0.1.1
		private static string versionInfo = "Calculator v2.0.1.1";

		//
		// Module-level Variables.
		//

		private static double numericAnswer;
		private static string stringAnswer;
		private static Operator calcOperation;
		private static double firstNumber;
		private static double secondNumber;
		private static bool secondNumberAdded;
		private static bool decimalAdded;

		//
		// Class Constructor.
		//

		public CalcEngine()
		{
			decimalAdded = false;
			secondNumberAdded = false;
		}

		//
		// Returns the custom version string to the caller.
		//

		public static string GetVersion()
		{
			return (versionInfo);
		}
		//
		// Called when the Date key is pressed.
		//

		public static string GetDate()
		{
			DateTime curDate = new DateTime();
			curDate = DateTime.Now;

			stringAnswer = String.Concat(curDate.ToShortDateString(), " ", curDate.ToLongTimeString());

			return (stringAnswer);
		}

		//
		// Called when a number key is pressed on the keypad.
		//

		public static string CalcNumber(string KeyNumber)
		{
			stringAnswer = stringAnswer + KeyNumber;
			return (stringAnswer);
		}

		//
		// Called when an operator is selected (+, -, *, /)
		//

		public static void CalcOperation(Operator calcOper)
		{
			if (stringAnswer != "" && !secondNumberAdded)
			{
				firstNumber = System.Convert.ToDouble(stringAnswer);
				calcOperation = calcOper;
				stringAnswer = "";
				decimalAdded = false;
			}
		}

		//
		// Called when the +/- key is pressed.
		//

		public static string CalcSign()
		{
			double numHold;

			if (stringAnswer != "")
			{
				numHold = System.Convert.ToDouble(stringAnswer);
				stringAnswer = System.Convert.ToString(numHold * negativeConverter);
			}

			return (stringAnswer);
		}

		//
		// Called when the . key is pressed.
		//

		public static string CalcDecimal()
		{
			if (!decimalAdded && !secondNumberAdded)
			{
				if (stringAnswer != "")
					stringAnswer = stringAnswer + ",";
				else
					stringAnswer = "0,";

				decimalAdded = true;
			}

			return (stringAnswer);
		}

		//
		// Called when = is pressed.
		//

		public static string CalcEqual()
		{
			bool validEquation = false;

			if (stringAnswer != "")
			{
				secondNumber = System.Convert.ToDouble(stringAnswer);
				secondNumberAdded = true;

				switch (calcOperation)
				{
					case Operator.eUnknown:
						validEquation = false;
						break;

					case Operator.eAdd:
						numericAnswer = firstNumber + secondNumber;
						validEquation = true;
						break;

					case Operator.eSubtract:
						numericAnswer = firstNumber - secondNumber;
						validEquation = true;
						break;

					case Operator.eMultiply:
						numericAnswer = firstNumber * secondNumber;
						validEquation = true;
						break;

					case Operator.ePow:
						numericAnswer = Math.Pow(firstNumber, secondNumber);
						validEquation = true;
						break;


					case Operator.eDivide:
						numericAnswer = firstNumber / secondNumber;
						validEquation = true;
						break;




					default:
						validEquation = false;
						break;
				}

				if (validEquation)
					stringAnswer = System.Convert.ToString(numericAnswer);
			}

			return (stringAnswer);
		}

		private static ulong Fact(ulong n)
		{

			if (n == 0) return 1;
			if (n == 1) return 1;

			return (n * Fact(n - 1));

		}
		public static string CalcFunc()
		{
			bool validEquation = false;

			if (stringAnswer == "")
			{

				switch (calcOperation)
				{
					case Operator.eUnknown:
						validEquation = false;
						break;

					case Operator.eSqrt:
						numericAnswer = Math.Sqrt(firstNumber);
						validEquation = true;
						break;

					case Operator.eInverse:
						numericAnswer = 1 / firstNumber;
						validEquation = true;
						break;

					case Operator.eSquare:
						numericAnswer = Math.Pow(firstNumber, 2);
						validEquation = true;
						break;

					case Operator.eFact:
						if (firstNumber >= 0)
						{
							numericAnswer = Fact((ulong)firstNumber);
							validEquation = true;
						}
						break;

					case Operator.eCubroot:
						numericAnswer = Math.Pow(firstNumber, (1.0 / 3.0));
						validEquation = true;
						break;

					default:
						validEquation = false;
						break;
				}

				if (validEquation)
					stringAnswer = System.Convert.ToString(numericAnswer);
			}

			return (stringAnswer);
		}
		private static int QEquation(Ecoef ec, ref double x1, ref double x2)
		{
			int f = 0;
			double d = ec.Bcoef * ec.Bcoef - 4 * ec.Acoef * ec.Ccoef;
			if (d == 0)
			{
				f = 0;
				x1 = x2 = -ec.Bcoef / (2 * ec.Acoef);
			}
			if (d > 0)
			{
				f = 1;
				x1 = (-ec.Bcoef + Math.Sqrt(d)) / (2 * ec.Acoef);
				x2 = (-ec.Bcoef - Math.Sqrt(d)) / (2 * ec.Acoef);
			}
			if (d < 0) f = -1;
			return f;
		}
		public static string GetQE(Ecoef ec)
		{
			double x1 = 0;
			double x2 = 0;
			int f = QEquation(ec, ref x1, ref x2);
			if (f == -1) stringAnswer="Корней нет";
			if (f == 0) stringAnswer="x1=x2="+ Math.Round(x1,2);
			if (f == 1) stringAnswer="x1="+Math.Round(x1,2)+" x2="+ Math.Round(x2,2);
			return stringAnswer;
		}


		//
		// Resets the various module-level variables for the next calculation.
		//

		public static void CalcReset ()
		{
			numericAnswer = 0;
			firstNumber = 0;
			secondNumber = 0;
			stringAnswer = "";
			calcOperation = Operator.eUnknown;
			decimalAdded = false;
			secondNumberAdded = false;			
		}
	}
}