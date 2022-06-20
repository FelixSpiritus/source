#include <iostream>
using std::endl;
using std::cout;
using std::cin;
using std::string;

double MaxNum(double a, double b, double c)
{
	double max;
	if (a > b) max = a;
	else max = b;
	if (c > max) max = c;
	return max;
}

int main()
{
	double a, b, c;
	cout << "\nInput 3 numbers:\n";
	cin >> a;
	cin >> b;
	cin >> c;
	cout << "\nMax number is:  " << MaxNum(a,b,c) << endl;
	return 0;
}