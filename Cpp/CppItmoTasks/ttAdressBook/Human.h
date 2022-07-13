#pragma once
#include <string>
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
	

	string GetName()
	{
		return this->name;
	}
	string GetLastName()
	{
		return this->last_name;
	}
	string GetSecondName()
	{
		return this->second_name;
	}
	
private:
	string name;
	string last_name;
	string second_name;
};
