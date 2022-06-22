#include <iostream>
#include<cmath>
using std::endl;
using std::cout;
using std::cin;
using std::string;

int RowSum(int n)
{
	if (n > 0)
		return 5 * n + RowSum(n - 1);
	return 0;
}


int main()
{	
	int n;
	cout << "\nInput number: \n";
	cin >> n;
	cout << "\nResult: " << RowSum(n) << endl;
	return 0;
};