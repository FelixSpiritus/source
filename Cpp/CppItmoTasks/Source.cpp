#include <iostream>
#include<cmath>
using std::endl;
using std::cout;
using std::cin;
using std::string;

int summa(int k, ...)
{
	int* p = &k;
	int s = 0;
	for (; k>0; k--)
		cout << k << endl;
		//cout << *(++p) << endl;
		s += *(++p);
	return s;
}


int main()
{
	//for (int a = 1; a < 10; a++) {
	//	//int a = 1;
	//	int* i;                 // Объявили указатель на целое 
	//	i = &a;  	  // Инициализировали указатель адресом переменной а
	//	cout << i << endl; 	// Выводим адрес, хранимый в указателе
	//	cout << i+1 << endl; 	// Выводим адрес, хранимый в указателе

	//	//*i = 15;           // В адрес памяти, полученный из указателя будет 15 
	//	cout << *i << endl;    // по адресу, хранимому в указателе на экран 
	//	cout << a << endl;
	//}
	//char c = 1;
	//char* ch = &c;         //Объявили указатель на тип char 
	//
	//*ch = 115;     //В адрес памяти, полученный из указателя будет 115 
	//cout << ch+1 << endl;    // обратите внимание на ch!!! 
	int a, b;
	cout << "\n summa(2,6,4)=" << summa(2,6,4);
	cout << "\n summa(6,1,2,3,4,5,6)=" << summa(6, 1, 2, 3, 4, 5, 6);

	
	return 0;
};
