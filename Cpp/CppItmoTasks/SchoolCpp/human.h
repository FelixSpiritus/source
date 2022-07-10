#include <string>
#include <sstream>
#include <iostream>
using namespace std;
#pragma once /* ������ �� �������� ����������� ������������� ����� */
class human {
public:
	// ����������� ������ human
	human(string last_name, string name, string second_name)
	{
		this->last_name = last_name;
		this->name = name;
		this->second_name = second_name;
	}
	// ��������� ��� ��������
	void get_full_name()
	{
		ostringstream full_name;
		full_name << this->last_name << " "
			<< this->name << " "
			<< this->second_name;
		cout << full_name.str() << endl;
	}
private:
	string name; // ���
	string last_name; // �������
	string second_name; // ��������
};