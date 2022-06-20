#include <iostream>
#include<cmath>
using std::endl;
using std::cout;
using std::cin;
using std::string;

double TriangleArea(int a, int b, int c)
{
	double p = 0.5 * (a + b + c);
	return sqrt(p * (p - a) * (p - b) * (p - c));
}

double TriangleArea(int a)
{
	double p = 1.5 * a;
	return sqrt(p * pow((p - a),3));
}


int main()
{
	string n;
	cout << "\nEnter 1 for one side, something else for three sides \n";
	cin >> n;
	if (n == "1")
	{
		int a;
		cout << "\nEnter triangle side: \n";
		cin >> a;
		cout << "\nTriangle area is: " << TriangleArea(a) <<endl;
	}
	else {
		int a, b, c;
		cout << "\nEnter triangle sides a, b, c: \n";
		cin >> a;
		cin >> b;
		cin >> c;
		cout << "\nTriangle area is: " << TriangleArea(a,b,c) << endl;

	}

	return 0;
}