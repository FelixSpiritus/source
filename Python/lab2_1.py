# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

string1 = "This is a string."
string2 = " This is another string."
print(string1+string2)
print(len(string1))
string3=string1.strip('.')
print(string3+string2)
d="qwerty"
"""d[2]='o'"""
print(d[2])
print(d[0:])
a,b=3,7
print(b//a)
print(b%a)
print(b**a)
'''param = "string" + 15'''
n1 = input("Enter the first number: ")
n2 = input("Enter the second number: ")
n3 = float(n1) + float(n2)
print(n1 + " plus " + n2 + " = ", n3)
a = 1/3
print("{:7.3f}".format(a))
a = 2/3
b = 2/9
print("{:7.3f} {:7.3f}".format(a, b))
print("{:10.3e} {:10.3e}".format(a, b))
print(n1 + " plus " + n2 + " = " "{:7.3f}".format(n3))
