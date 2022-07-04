#include <iostream>
#include <windows.h>
using namespace std;

class Time
{
public:
	Time()
	{
		this->hours = 0;
		this->minutes = 0;
		this->seconds = 0;
	}
	Time(int h, int m, int s)
	{
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
	
	
private:
	int hours;
	int minutes;
	int seconds;
};




int main()
{
	Time* t1 = new Time(1, 3, 90);
	Time* t2 = new Time(0, 10, 45);
	Time* t3 = new Time();
	t3->AddTime(*t1,*t2);	
	t3->ShowTime();	
	delete t1;
	delete t2;
	delete t3;
	return 0;
}