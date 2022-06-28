#include <iostream>
#include <tuple>
using namespace std;

using Tuple = tuple<double, double, int>;

Tuple Myroot(double, double, double);

int main()
{
    double a, b, c;
    cout << "\nInput a,b,c: \n";
    cin >> a; cin >> b; cin >> c;
    Tuple t = Myroot(a, b, c);
    if (get<2>(t) == -1) cout << "\na = " << a << ",  b = " << b << ", c = " << c << " NO ROOTS" << endl;
    if (get<2>(t) == 0) cout << "\na = " << a << ",  b = " << b << ", c = " << c << " ONE ROOT x1 = x2 = " << get<0>(t) << endl;
    if (get<2>(t) == 1) cout << "\na = " << a << ",  b = " << b << ", c = " << c << " TWO ROOTS x1 = " << get<0>(t) << ", x2 = " << get<1>(t) << endl;

    return 0;
};

Tuple Myroot(double a, double b, double c)
{
    double x1, x2;
    int f;
    double d = b * b - 4 * a * c;
    if (d == 0)
    {
        f = 0;
        x1 = x2 = -b / (2 * a);
    }
    if (d > 0)
    {
        f = 1;
        x1 = (-b + sqrt(d)) / (2 * a);
        x2 = (-b - sqrt(d)) / (2 * a);
    }
    if (d < 0) f = -1;
    return make_tuple(x1, x2, f);
};