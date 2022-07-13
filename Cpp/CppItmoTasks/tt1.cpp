#include <iostream>
#include <string>
#include "windows.h"
using namespace std;

class A {
private:
    int length;
    int* array;
public:
    A()
    {
        length = 0;
        array = {};
    }
    A(int n)
    {
        length = n;
        array = new int[length];               
    }
    A(const A& arr) {
        length = arr.length;
        array = new int[length];
        for (int i = 0; i < length; i++) array[i] = arr.array[i];
    }
    int size() const 
    {
        int cnt = 0;
        for (int i = 0; i < length; i++) cnt++;
        return cnt;
    }
    ~A()
    {
            //cout << "delete " << length << endl;
            delete[] array;
    }
    A& operator=(const A& arr)
    {
        if (length > 0) delete[] array;
        length = arr.length;
        array = new int[length];
        for (int i = 0; i < length; i++) array[i] = arr.array[i];
        return *this;
    }
    const int& operator[] (const int& i)const
    {
        return array[i];
    }
};

int main()
{
	A a1;
	A a2(10); //10 Ц размер массива 
	A a3 = a2;
	a1 = a3;
	a2 = A(20);
	const A a4(5);
    for (int i = 0; i < a2.size(); i++)
    {
        cout << a4[i];
    }
    cout << endl;
}



