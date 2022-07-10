#pragma once
#include "human.h"
#include <string>
using namespace std;
class teacher : public human
{
	// ����������� ������ teacher
public:
	teacher(
		std::string last_name,
		std::string name,
		std::string second_name,
		// ���������� ������� ����� �� ������� � �������������
		unsigned int work_time
	) : human(
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
		human::get_full_name();
	}
private:
	// ������� ����
	unsigned int work_time;
};

