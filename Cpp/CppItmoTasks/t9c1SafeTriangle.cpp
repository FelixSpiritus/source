#include <iostream>
#include "windows.h"
#include<cmath>
using std::endl;
using std::cout;
using std::cin;
using std::string;


class Triangle
{
public:
	class SidetooLong
	{
	public:
		SidetooLong() : message("one side is longer than two others") { }
		void printMessage() const
		{
			cout << message << endl;
		}
	private:
		string message;
	};
	Triangle(int a, int b, int c)
	{
		if (a+b < c || a+c < b || b+c < a) throw SidetooLong();
		this->a = a;
		this->b = b;
		this->c = c;
	}
	double TriangleArea()
	{
		double p = 0.5 * (this->a + this->b + this->c);
		return sqrt(p * (p - this->a) * (p - this->b) * (p - this->c));
	}
private:
	int a, b, c;
};

int main()
{

	int a, b, c;
	cout << "\nEnter triangle sides a, b, c: \n";
	cin >> a;
	cin >> b;
	cin >> c;
	try
	{
		Triangle* tr = new Triangle(a, b, c);
		cout << "\nTriangle area is: " << tr->TriangleArea() << endl;
	}
	catch (Triangle::SidetooLong& error)
	{
		cout << "Error: ";
		error.printMessage();
		return 1;
	}
	return 0;
}