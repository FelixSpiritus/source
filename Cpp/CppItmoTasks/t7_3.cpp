#include <iostream>
#include <windows.h>
using namespace std;

struct Distance
{
	int feet;
	double inches;
	void ShowDist()
	{
		cout << feet << "\'-" << inches << "\"\n";
	}
};

Distance AddDist(const Distance& d1, const Distance& d2)
{
	Distance d;
	d.feet = d1.feet + d2.feet;
	d.inches = d1.inches + d2.inches;
	if (d.inches >= 12.0)
	{
		d.inches -= 12.0;
		d.feet++;
	}
	return d;
}

Distance InputDist()
{
	Distance d;
	cout << "\nInput feet quantity : ";
	cin >> d.feet;
	cout << "\nInput inch quantity : ";
	cin >> d.inches;
	return d;
}



int main()
{
	int n;
	cout << "Input size of distance array ";
	cin >> n;
	Distance* masDist = new Distance[n];
	for (int i = 0; i < n; i++)
	{
		masDist[i] = InputDist();
	}
	for (int i = 0; i < n; i++)
	{
		masDist[i].ShowDist();
	}
	Distance d = masDist[0];
	for (int i = 1; i < n; i++)
	{		
		d = AddDist(d, masDist[i]);
	}
	d.ShowDist();
	delete[] masDist;
	return 0;
}