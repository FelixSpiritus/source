#include <iostream>
#include<cmath>
#include <string>
using std::endl;
using std::cout;
using std::cin;
using std::string;
using std::to_string;


string BinConvert(int n)
{
	if (n > 1)
		return BinConvert(n / 2) + to_string(n % 2);
	return "1";
}


int main()
{
	int n;
	cout << "\nInput number: \n";
	cin >> n;
	cout << "\nResult: " << BinConvert(n) << endl;
	return 0;
};