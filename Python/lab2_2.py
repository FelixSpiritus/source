# -*- coding: utf-8 -*-
"""
Created on Wed Mar 30 02:47:51 2022

@author: Dmitry
"""

# list1 = [82,8,23,97,92,44,17,39,11,12]
# list1.insert(2,3)
# list1.append(145)
# list1[0]=23
# list1.remove(44)
# del list1[1]
# list1.pop()
# print(list1)
# list1.sort()
# print(list1)
# list1.sort(reverse=True)
# print(list1)
# list2 = [3,5,6,2,33,6,11]
# lis = sorted(list2)
# print(list2)
# print(lis)
# print(len(lis))
# print(help(list1.append))

# print(dir(tuple))
# print(help(tuple.count))
# print(help(tuple.index))
# seq = (2,8,23,97,92,44,17,39,11,12)
# print(seq.count(8))
# print(seq.index(44))
# listseq = list(seq)
# print(type(listseq))

# D = {'food': 'Apple', 'quantity': 4, 'color': 'Red'}
# print(D['food'])
# D['quantity']+=10
# print(D['quantity'])
# dp={}
# dp['name']=input('Enter your name:')
# dp['age']=input('Enter your age:')
# print('name is',dp['name'])
# print('age is',dp['age'])

rec = {'name': {'firstname': 'Bob', 'lastname': 'Smith'},'job': ['dev', 'mgr'],'age': 25}
print(rec['name']['firstname'],rec['name']['lastname'])
print(rec['name']['firstname'])
print(rec['job'])
rec['job'].append('janitor')
print(rec['name']['firstname'],rec['name']['lastname'],rec['job'],rec['age'])