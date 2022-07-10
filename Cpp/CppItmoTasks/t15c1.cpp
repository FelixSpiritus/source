#include <string>
#include <map> 
#include <iostream>
using namespace std;
struct StudentGrade
{
	string name;
	char grade;
};

void showMap(map<string, char> &gradeMap)
{
	for (auto i = gradeMap.begin(); i != gradeMap.end(); ++i)
	{
		cout << i->first << " : " << i->second << endl;
	}
}

void setGrade(map<string, char> &gradeMap)
{
	StudentGrade sg;
	cout << "Input student name: ";
	cin >> sg.name;
	cout << "\nInput student grade: ";
	cin >> sg.grade;
	gradeMap.insert(pair<string, char>(sg.name, sg.grade));
}

int main()
{
	map<string, char> gradeMap;
	int a = 1;
	while (a == 1)
	{
		setGrade(gradeMap);
		cout << "Another garde ('1' for 'yes', any other key for 'no')?: ";
		cin >> a;
	};
	showMap(gradeMap);
}