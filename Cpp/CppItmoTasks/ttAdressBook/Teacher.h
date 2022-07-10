#pragma once
#include "Human.h"
#include <string>
using namespace std;
class teacher : public Human
{
	// ����������� ������ teacher
public:
	teacher(
		std::string last_name,
		std::string name,
		std::string second_name,
		// ���������� ������� ����� �� ������� � �������������
		unsigned int work_time
	) : Human(
		last_name,
		name,
		second_name
	) {
		this->work_time = work_time;
	}
	// ��������� ���������� ������� �����
	unsigned int get_work_time()
	{
		return this->work_time;
	}
	void get_full_name()
	{
		cout << "\n������������� ";
		Human::get_full_info();
	}
private:
	// ������� ����
	unsigned int work_time;
};

