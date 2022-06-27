#include <iostream> 
#include <fstream>
#include <windows.h>
using namespace std;

int main()
{
	SetConsoleOutputCP(1251);
	SetConsoleCP(1251);
	const int MAX = 400;
	char str[MAX];
	cout << "¬ведите стихотворение (& закончить): \n";
	cin.get(str, MAX,'&');
	ofstream fout("poem.txt");
	fout << str << "\n";
	fout.close();
	return 0;
}
