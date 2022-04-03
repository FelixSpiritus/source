"""
This is a program to find location by ZIP code and ZIP code by location,
as well as to calculate the distance between to ZIP codes.

U.S. ZIP code is a five-digit integer number.
Location is given by the name of a city/town and a two-letter abbreviation
of the state.

Sample Execution:
-----------------

Command ('loc', 'zip', 'dist', 'end') => loc
loc

Enter a ZIP Code to lookup => 32963
32963
ZIP Code 32963 is in Vero Beach, FL, Indian River county,
coordinates: (027°41'23.23"N,080°22'32.61"W)


Command ('loc', 'zip', 'dist', 'end') => zip
zip

Enter a city name to lookup => Orlando
Orlando

Enter the state name to lookup => FL
FL
The following ZIP Code(s) found for Orlando, FL: 32801, 32802, 32803, 32804, 32805, 32806, 32807, 32808, 32809, 32810, 32811, 32812, 32814, 32815, 32816, 32817, 32818, 32819, 32820, 32821, 32822, 32824, 32825, 32826, 32827, 32828, 32829, 32830, 32831, 32832, 32833, 32834, 32835, 32836, 32837, 32839, 32853, 32854, 32855, 32856, 32857, 32858, 32859, 32860, 32861, 32862, 32867, 32868, 32869, 32872, 32877, 32878, 32886, 32887, 32890, 32891, 32893, 32897, 32898, 32899


Command ('loc', 'zip', 'dist', 'end') => dist
dist

Enter the first ZIP Code => 12180
12180

Enter the second ZIP Code => 32963
32963
The distance between 12180 and 32963 is 1102.72 miles


Command ('loc', 'zip', 'dist', 'end') => end
end

Done

Course: Python
Author(s): Konstantin Kuzmin
Date: 2/19/2019, modified 12/16/2021
"""

import util
import usa
import lang



if __name__ == "__main__":
    # logging.basicConfig(level=logging.DEBUG)
    zipn = usa.read_zip_all()
    util.dialog=lang.eng()
    util.process_com(zipn)
    
