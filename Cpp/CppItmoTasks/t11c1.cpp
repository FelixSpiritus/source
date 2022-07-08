#include <iostream>
#include <windows.h>
using namespace std;

class Distance
{
private:
	int feet;
	float inches;
	const float MTF;
public:
	// конструктор по умолчанию
	Distance() : feet(0), inches(0.0), MTF(3.280833F) { }
	// конструктор с двум€ параметрами
	Distance(int ft, float in) : feet(ft), inches(in), MTF(3.280833F) { }
	Distance(float meters) : MTF(3.280833F)
	{
		float fltfeet = MTF * meters; // перевод в футы
		feet = int(fltfeet); // число полных футов
		inches = 12 * (fltfeet-feet); // остаток - это дюймы
	}
	operator float() const
	{
		float fracfeet = inches / 12;
		fracfeet += static_cast<float>(feet);
		return fracfeet / MTF;
	}
	void getdist()
	{
		cout << "\n¬ведите число футов : ";
		cin >> feet;
		cout << "\n¬ведите число дюймов : ";
		cin >> inches;
	}
	void showdist()
	{
		cout << feet << "\` - " << inches << "\"\n";
	}
	Distance operator+ (const Distance&) const;
	friend float operator+ (float f, const Distance&);
	Distance operator+ (const float&) const;
	friend ostream& operator<< (ostream& out, const Distance& dist);
};



int main()
{
	SetConsoleOutputCP(1251);
	SetConsoleCP(1251);
	/*Distance dist1, dist2, dist3, dist4;
	dist1.getdist();
	dist2.getdist();
	dist3.getdist();
	dist4.getdist();
	dist3 = dist1 + dist2;
	dist3.showdist();
	cout << "\ndist3 = " << dist3;
	dist4 = dist1 + dist2 + dist3;
	dist4.showdist();
	cout << "\ndist4 = " << dist4;*/
	Distance dist1 = 2.35F;
	Distance dist2 = 2.37F;
	float mtrs;
	mtrs = static_cast<float>(dist1);
	cout << dist1+0.02f << endl;
	cout << mtrs << endl;
	
	mtrs = dist2;
	cout << dist2 << endl;
	cout << mtrs << endl;


}

Distance Distance::operator+ (const float& df) const
{
	Distance d2 = df;
	int f = feet + d2.feet;
	float i = inches + d2.inches;
	if (i >= 12.0)
	{
		i -= 12.0;
		f++;
	}
	return Distance(f, i);
}

float operator+ (float f, const Distance& df)
{
	return f+ static_cast<float>(df);
}

Distance Distance::operator+ (const Distance& d2) const
{
	int f = feet + d2.feet;
	float i = inches + d2.inches;
	if (i >= 12.0)
	{
		i -= 12.0;
		f++;
	}
	return Distance(f, i);
}

ostream& operator<< (ostream& out, const Distance& dist)
{
	out << dist.feet << "\` - " << dist.inches << "\"\n";
	return out;
}