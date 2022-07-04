#include "Triangle.h"
#include "Dot.h"
#include <iostream>
using namespace std;


int main()
{
	Triangle* tr1 = new Triangle(Dot(0, 0), Dot(0, 20), Dot(20, 0));	
	cout << "Triangle 1 area is: " << tr1->Area() << endl;
	cout << "Triangle 1 perimetr is: " << tr1->Perimetr() << endl;
	tr1->ShowSides();
	delete tr1;

	Dot* p1 = new Dot(0, 0);
	Dot* p2 = new Dot(0, 20);
	Dot* p3 = new Dot(20, 0);
	Triangle* tr2 = new Triangle(*p1, *p2, *p3);
	delete p1;
	delete p2;
	delete p3;
	cout << "Triangle 2 area is: " << tr2->Area() << endl;
	cout << "Triangle 2 perimetr is: " << tr2->Perimetr() << endl;
	tr2->ShowSides();
	delete tr2;
	return 0;
}