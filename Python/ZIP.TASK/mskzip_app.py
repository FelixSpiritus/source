# -*- coding: utf-8 -*-
"""
Created on Sat Apr  2 23:24:13 2022

@author: Dmitry
"""
import util
import msk
import lang


if __name__ == "__main__":

    zipn = msk.read_mskzip_all()
    util.dialog=lang.rus()
    util.process_com(zipn)
  