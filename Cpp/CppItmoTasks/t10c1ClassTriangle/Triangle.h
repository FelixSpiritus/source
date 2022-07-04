#pragma once
#include "Dot.h"
class Triangle
{
private:
	Dot p1;
	Dot p2;
	Dot p3;
public:
	Triangle();
	Triangle(Dot p1, Dot p2, Dot p3);
	void ShowSides();	
	double Perimetr();
	double Area();

};

