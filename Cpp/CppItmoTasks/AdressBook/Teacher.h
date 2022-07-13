#pragma once
#include <string>
#include <sstream>
#include <iostream>
#include "Human.h"
class Teacher : public Human
{
public:
	Teacher(
		string last_name,
		string name,
		string second_name,
		unsigned int work_time)
		: Human(last_name, name, second_name)
	{
		this->work_time = work_time;
	}
	unsigned int get_work_time();
	string GetInfo();
	string GetCategory();
	void RunBookViewer(IViewer& book);
private:
	unsigned int work_time;
	const string category = "teacher";
};

