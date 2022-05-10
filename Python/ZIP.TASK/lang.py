# -*- coding: utf-8 -*-
"""
Created on Sun Apr  3 20:39:10 2022

@author: Dmitry
"""

def rus():
    ruslang = ("Команды ('loc', 'zip', 'dist', 'end') => ",
              'Неправильная команда',
              'Готово',
              'Введите индекс для поиска => ',
              'Индекс {} в {}, {}, {},\nкоординаты: {}',
              'Неверный или неизвестный индекс',
              'Введите название округа для поиска => ',
              'Ведите название района для поиска => ',
              'Данный индекс соответствует {}, {}: {}',
              'Отсутствуйт индекс для {}, {}',
              'Введите первый индекс => ',
              'Введите второй индекс => ',
              'Расстояние между {} и {} не может быть определено',
              'Расстояние между {} и {}  {:.2f} мили')
    return ruslang

def eng():
    enlang = ("Command ('loc', 'zip', 'dist', 'end') => ",
              'Invalid command, ignoring',
              'Done',
              'Enter a ZIP Code to lookup => ',
              'ZIP Code {} is in {}, {}, {} county,\ncoordinates: {}',
              'Invalid or unknown ZIP Code',
              'Enter a city name to lookup => ',
              'Enter the state name to lookup => ',
              'The following ZIP Code(s) found for {}, {}: {}',
              'No ZIP Code found for {}, {}',
              'Enter the first ZIP Code => ',
              'Enter the second ZIP Code => ',
              'The distance between {} and {} cannot be determined',
              'The distance between {} and {} is {:.2f} miles')
    return enlang

