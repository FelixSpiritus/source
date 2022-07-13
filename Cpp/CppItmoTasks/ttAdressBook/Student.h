#pragma once
#include "Human.h"
#include <string>
#include <vector>
#include <sstream>
#include <iostream>
using namespace std;

class Student : public Human
{
public:
	Student(string last_name, string name, string second_name,
		vector<int> scores) : Human(last_name, name, second_name)
	{
		this->scores = scores;
	}
	float get_average_score()
	{
		unsigned int count_scores = this->scores.size();
		unsigned int sum_scores = 0;
		float average_score;
		for (unsigned int i = 0; i < count_scores; ++i) {
			sum_scores += this->scores[i];
		}
		average_score = (float)sum_scores / (float)count_scores;
		return average_score;
	}
	string GetInfo()
	{
		ostringstream getinfo;
		getinfo << category << " " << GetLastName() << " "
			<< GetName() << " "
			<< GetSecondName() << " average score: " << get_average_score();
		return getinfo.str();
	 
	}

	string GetCategory()
	{
		return this->category;
	}

	
private:
	vector<int> scores;
	const string category = "student";
};

