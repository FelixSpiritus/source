#include <iostream>
using std::cout;
using std::cin;
using std::string;

string LeapYear(int year)
{
	if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) return "YES";
	else return "NO";
}

int main()
{
	int year;
	cout << "\Enter year:\n";
	cin >> year;
	cout << "\nEntered year is leap:  " << LeapYear(year);
	return 0;
}