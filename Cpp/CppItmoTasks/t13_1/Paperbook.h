#pragma once
#include "Item.h"
#include <iostream>
#include <string>
#include <windows.h>
class Paperbook : public Item
{
private:
	int pages;
public:
	void getdata()
	{
		Item::getdata();
		cout << "������� ����� ������� : ";
		cin >> pages;
	}
	void putdata()
	{
		Item::putdata();
		cout << "\n�������:" << pages;
	}
};

