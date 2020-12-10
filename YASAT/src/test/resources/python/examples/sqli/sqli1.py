import MySQLdb


def execute_query(name):
        db = MySQLdb.connect()
        cur = db.cursor()
        cur.execute("SELECT * FROM platforms WHERE language = '%s';" % name)
        for row in cur.fetchall():
                print(row)

        db.close()
