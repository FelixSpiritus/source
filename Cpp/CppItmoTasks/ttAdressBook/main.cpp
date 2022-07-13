#include <iostream>
#include <vector>
#include "human.h"
#include "student.h"
#include "teacher.h"
#include "windows.h"
#include "book.h"
using namespace std;
int main()
{
	SetConsoleOutputCP(1251);
	SetConsoleCP(1251);
	std::vector<int> scores;
	
	scores.push_back(5);
	scores.push_back(3);
	scores.push_back(4);
	scores.push_back(4);
	scores.push_back(5);
	scores.push_back(3);
	scores.push_back(3);
	scores.push_back(3);
	scores.push_back(3);
	Human* stud = new Student("Петров", "Иван", "Алексеевич", scores);
	cout << stud->GetInfo() << endl;
	unsigned int teacher_work_time = 40;
	Human* tch = new Teacher("Сергеев", "Дмитрий", "Сергеевич", teacher_work_time);
	cout << tch->GetInfo() << endl;
	std::cout << endl;
	Book* book = new Book;
	book->addRecord(stud, 1256);
	book->addRecord(tch, 1234);
	book->BookOut();
	book->delRecord(stud, 1256);
	book->BookOut();
	delete stud;
	delete tch;
	delete book;
	return 0;
}