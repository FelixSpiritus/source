#include <iostream> 
#include <fstream>
using namespace std;

void SortMas(const int n, int a[]);

int main()
{
	const int n = 10;
	int mas[n] = { 1, 25, 6, 32, 43, 5, 96, 23, 4, 55 };
    ofstream fout("array.txt");
    for (int i = 0; i < n; i++)
        fout << mas[i] << '\t';
    fout << '\n';
    cout << "\n Original array data saved to file \n";
    SortMas(n, mas);
    for (int i = 0; i < n; i++)
        fout << mas[i] << '\t';
    fout << '\n';
    cout << "\n Sorted array data saved to file \n";
    fout.close();
};

void SortMas(const int n, int a[])
{
    int min = 0; // ��� ������ ������������ ��������
    int buf = 0; // ��� ������ ����������
    for (int i = 0; i < n; i++)
    {
        min = i; // ����� ������� ������, ��� ������ � ����������� ���������
        // � ����� ������ �������� ����� ������ � ����������� ���������
        for (int j = i + 1; j < n; j++)
            min = (a[j] < a[min]) ? j : min;
        // ������������ ����� ��������, ������� ��� ������� � �������
        if (i != min)
        {
            buf = a[i];
            a[i] = a[min];
            a[min] = buf;
        }
    }
}