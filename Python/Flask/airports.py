import flask
import mysql.connector

app = flask.Flask(__name__)


@app.route('/', methods=['GET', 'POST'])
def airports():
    cnx = mysql.connector.connect(user='Cony', password='***',
                                  host='Cony.mysql.pythonanywhere-services.com',
                                  database='Cony$flights')

    cursor = cnx.cursor()

    query = ("SELECT city, country, latitude, longitude FROM airports")

    cursor.execute(query)

    str = "<table><tr><th>city</th><th>country</th><th>latitude</th><th>longitude</th></tr>"
    for (city, country, latitude, longitude) in cursor:
      str += f'<tr><td>{city}</td><td>{country}</td><td>{latitude}</td><td>{longitude}</td></tr>'

    cursor.close()
    str += '</table>'
    cnx.close()

    return str

if __name__ == '__main__':
    app.run()
