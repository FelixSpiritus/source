#pragma once
#include "Item.h"
#include <iostream>
#include <string>
#include <windows.h>
class Audiobook : public Item
{
private:
	double time;
public:
	void getdata()
	{
		Item::getdata();
		cout << "������� ����� �������� : ";
		cin >> time;
	}
	void putdata()
	{
		Item::putdata();
		cout << "\n����� �������� : " << time;
	}
};

