#include "Triangle.h"
#include "Dot.h"
#include <math.h>
#include <iostream>
Triangle::Triangle()
{
	p1 = Dot();
	p2 = Dot();
	p3 = Dot();
}

Triangle::Triangle(Dot p1, Dot p2, Dot p3)
{
	this->p1 = p1;
	this->p2 = p2;
	this->p3 = p3;
}
 void Triangle::ShowSides()
{
	std::cout << "Triangle sides is: " << this->p1.distanceTo(this->p2) << " " << this->p2.distanceTo(this->p3) << " " << this->p3.distanceTo(this->p1) << std::endl;
}
double Triangle::Perimetr()
{
	return this->p1.distanceTo(this->p2) + this->p2.distanceTo(this->p3) + this->p3.distanceTo(this->p1);
}
double Triangle::Area()
{
	double a = this->p1.distanceTo(this->p2);
	double b = this->p2.distanceTo(this->p3);
	double c = this->p3.distanceTo(this->p1);
	double p = 0.5 * (a + b + c);
	return sqrt(p * (p - a) * (p - b) * (p - c));
}
