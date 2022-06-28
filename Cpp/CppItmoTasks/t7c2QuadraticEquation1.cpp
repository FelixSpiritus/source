#include <iostream>
#include<cmath>
using std::endl;
using std::cout;
using std::cin;
using std::string;

struct Roots
{
    double x1;
    double x2;
};

int Myroot(double, double, double, Roots& r);

int main()
{
    double a, b, c;
    Roots r;
    cout << "\nInput a,b,c: \n";
    cin >> a; cin >> b; cin >> c;
    int f = Myroot(a, b, c, r);
    if (f == -1) cout << "\na = " << a << ",  b = " << b << ", c = " << c << " NO ROOTS" << endl;
    if (f == 0) cout << "\na = " << a << ",  b = " << b << ", c = " << c << " ONE ROOT x1 = x2 = " << r.x1 << endl;
    if (f == 1) cout << "\na = " << a << ",  b = " << b << ", c = " << c << " TWO ROOTS x1 = " << r.x1 << ", x2 = " << r.x2 << endl;

    return 0;
};

int Myroot(double a, double b, double c, Roots& r)
{
    int f = 0;
    double d = b * b - 4 * a * c;
    if (d == 0)
    {
        f = 0;
        r.x1 = r.x2 = -b / (2 * a);
    }
    if (d > 0)
    {
        f = 1;
        r.x1 = (-b + sqrt(d)) / (2 * a);
        r.x2 = (-b - sqrt(d)) / (2 * a);
    }
    if (d < 0) f = -1;
    return f;
};