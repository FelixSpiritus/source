#include <iostream>
#include<cmath>
using std::endl;
using std::cout;
using std::cin;
using std::string;

double curt(double a)
{
	if (a<0) return -pow(abs(a), 1.0 / 3.0);
	else return pow(a, 1.0 / 3.0);
}

double curti(double a)
{
	if (a == 0) return 0;
	else
	{
		double x, y;
		x = a / 3;
		do {
			y = x;
			x = 1.0 / 3.0 * (a / (x * x) + 2 * x);
		} while (abs(y - x) > 0.00001);
		return x;
	}
	

}

int main()
{
	double a;
	cout << "\nInput number: \n";
	cin >> a;
	cout << "\nCube root using pow is: " << curt(a)<< endl;
	cout << "\nCube root using iteration is: " << curti(a) << endl;
	return 0;
};