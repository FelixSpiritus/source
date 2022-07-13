#include "Book.h"
#include <iostream>
void Book::ViewBook()
{
	cout << "ViewBook started" << endl;
	BookOut();
}
void Book::addRecord(Human* hum, int t)
{
	adressbook.push_back(humtoRec(hum, t));
}
int Book::getSize()
{
	return adressbook.size();
}
record Book::findrec(Human* hum, int t)
{
	iter = find(adressbook.begin(), adressbook.end(), humtoRec(hum, t));
	return(*iter);
}
void Book::delRecord(Human* hum, int t)
{
	iter = find(adressbook.begin(), adressbook.end(), humtoRec(hum, t));
	adressbook.erase(iter);
}
void Book::display(record r)
{
	cout << r.category << " " << r.last_name << " " << r.name
		<< " " << r.second_name << " tel: " << r.tel << endl;
}
string Book::stringdata(record r)
{
	ostringstream sdata;
	sdata << r.category << " " << r.last_name << " " << r.name
		<< " " << r.second_name << " tel: " << r.tel << endl;
	return sdata.str();
}

void Book::BookOut()
{
	iter = adressbook.begin();
	while (iter != adressbook.end())
		display(*iter++);
}
void Book::SaveBook()
{
	ofstream fout("book.txt");
	iter = adressbook.begin();
	while (iter != adressbook.end())
		fout << stringdata(*iter++);
	fout.close();
}
record Book::humtoRec(Human* hum, int t)
{
	record r;
	r.category = hum->GetCategory();
	r.last_name = hum->GetLastName();
	r.name = hum->GetName();
	r.second_name = hum->GetSecondName();
	r.tel = t;
	return r;
}
bool operator== (const record& r1, const record& r2)
{
	return (r1.category == r2.category && r1.last_name == r2.last_name &&
		r1.name == r2.name && r1.second_name == r2.second_name && r1.tel == r2.tel) ? true : false;
}
bool operator!= (const record& r1, const record& r2)
{
	return !(r1 == r2);
}
