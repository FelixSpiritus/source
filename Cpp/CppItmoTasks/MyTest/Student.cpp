#include "Student.h"
float Student::get_average_score()
{
	unsigned int count_scores = this->scores.size();
	unsigned int sum_scores = 0;
	float average_score;
	for (unsigned int i = 0; i < count_scores; ++i) {
		sum_scores += this->scores[i];
	}
	average_score = (float)sum_scores / (float)count_scores;
	return average_score;
}
string Student::GetInfo()
{
	ostringstream getinfo;
	getinfo << category << " " << GetLastName() << " "<< GetName()
		<< " "<< GetSecondName() << " average score: " << get_average_score();
	return getinfo.str();
}
string Student::GetCategory()
{
	return this->category;
}
void Student::RunBookViewer(IViewer& book)
{
	cout << "No access RunBookViewer, only for teachers" << endl;
}


