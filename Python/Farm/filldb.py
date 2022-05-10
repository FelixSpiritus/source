# -*- coding: utf-8 -*-
"""
Created on Sat Apr  9 17:50:03 2022

@author: Dmitry
"""
import sqlite3

con = sqlite3.connect("farm.db")
cur = con.cursor()
i = 0
header = []
zip_data = []
# http://notebook.gaslampmedia.com/wp-content/uploads/2013/08/zip_codes_states.csv
for line in open('Export.csv').read().split("\n"):
    skip_line = False
    m = line.strip().split("|")
    i += 1
    if i == 1:
        for val in m:
            header.append(val)
    else:
        zip_data = []
        zip_data.insert(0, i-1)
        for idx in range(0, len(m)):
            if header[idx] == "MarketName":
                val = m[idx]
                zip_data.insert(1, val)
                # print(zip_data[0])
            if header[idx] == "Website":
                val = m[idx]
                zip_data.insert(2, val)
                # print(zip_data[0], i)
            if header[idx] == "street":
                val = m[idx]
                zip_data.insert(3, val)
            if header[idx] == "city":
                val = m[idx]
                zip_data.insert(4, val)
            if header[idx] == "County":
                val = m[idx]
                zip_data.insert(5, val)
            if header[idx] == "State":
                val = m[idx]
                zip_data.insert(6, val)
            if header[idx] == "zip":
                val = m[idx]
                zip_data.insert(7, val)
            if header[idx] == "Season1Time":
                val = m[idx]
                zip_data.insert(8, val)
            if header[idx] == "x":
                if not m[idx] == '':
                    val = float(m[idx])
                    zip_data.insert(9, val)
                else:
                    val = m[idx]
                    zip_data.insert(9, val)
            if header[idx] == "y":
                if not m[idx] == '':
                    val = float(m[idx])
                    zip_data.insert(10, val)
                else:
                    val = m[idx]
                    zip_data.insert(10, val)
            if header[idx] == "Credit":
                val = m[idx]
                zip_data.insert(11, val)
            if header[idx] == "WIC":
                val = m[idx]
                zip_data.insert(12, val)
            if header[idx] == "WICcash":
                val = m[idx]
                zip_data.insert(13, val)
        print(zip_data)
        cur.execute("INSERT INTO farms VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", zip_data)
        con.commit()
con.close()
