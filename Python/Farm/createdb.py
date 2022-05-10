import sqlite3

con = sqlite3.connect("farm.db")
cur = con.cursor()
with con:
    cur.execute("""
                CREATE TABLE farms(id INT NOT NULL PRIMARY KEY,
                MarketName TEXT,
                WebSite TEXT,
                Street TEXT,
                City TEXT,
                Country TEXT,
                State TEXT,
                Zip TEXT,
                WorkTime TEXT,
                x FLOAT,
                y FLOAT,
                Credit TEXT,
                WIC TEXT,
                WICCash TEXT);
                """)

with con:
    cur.execute("""
                CREATE TABLE reviews(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                farm_id INT,
                Name TEXT,
                rating INT,
                rev TEXT,
                FOREIGN KEY(farm_id) REFERENCES farms(id)
                );
                """)

con.commit()
con.close()

