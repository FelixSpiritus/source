#pragma once
#include <string>
#include "IViewer.h"
using namespace std;
class Human {
public:
	Human(string last_name, string name, string second_name)
	{
		this->last_name = last_name;
		this->name = name;
		this->second_name = second_name;
	}
	virtual string GetInfo() = 0;
	virtual string GetCategory() = 0;
	virtual void RunBookViewer(IViewer& book) = 0;
	string GetName();
	string GetLastName();
	string GetSecondName();
	
private:
	string name;
	string last_name;
	string second_name;
};
