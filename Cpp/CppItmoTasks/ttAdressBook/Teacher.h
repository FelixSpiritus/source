#pragma once
#include "Human.h"
#include <string>
#include <sstream>
#include <iostream>
#include "Book.h"
#include "iBook.h"
using namespace std;
class Teacher : public Human
{
	
public:
	Teacher(
		string last_name,
		string name,
		string second_name,
		unsigned int work_time
	) : Human(
		last_name,
		name,
		second_name
	) {
		this->work_time = work_time;
	}
	unsigned int get_work_time()
	{
		return this->work_time;
	}
	string GetInfo()
	{
		ostringstream getinfo;
		getinfo << category << " " << GetLastName() << " "
			<< GetName() << " "
			<< GetSecondName() << " work time: " << get_work_time();
		return getinfo.str();
	}

	string GetCategory()
	{
		return this->category;
	}

	//void ShowBook(iBook& book)
	//{
	//	cout << "BookOut" << endl;
	//	//book.BookOut();
	//}
private:
	unsigned int work_time;
	const string category = "teacher";
};

