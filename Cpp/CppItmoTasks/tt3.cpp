// перевод длины из класса Distance в метры и обратно 
#include <iostream>
#include <windows.h>
using namespace std;

class Point 
{
private:
	int x, y;
public:
	Point()
	{
		x = 0; y = 0;
	}
	Point(int x, int y)
	{
		this->x = x;
		this->y = y;
	}

	Point operator+ (Point) const;
	Point operator+= (Point);
	Point operator+ (int) const;

	
};

Point Point::operator+ (Point p2) const
{
	int a = x + p2.x;
	int b = y + p2.y;
	return Point(a, b);
}

Point Point::operator+= (Point p2)
{
	x += p2.x;
	y += p2.y;
	return Point(x, y);
}

Point Point::operator+ (int c) const
{
	int a = x + c;
	int b = y + c;
	return Point(a, b);
}


int main()
{
	Point pt1(1, 1), pt2(2, 2), pt3;
	pt3 = pt1 + pt2;
	pt2 += pt1;
	pt3 = pt1 + 5;
	return 0;
}
