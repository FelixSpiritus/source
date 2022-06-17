#include <iostream>
#include<cmath>
using namespace std;
int main()
{
	cout.precision(3);
	double p, s;
	cout << "\nInput perimetr:\n";
	cin >> p;
	s = sqrt(p * pow((p - p / 3), 3));
	cout << "\nside " << "area" << endl;
	cout << p/3 << " " << s << "\n";
	return 0;
}