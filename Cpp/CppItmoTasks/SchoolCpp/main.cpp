#include <iostream>
#include <vector>
#include "human.h"
#include "student.h"
#include "teacher.h"
#include "windows.h"
using namespace std;
int main()
{
	SetConsoleOutputCP(1251);
	SetConsoleCP(1251);
	// ��������������
	std::vector<int> scores;
	// ���������� ������ �������� � ������
	scores.push_back(5);
	scores.push_back(3);
	scores.push_back(4);
	scores.push_back(4);
	scores.push_back(5);
	scores.push_back(3);
	scores.push_back(3);
	scores.push_back(3);
	scores.push_back(3);
	student* stud = new student("������", "����", "����������", scores);
	stud->get_full_name();
	std::cout << "������� ���� : " << stud->get_average_score() << std::endl;
	unsigned int teacher_work_time = 40;
	teacher* tch = new teacher("�������", "�������", "���������", teacher_work_time);
	tch->get_full_name();
	std::cout << "���������� �����: " << tch->get_work_time() << std::endl;
	std::cout << endl;
	human* hum1 = stud;
	hum1->get_full_name();
	human* hum2 = new human("������", "����", "���������");
	std::cout << endl;
	hum2->get_full_name();
	delete stud;
	delete tch;
	delete hum2;
	return 0;
}