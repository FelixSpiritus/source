#pragma once
#include <list>
#include <string>
#include <sstream>
#include <fstream>
#include "Human.h"
#include "IViewer.h"
struct record 
{
	string category;
	string last_name;
	string name;
	string second_name;
	int tel;
};
class Book : public IViewer
{
private:
	list <record> adressbook;
	list <record>::iterator iter;
public:
	void ViewBook();
	void addRecord(Human* hum, int t);
	int getSize();
	record findrec(Human* hum, int t);
	void delRecord(Human* hum, int t);
	void display(record r);
	string stringdata(record r);
	void BookOut();
	void SaveBook();
	record humtoRec(Human* hum, int t);
	friend bool operator== (const record&, const record&);
	friend bool operator!= (const record&, const record&);
};


