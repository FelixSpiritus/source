"""
    This is a utility module.

    To use this module, first import it:

    import util

    Use the read_zip_all() function to read the data
    on ZIP codes:

    zip_codes = util.read_zip_all()
    print(zip_codes[4108])

    Author: Konstantin Kuzmin
    Date: 2/19/2019

"""
import math
import logging
import logging.handlers

dialog = tuple()

def process_com(zipname):
    zip_codes = zipname

    command = ""
    while command != 'end':
        command = input(dialog[0])
        # logging.info(f'Received command {command}')
        logger.info(f'Received command {command}')
        print(command)
        command = command.strip().lower()
        if command == 'loc':
            process_loc(zip_codes)
        elif command == 'zip':
            process_zip(zip_codes)
        elif command == 'dist':
            process_dist(zip_codes)
        elif command != 'end':
            print(dialog[1])
        print()
    print(dialog[2])
    logging.shutdown()
    


def calculate_distance(location1, location2):
    """
    This function returns the great-circle distance between location1 and
    location2.

    Parameters:
    location1 (iterable): The geographic coordinates
    of the first location. The first element of the iterable is latitude,
    the second one is longitude.

    location2 (iterable): The geographic coordinates
    of the second location. The first element of the iterable is latitude,
    the second one is longitude.

    Returns:
    float: Value of the distance between two locations computed using
    the haversine formula
    """

    lat1 = math.radians(location1[0])
    lat2 = math.radians(location2[0])
    long1 = math.radians(location1[1])
    long2 = math.radians(location2[1])
    del_lat = (lat1 - lat2) / 2
    del_long = (long1 - long2) / 2
    angle = math.sin(del_lat)**2 + math.cos(lat1) * math.cos(lat2) * \
        math.sin(del_long)**2
    distance = 2 * 3959.191 * math.asin(math.sqrt(angle))
    return distance


def degree_minutes_seconds(location):
    minutes, degrees = math.modf(location)
    degrees = int(degrees)
    minutes *= 60
    seconds, minutes = math.modf(minutes)
    minutes = int(minutes)
    seconds = 60 * seconds
    return degrees, minutes, seconds


def format_location(location):
    ns = ""
    if location[0] < 0:
        ns = 'S'
    elif location[0] > 0:
        ns = 'N'

    ew = ""
    if location[1] < 0:
        ew = 'W'
    elif location[0] > 0:
        ew = 'E'

    format_string = '{:03d}\xb0{:0d}\'{:.2f}"'
    latdegree, latmin, latsecs = degree_minutes_seconds(abs(location[0]))
    latitude = format_string.format(latdegree, latmin, latsecs)
    longdegree, longmin, longsecs = degree_minutes_seconds(abs(location[1]))
    longitude = format_string.format(longdegree, longmin, longsecs)
    return '(' + latitude + ns + ',' + longitude + ew + ')'


def zip_by_location(codes, location):
    zips = []
    for code in codes:
        if location[0].lower() == code[3].lower() and \
           location[1].lower() == code[4].lower():
            zips.append(code[0])
    return zips


def location_by_zip(codes, zipcode):
    for code in codes:
        if code[0] == zipcode:
            return tuple(code[1:])
    return ()


def process_loc(codes):
    zipcode = input(dialog[3])
    print(zipcode)
    location = location_by_zip(codes, zipcode)
    if len(location) > 0:
        print(dialog[4].
              format(zipcode, location[2], location[3], location[4],
                     format_location((location[0], location[1]))))
    else:
        print(dialog[5])


def process_zip(codes):
    city = input(dialog[6])
    print(city)
    city = city.strip().title()
    state = input(dialog[7])
    print(state)
    state = state.strip().upper()
    zipcodes = zip_by_location(codes, (city, state))
    if len(zipcodes) > 0:
        print(dialog[8].format(city, state, ", ".join(zipcodes)))
    else:
        print(dialog[9].format(city, state))


def process_dist(codes):
    zip1 = input(dialog[10])
    print(zip1)
    # logging.info(f'Received the first ZIP {zip1}')
    logger.info(f'Received the first ZIP {zip1}')
    zip2 = input(dialog[11])
    print(zip2)
    # logging.info(f'Received the second ZIP {zip2}')
    logger.info(f'Received the second ZIP {zip2}')

    location1 = location_by_zip(codes, zip1)
    location2 = location_by_zip(codes, zip2)
    if len(location1) == 0 or len(location2) == 0:
        print(dialog[12].
              format(zip1, zip2))
    else:
        dist = calculate_distance(location1, location2)
        print(dialog[13].
              format(zip1, zip2, dist))
rfh = logging.handlers.RotatingFileHandler(
    filename='zip_app.log',
    mode='a',
    maxBytes=5*1024*1024,
    backupCount=9,
    encoding=None,
    delay=0
)
logging.basicConfig(format='%(asctime)s: %(name)s - %(levelname)s - %(message)s',
                    level=logging.INFO, datefmt="%y-%m-%d %H:%M:%S",
                    handlers=[rfh])
logger = logging.getLogger('main')        


