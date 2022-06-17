#include <iostream>
using namespace std;


int main()
{
	system("chcp 1251");
	cout.precision(4);
	string name;
	double x;
	double a, b; cout << "\nВведите a и b:\n";
	cin >> a; // ввод с клавиатуры значения a
	cin >> name;
	cin >> b; // ввод с клавиатуры значения b
	x = a / b; // вычисление значения x
	cout << "\nx = " << x << endl; //вывод результата на экран
	cout << sizeof(a / b) << ends << " " << sizeof(x) << endl;
	cout << "Привет, " << name << "!\n";
	return 0;
}