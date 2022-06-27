#include <iostream>
using std::endl;
using std::cout;
using std::cin;
using std::string;

void PrintMas(const int n, int a[]);
void SortMas(const int n, int a[]);
int SumMas(const int n, int a[]);
int AvgMas(const int n, int a[]);
int NegSum(const int n, int a[]);
int PosSum(const int n, int a[]);
int EvenIndexSum(const int n, int a[]);
int OddIndexSum(const int n, int a[]);
int MinMasIndex(const int n, int a[]);
int MaxMasIndex(const int n, int a[]);
long long ProductBMM(const int n, int a[]);



int main()
{
    const int n = 10;
    int mas[n] = { 1, 25, 6, 32, 43, 5, 96, 23, 4, 55 };
    SortMas(n, mas);
    PrintMas(n, mas);
    cout << "\nSum elements is: " << SumMas(n, mas) << endl;
    cout << "\nAverage is: " << AvgMas(n, mas) << endl;
    cout << "\nNagative sum is: " << NegSum(n, mas) << endl;
    cout << "\nPositive sum is: " << PosSum(n, mas) << endl;
    cout << "\nEven index sum is: " << EvenIndexSum(n, mas) << endl;
    cout << "\nOdd index sum is: " << OddIndexSum(n, mas) << endl;
    cout << "\nMin element index is: " << MinMasIndex(n, mas) << endl;
    cout << "\nMax element index is: " << MaxMasIndex(n, mas) << endl;
    cout << "\nProduct between min and max is: " << ProductBMM(n, mas) << endl;

 
    
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

void PrintMas(const int n, int a[])
{
    for (int i = 0; i < n; i++)
        cout << a[i] << '\t';
}

int SumMas(const int n, int a[])
{
    int s = 0;
    for (int i = 0; i < n; i++)
    {
        s += a[i];
    }
    return s;
}

int AvgMas(const int n, int a[])
{
    return SumMas(n, a) / n;
}

int NegSum(const int n, int a[])
{
    int s = 0;
    for (int i = 0; i < n; i++)
    {
        if (a[i]<0)  s += a[i];
    }
    return s;
}

int PosSum(const int n, int a[])
{
    int s = 0;
    for (int i = 0; i < n; i++)
    {
        if (a[i] > 0)  s += a[i];
    }
    return s;
}

int EvenIndexSum(const int n, int a[])
{
    int s = 0;
    for (int i = 0; i < n; i++)
    {
        if (i %2 == 0)  s += a[i];
    }
    return s;
}

int OddIndexSum(const int n, int a[])
{
    int s = 0;
    for (int i = 0; i < n; i++)
    {
        if (i % 2 != 0)  s += a[i];
    }
    return s;
}

int MinMasIndex(const int n, int a[])
{
    int s = a[0];
    for (int i = 1; i < n; i++)
    {
        if (a[i] < s)  s = a[i];
    }
    for (int i = 0; i < n; i++)
    {
        if (s == a[i])
        {
            s = i;
            break;
        }
    }
    return s;
}

int MaxMasIndex(const int n, int a[])
{
    int s = a[0];
    for (int i = 1; i < n; i++)
    {
        if (a[i] > s)  s = a[i];
    }
    for (int i = 0; i < n; i++)
    {
        if (s == a[i])
        {
            s = i;
            break;
        }
    }
    return s;
}

long long ProductBMM(const int n, int a[])
{
    int min = MinMasIndex(n, a);
    int max = MaxMasIndex(n, a);
    long long s = 1;
    for (int i = min+1; i < max; i++)
    {
        s *= a[i];
    }
    return s;
}