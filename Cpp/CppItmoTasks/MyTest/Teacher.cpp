#include "Teacher.h"
unsigned int Teacher::get_work_time()
{
	return this->work_time;
}
string Teacher::GetInfo()
{
	ostringstream getinfo;
	getinfo << category << " " << GetLastName() << " "
		<< GetName() << " "
		<< GetSecondName() << " work time: " << get_work_time();
	return getinfo.str();
}
string Teacher::GetCategory()
{
	return this->category;
}
void Teacher::RunBookViewer(IViewer& book)
{
	cout << "RunBookViewer" << endl;
	book.ViewBook();
}
