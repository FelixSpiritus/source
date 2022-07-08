#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

class Point
{
private:
	double x;
	double y;
public:
	Point() : x(0.0), y(0.0) {};
	Point(double x, double y) : x(x), y(y) {};
	
	double CenterDistance(Point p) const
	{
		return sqrt(pow(p.x, 2) + pow(p.y, 2));
	}
	friend ostream& operator<< (ostream& out, const Point&);
	bool operator< (const Point& p) const;
};

int main()
{
	std::vector<Point> v;
	v.push_back(Point(1, 2));
	v.push_back(Point(10, 12));
	v.push_back(Point(21, 7));
	v.push_back(Point(4, 8));
	sort(v.begin(), v.end()); // требуется перегрузка оператора < для // класса Point
	for (auto& point : v)
		cout << point << '\n'; // требуется перегрузка оператора << для // класса Point
	return 0;
}

ostream& operator<< (ostream& out, const Point& p)
{
	out << "x = " << p.x << " y = " << p.y << endl;
	return out;
}

bool Point::operator< (const Point& p) const
{
	Point tp;
	tp.x = this->x;
	tp.y = this->y;
	if (CenterDistance(tp) < CenterDistance(p)) return true;
	else return false;
}