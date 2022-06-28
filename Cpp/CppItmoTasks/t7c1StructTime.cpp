#include <iostream>
#include <windows.h>
using namespace std;

struct Time
{
	int hours;
	int minutes;
	int seconds;
	void ShowTime()
	{
		cout << hours << "h " << minutes << "m " << seconds << "s \n";
	}
	int Timetosec()
	{
		return hours * 3600 + minutes * 60 + seconds;
	}
	Time Timefromsec(int s)
	{
		Time t;
		t.hours = s / 3600;
		t.minutes = (s % 3600) / 60;
		t.seconds = (s % 3600) % 60;
		return t;
	}
	Time SumTime(Time t)
	{
		return Timefromsec(Timetosec() + t.Timetosec());
	}
	Time DiffTime(Time t)
	{
		return Timefromsec(Timetosec() - t.Timetosec());
	}
};


Time InputTime()
{
	Time t;
	cout << "\nInput hours : ";
	cin >> t.hours;
	cout << "\nInput minutes : ";
	cin >> t.minutes;
	cout << "\nInput seconds : ";
	cin >> t.seconds;
	return t;
}



int main()
{
	Time t1 = InputTime();
	Time t2 = { 1, 6.25 };
	Time t3 = t1.SumTime (t2);
	Time t4 = t1.DiffTime(t2);
	t1.ShowTime();
	t2.ShowTime();
	t3.ShowTime();
	t4.ShowTime();
	return 0;
}