# -*- coding: utf-8 -*-
"""
Created on Sun Apr  3 18:49:47 2022

@author: Dmitry
"""

def read_mskzip_all():
    i = 0
    header = []
    zip_codes = []
    zip_data = []
    skip_line = False
    # http://notebook.gaslampmedia.com/wp-content/uploads/2013/08/zip_codes_states.csv
    for line in open('zip_msk.csv').read().split("\n"):
        skip_line = False
        m = line.strip().split(";")
        i += 1
        if i == 1:
            for val in m:
                header.append(val)
        else:
            zip_data = []
            for idx in range(0, len(m)):
                if m[idx] == '':
                    skip_line = True
                    break
                if header[idx] == "PostalCode":
                    val=m[idx]
                    # print(val)
                    zip_data.insert(0,val)
                if header[idx] == "AdmArea":
                    val=m[idx]
                    zip_data.insert(3,val)
                if header[idx] == "District":
                    val=m[idx]
                    zip_data.insert(4,val)
                if header[idx] == "Address":
                    val=m[idx]
                    zip_data.insert(5,val)
                if header[idx] == "X_WGS84":
                    val = float(m[idx].replace(',', '.'))
                    zip_data.insert(1,val)
                if header[idx] == "Y_WGS84":
                    val = float(m[idx].replace(',', '.'))
                    zip_data.insert(2,val)
            if not skip_line:
                zip_codes.append(zip_data)
    return zip_codes
