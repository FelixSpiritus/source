#include <iostream>
#include<cmath>
using std::endl;
using std::cout;
using std::cin;
using std::string;

struct Point {
	double x;
	double y;
};

struct Triangle {
	Point p1;
	Point p2;
	Point p3;
};

struct Pentagon {
	Point p1;
	Point p2;
	Point p3;
	Point p4;
	Point p5;
};

struct TriangulatedPentagon {
	Triangle tr1;
	Triangle tr2;
	Triangle tr3;
};

TriangulatedPentagon Trinagulation(Pentagon pent) {
	TriangulatedPentagon trpent;
	trpent.tr1.p1 = pent.p1;
	trpent.tr1.p2 = pent.p2;
	trpent.tr1.p3 = pent.p5;
	trpent.tr2.p1 = pent.p2;
	trpent.tr2.p2 = pent.p3;
	trpent.tr2.p3 = pent.p4;
	trpent.tr3.p1 = pent.p4;
	trpent.tr3.p2 = pent.p5;
	trpent.tr3.p3 = pent.p2;
	return trpent;
};

double SideSize(Point p1, Point p2) {
	return sqrt(pow((p1.x - p2.x), 2) + pow((p1.y - p2.y), 2));
};

double TriangleArea(Triangle tr) {
	double a, b, c;
	a = SideSize(tr.p1, tr.p2);
	b = SideSize(tr.p2, tr.p3);
	c = SideSize(tr.p1, tr.p3);
	double p = 0.5 * (a + b + c);
	return sqrt(p * (p - a) * (p - b) * (p - c));
}

double PentagonArea(Pentagon pent) {
	TriangulatedPentagon trpent;
	trpent = Trinagulation(pent);
	return TriangleArea(trpent.tr1) + TriangleArea(trpent.tr2) + TriangleArea(trpent.tr3);
}



int main()
{
	Pentagon pent;
	pent.p1.x = 0; pent.p1.y = 0;
	pent.p2.x = 5; pent.p2.y = 100;
	pent.p3.x = 100; pent.p3.y = 100;
	pent.p4.x = 150; pent.p4.y = 50;
	pent.p5.x = 120; pent.p5.y = 5;
	cout << "\nPentagon area is: " << PentagonArea(pent) << endl;
	return 0;
};