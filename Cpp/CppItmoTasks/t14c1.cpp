#include <iostream>
using namespace std;


template<class T>
double average_value(T arr[], int size)
{
	double sum = 0;
	for (int i = 0; i < size; i++) sum += arr[i];
	return (1.0 * sum / size);
}


int main()
{
	int arr[] = { 9,3,17,6,5,4,31,2,12 };
	double arrd[] = { 2.1, 2.3,1.7,6.6,5.3,2.44,3.1,2.4,1.2 };
	char arrc[] = "Hello, world";
	int k1 = sizeof(arr) / sizeof(arr[0]);
	int k2 = sizeof(arrd) / sizeof(arrd[0]);
	int k3 = sizeof(arrc) / sizeof(arrc[0]) - 1;
	cout << "Average value arr = " << average_value(arr, k1) << endl;
	cout << "Average value arrd = " << average_value(arrd, k2) << endl;
	cout << "Average value arrc = " << average_value(arrc, k3) << endl;
	

}