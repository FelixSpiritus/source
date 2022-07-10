#pragma once
#include <string>
#include <sstream>
#include <iostream>
using namespace std;

class Human {
public:
	Human(string last_name, string name, string second_name)
	{
		this->last_name = last_name;
		this->name = name;
		this->second_name = second_name;
	}
	virtual void get_full_info()
	{
		ostringstream full_info;
		full_info << this->last_name << " "
			<< this->name << " "
			<< this->second_name;
		cout << full_info.str() << endl;
	}
private:
	string name;
	string last_name;
	string second_name;
};
