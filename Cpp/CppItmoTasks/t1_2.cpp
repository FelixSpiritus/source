#include <iostream>
using namespace std;


int main()
{
	system("chcp 1251");
	cout.precision(4);
	string name;
	double x;
	double a, b; cout << "\n������� a � b:\n";
	cin >> a; // ���� � ���������� �������� a
	cin >> name;
	cin >> b; // ���� � ���������� �������� b
	x = a / b; // ���������� �������� x
	cout << "\nx = " << x << endl; //����� ���������� �� �����
	cout << sizeof(a / b) << ends << " " << sizeof(x) << endl;
	cout << "������, " << name << "!\n";
	return 0;
}