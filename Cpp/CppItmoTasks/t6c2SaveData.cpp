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
    int min = 0; // дл€ записи минимального значени€
    int buf = 0; // дл€ обмена значени€ми
    for (int i = 0; i < n; i++)
    {
        min = i; // номер текущей €чейки, как €чейки с минимальным значением
        // в цикле найдем реальный номер €чейки с минимальным значением
        for (int j = i + 1; j < n; j++)
            min = (a[j] < a[min]) ? j : min;
        // перестановка этого элемента, помен€в его местами с текущим
        if (i != min)
        {
            buf = a[i];
            a[i] = a[min];
            a[min] = buf;
        }
    }
}