from flask import Flask, render_template, request, url_for
from flask_paginate import Pagination, get_page_args
import sqlite3


app = Flask(__name__)

post = False
rows = []
zp = st = ct = str()
x = -94.551136
y = 39.125212
dist = int


def delfarm(idx):
    con = sqlite3.connect("farm.db")
    cur = con.cursor()
    cur.execute("DELETE FROM reviews WHERE farm_id in (?)", [idx])
    cur.execute("DELETE FROM farms WHERE id in (?)", [idx])
    con.commit()
    con.close()


def getfarminfo(idx):
    con = sqlite3.connect("farm.db")
    con.row_factory = sqlite3.Row
    cur = con.cursor()
    cur.execute("SELECT * FROM farms\
                 LEFT OUTER JOIN (SELECT farm_id, ROUND(AVG(rating),1) AVR FROM reviews GROUP BY farm_id) r\
                 ON farms.id=r.farm_id where id in (?)", [idx])
    finfo = cur.fetchone()
    con.close()
    return finfo

def getreviews(idx):
    con = sqlite3.connect("farm.db")
    con.row_factory = sqlite3.Row
    cur = con.cursor()
    cur.execute("select * from reviews where farm_id in (?)", [idx])
    rrows = cur.fetchall()
    con.close()
    return rrows


def getallrows(ordr):
    oder = getorder(ordr)
    con = sqlite3.connect("farm.db")
    con.row_factory = sqlite3.Row
    cur = con.cursor()
    cur.execute(f"SELECT * FROM mainview {oder}")
    rows = cur.fetchall()
    con.close()
    return rows


def getorder(orrd):
    if orrd == 0:
        oder = ''
    elif orrd == 1:
        oder = 'order by Zip asc'
    elif orrd == 2:
        oder = 'order by Zip desc'
    elif orrd == 3:
        oder = 'order by MarketName asc'
    elif orrd == 4:
        oder = 'order by MarketName desc'
    elif orrd == 5:
        oder = 'order by State asc'
    elif orrd == 6:
        oder = 'order by State desc'
    elif orrd == 7:
        oder = 'order by City asc'
    elif orrd == 8:
        oder = 'order by City desc'
    elif orrd == 9:
        oder = 'order by AVR asc'
    elif orrd == 10:
        oder = 'order by AVR desc'
    elif orrd == 11:
        oder = 'order by DISTANCE asc'
    elif orrd == 12:
        oder = 'order by DISTANCE desc'
    else:
        oder = ''
    return oder


def getselrows(zp, st, ct, ordr, dist):
    oder = getorder(ordr)
    con = sqlite3.connect("farm.db")
    con.row_factory = sqlite3.Row
    cur = con.cursor()
    if dist == '':
        dist = 10000
    else:
        dist = f"{dist}"
    if zp == '':
        zp = 'Zip'
    else:
        zp = f"'{zp}'"
    if st == '':
        st = 'State'
    else:
        st = f"'{st}'"
    if ct == '':
        ct = 'City'
    else:
        ct = f"'{ct}'"
    cur.execute(
        f"SELECT * FROM mainview where Zip = {zp} and lower(State) = lower({st}) and lower(City) = lower({ct}) and Distance <= {dist} {oder}")
    rows = cur.fetchall()
    con.close()
    return rows


def get_rows(offset=0, per_page=18):
    return rows[offset: offset + per_page]


@app.route('/reset')
def reset(ordr=3):
    global post, rows, zp, st, ct, dist, x, y
    post = False
    rows = []
    zp = st = ct = str()
    dist = int
    x = -94.551136
    y = 39.125212
    rows = getallrows(ordr)
    page = int(request.args.get('page', 1))
    per_page = 18
    offset = (page - 1) * per_page
    total = len(rows)
    pagination_rows = get_rows(offset=offset, per_page=per_page)
    pagination = Pagination(page=page, per_page=per_page, total=total, css_framework='bootstrap4')
    return render_template("index.html", rows=pagination_rows, page=page, per_page=per_page, pagination=pagination, x=x, y=y)


@app.route('/', methods=["POST", "GET"])
@app.route('/<int:ordr>', methods=["POST", "GET"])
def index(ordr=3):
    global x
    global y
    global dist
    global post
    global rows
    global zp, st, ct

    if request.method == "POST":
        post = True;
        dist = request.form["dist"]
        zp = request.form["zp"]
        st = request.form["st"]
        ct = request.form["ct"]
        rows = getselrows(zp, st, ct, ordr, dist)
        page = int(request.args.get('page', 1))
        per_page = 18
        offset = (page - 1) * per_page
        total = len(rows)
        pagination_rows = get_rows(offset=offset, per_page=per_page)
        pagination = Pagination(page=page, per_page=per_page, total=total, css_framework='bootstrap4')
        return render_template("index.html", rows=pagination_rows, page=page, per_page=per_page, pagination=pagination, x=x, y=y)

    else:
        if not post:
            rows = getallrows(ordr)
        elif post:
            rows = getselrows(zp, st, ct, ordr, dist)
        page = int(request.args.get('page', 1))
        per_page = 18
        offset = (page - 1) * per_page
        total = len(rows)
        pagination_rows = get_rows(offset=offset, per_page=per_page)
        pagination = Pagination(page=page, per_page=per_page, total=total, css_framework='bootstrap4')
        return render_template("index.html", rows=pagination_rows, page=page, per_page=per_page, pagination=pagination, x=x, y=y)


@app.route('/about/<int:idx>', methods=["POST", "GET"])
def about(idx):
    finfo = getfarminfo(idx)
    rrows = getreviews(idx)
    if request.method == "POST":
        fid = request.form['fid']
        rating = request.form['rating']
        fio = request.form['fio']
        comment = request.form['comment']
        con = sqlite3.connect("farm.db")
        con.row_factory = sqlite3.Row
        cur = con.cursor()
        cur.execute(f"INSERT INTO reviews(farm_id, Name, rating, rev) VALUES({fid}, '{fio}', {rating}, '{comment}')")
        con.commit()
        con.close()
        message = 'Your grade successfully added to database'
        finfo = getfarminfo(idx)
        rrows = getreviews(idx)
        return render_template("about.html", finfo=finfo, message=message, rrows=rrows)
    else:
        return render_template("about.html", finfo=finfo, rrows=rrows)


@app.route('/about/<int:idx>/del')
def deletemarket(idx):
    delfarm(idx)
    message = 'Market successfully deleted from database'
    return render_template("delete.html", message=message)


if __name__ == "__main__":
    app.run()
