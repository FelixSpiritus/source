#pragma once
#include <string>
#include <list>
#include "Student.h"
#include "Teacher.h"
#include <iostream>
#include "Human.h"
#include "iBook.h"
using namespace std;

struct record
{
	string category;
	string last_name;
	string name;
	string second_name;
	int tel;
};
class Book 
{
private:
	list <record> adressbook;
	list <record>::iterator iter;
public:

	void addRecord(Human* hum, int t)
	{
		adressbook.push_back(humtoRec(hum, t));
	}
	int getSize()
	{
		return adressbook.size();
	}

	record findrec(Human* hum, int t)
	{
		iter = find(adressbook.begin(), adressbook.end(), humtoRec(hum ,t));
		return(*iter);
	}
	
	void delRecord(Human* hum, int t)
	{
		iter = find(adressbook.begin(), adressbook.end(), humtoRec(hum, t));
		adressbook.erase(iter);
	}
	void display(record r)
	{
		cout << r.category << " " << r.last_name << " "<< r.name << " " << r.second_name << " tel: " << r.tel<<endl;
	}


	void BookOut()
	{
		iter = adressbook.begin();
		while (iter != adressbook.end())
			display(*iter++);
	}

	record humtoRec(Human* hum, int t)
	{
		record r;
		r.category = hum->GetCategory();
		r.last_name = hum->GetLastName();
		r.name = hum->GetName();
		r.second_name = hum->GetSecondName();
		r.tel = t;
		return r;
	}

	friend bool operator== (const record&, const record&);
	friend bool operator!= (const record&, const record&);
	

};

bool operator== (const record& r1, const record& r2)
{
	return (r1.category == r2.category && r1.last_name == r2.last_name && r1.name == r2.name && r1.second_name == r2.second_name && r1.tel == r2.tel) ? true : false;
}
bool operator!= (const record& r1, const record& r2)
{
	return !(r1 == r2);
}