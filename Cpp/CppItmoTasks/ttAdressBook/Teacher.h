#pragma once
#include "Human.h"
#include <string>
using namespace std;
class teacher : public Human
{
	// Конструктор класса teacher
public:
	teacher(
		std::string last_name,
		std::string name,
		std::string second_name,
		// Количество учебных часов за семестр у преподавателя
		unsigned int work_time
	) : Human(
		last_name,
		name,
		second_name
	) {
		this->work_time = work_time;
	}
	// Получение количества учебных часов
	unsigned int get_work_time()
	{
		return this->work_time;
	}
	void get_full_name()
	{
		cout << "\nПреподаватель ";
		Human::get_full_info();
	}
private:
	// Учебные часы
	unsigned int work_time;
};

