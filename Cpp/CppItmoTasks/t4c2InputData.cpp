#include <iostream>
#include<cmath>
using std::endl;
using std::cout;
using std::cin;
using std::string;

bool Input(int& a, int& b)
{
    cout << "\nInput a > 0 and b > 0: \n";
    cin >> a; cin >> b;
    if (a > 0 && b > 0) return true;
    else return false;
};


int main()
{
    int a, b;
    if (Input(a, b) == false) // if(!Input(a,b))
    {
        std::cerr << "error";
        return 1;
    }
    int s = a + b;
    cout << "\na + b = " << s << endl;
    return 0;
};