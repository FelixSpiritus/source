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
	//	int* i;                 // �������� ��������� �� ����� 
	//	i = &a;  	  // ���������������� ��������� ������� ���������� �
	//	cout << i << endl; 	// ������� �����, �������� � ���������
	//	cout << i+1 << endl; 	// ������� �����, �������� � ���������

	//	//*i = 15;           // � ����� ������, ���������� �� ��������� ����� 15 
	//	cout << *i << endl;    // �� ������, ��������� � ��������� �� ����� 
	//	cout << a << endl;
	//}
	//char c = 1;
	//char* ch = &c;         //�������� ��������� �� ��� char 
	//
	//*ch = 115;     //� ����� ������, ���������� �� ��������� ����� 115 
	//cout << ch+1 << endl;    // �������� �������� �� ch!!! 
	int a, b;
	cout << "\n summa(2,6,4)=" << summa(2,6,4);
	cout << "\n summa(6,1,2,3,4,5,6)=" << summa(6, 1, 2, 3, 4, 5, 6);

	
	return 0;
};
