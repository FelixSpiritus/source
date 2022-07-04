#include <iostream>
#include <tuple>
using namespace std;
class Dot
{
private:
	int x;
	
public:
	Dot()
	{
		x = 0;
	}
	Dot(int x)
	{
		this-> x = x;
	}
};
class Line
{
private:
	Dot p1;
	Dot p2;
public:
	Line(Dot p1, Dot p2)
	{
		this->p1 = p1;
		this->p2 = p2;
	}
	void ShowLine()
	{
		cout << this->p1 << " "<< this->p2 << endl;
	}
};


int main()
{
	Dot* p1 = new Dot(2);
	cout << &p1 << endl;
	cout << p1 << endl;
	Dot* p2 = new Dot(4);
	Line* ln = new Line(*p1, *p2);
	delete p1;
	delete p2;
	delete ln;

}

