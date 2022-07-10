#include <string>
#include <sstream>
#include <iostream>
using namespace std;
#pragma once /* Защита от двойного подключения заголовочного файла */
class human {
public:
	// Конструктор класса human
	human(string last_name, string name, string second_name)
	{
		this->last_name = last_name;
		this->name = name;
		this->second_name = second_name;
	}
	// Получение ФИО человека
	void get_full_name()
	{
		ostringstream full_name;
		full_name << this->last_name << " "
			<< this->name << " "
			<< this->second_name;
		cout << full_name.str() << endl;
	}
private:
	string name; // имя
	string last_name; // фамилия
	string second_name; // отчество
};