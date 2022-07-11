#include <iostream>
#include <windows.h>
using namespace std;

class Time
{
public:
	class ExScore
	{
	public:
		string origin;
		int ehours;
		int eminutes;
		int eseconds;
		ExScore(string org, int h, int m, int s)
		{
			origin = org;
			ehours = h;
			eminutes = m;
			eseconds = s;
		}		
	};
	Time()
	{
		this->hours = 0;
		this->minutes = 0;
		this->seconds = 0;
	}
	Time(int h, int m, int s)
	{
		if (h < 0 || m < 0 || s < 0 || m > 59 || s > 59) throw ExScore("constructor invalid input time: ", h,m,s);
		this->hours = h;
		this->minutes = m;
		this->seconds = s;
		if (h < 0 || m < 0 || s < 0 || m > 59 || s > 59) CorrectTime();
	}

	void ShowTime() const
	{
		cout << this->hours << ":" << this->minutes << ":" << this->seconds << endl;
	}

	void CorrectTime()
	{
		int s = this->hours * 3600 + this->minutes * 60 + this->seconds;
		this->hours = s / 3600;
		this->minutes = (s % 3600) / 60;
		this->seconds = (s % 3600) % 60;
	}

	void AddTime(Time t1, Time t2)
	{
		this->hours = t1.hours + t2.hours;
		this->minutes = t1.minutes + t2.minutes;
		this->seconds = t1.seconds + t2.seconds;
		CorrectTime();
	}

	Time operator+ (const Time&) const;
	Time operator- (const Time&) const;
	Time operator+ (double&) const;
	friend Time operator+ (double&, const Time&);
	bool operator> (const Time&) const;


private:
	int hours;
	int minutes;
	int seconds;
};




int main()
{
	try
	{
	Time t1 = Time(0, 10, 45);
	Time t2 = Time(0, 20, 5);
	Time t4 = t1 - t2;
	Time t3 = t1 + t2;
	t3.ShowTime();
	double a = 60.225;
	t3 = t1 + a;
	t3.ShowTime();
	t3 = a + t1;
	t3.ShowTime();
	if (t2 > t1) cout << "TRUE" << endl;
	else cout << "FALSE" << endl;
	}
	catch (Time::ExScore& ex)
	{
		cout << "\nError " << ex.origin << "  " << ex.ehours << ":" << ex.eminutes << ":" << ex.eseconds <<endl;
	}
	return 0;
}

Time Time::operator+ (const Time& t2) const
{
	Time tmp;
	tmp.hours = this->hours + t2.hours;
	tmp.minutes = this->minutes + t2.minutes;
	tmp.seconds = this->seconds + t2.seconds;
	tmp.CorrectTime();
	return tmp;
}

Time Time::operator- (const Time& t2) const
{
	Time tmp;	
	tmp.hours = this->hours - t2.hours;
	tmp.minutes = this->minutes - t2.minutes;
	tmp.seconds = this->seconds - t2.seconds;
	tmp.CorrectTime();
	if (Time()>tmp) throw ExScore("operator- invalid output time: ", tmp.hours, tmp.minutes, tmp.seconds);
	return tmp;
}

Time Time::operator+ (double& dt) const
{
	Time tmp;
	int s = static_cast<int>(dt);
	tmp.hours = s / 3600 + this->hours;
	tmp.minutes = (s % 3600) / 60 + this->minutes;
	tmp.seconds = (s % 3600) % 60 + this->seconds;
	tmp.CorrectTime();

	return tmp;
}

Time operator+ (double& dt, const Time& t)
{
	Time tmp;
	int s = static_cast<int>(dt);
	tmp.hours = s / 3600 + t.hours;
	tmp.minutes = (s % 3600) / 60 + t.minutes;
	tmp.seconds = (s % 3600) % 60 + t.seconds;
	tmp.CorrectTime();
	return tmp;
}

bool Time::operator> (const Time& t) const
{
	int s1 = this->hours * 3600 + this->minutes * 60 + this->seconds;
	int s2 = t.hours * 3600 + t.minutes * 60 + t.seconds;
	if (s1 > s2) return true;
	else return false;
}