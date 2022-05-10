from flask import Flask
import mysql.connector

app = Flask(__name__)


@app.route('/trains', methods=['GET', 'POST'])
def trains():
    try:
        cnx = mysql.connector.connect(user='Cony', password='***',
                                      host='Cony.mysql.pythonanywhere-services.com',
                                      database='Cony$trains')
    except:
        return 'Error opening connection'
    cursor = cnx.cursor()
    query = ("SELECT train_num, dep_date, dep_time, arr_date, arr_time FROM trains;")

    cursor.execute(query)

    str = '<table><tr><th>Train#</th><th>Departure date</th><th>Departure time</th><th>Arrival date</th><th>Arrival time</th></tr>'
    for (train_num, dep_date, dep_time, arr_date, arr_time) in cursor:
      str += f'<tr><td>{train_num}</td><td>{dep_date}</td><td>{dep_time}</td><td>{arr_date}</td><td>{arr_time}</td></tr>'

    cursor.close()
    str += '</table>'
    cnx.close()

    return str

@app.route('/main', methods=['GET', 'POST'])
def main():
    return "<a href='./trains'>Click this link</a>"

if __name__ == '__main__':
    app.run()
