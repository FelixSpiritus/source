#pragma once
#include <string>
#include <sstream>
#include <iostream>
#include <vector>
#include "Human.h"
class Student :
    public Human
{
public:
	Student(string last_name,
		string name,
		string second_name,
		vector<int> scores)
		: Human(last_name, name, second_name)
	{
		this->scores = scores;
	}
	float get_average_score();
	string GetInfo();
	string GetCategory();
	void RunBookViewer(IViewer& book);
private:
	vector<int> scores;
	const string category = "student";
};

