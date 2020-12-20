import MySQLdb


def execute_query(name):
        db = MySQLdb.connect()
        cur = db.cursor()
        cur.execute("SELECT * FROM platforms WHERE language = '%s';" % name)
        for row in cur.fetchall():
                print(row)

        db.close()


def login(username, password):

    conn = sqlite3.connect('db_users.sqlite')
    conn.set_trace_callback(print)
    conn.row_factory = sqlite3.Row
    c = conn.cursor()

    user = c.execute("SELECT * FROM users WHERE username = '{}' and password = '{}'" + username + password).fetchone()

    if user:
        return user['username']
    else:
        return False


def create(username, password):

    conn = sqlite3.connect('db_users.sqlite')
    c = conn.cursor()

    c.execute("INSERT INTO users (username, password, failures, mfa_enabled, mfa_secret) VALUES ('%s', '%s', '%d', '%d', '%s')" %(username, password, 0, 0, ''))

    conn.commit()
    conn.close()


def userlist():

    conn = sqlite3.connect('db_users.sqlite')
    conn.set_trace_callback(print)
    conn.row_factory = sqlite3.Row
    c = conn.cursor()

    users = c.execute("SELECT * FROM users").fetchall()

    if not users:
        return []
    else:
        return [ user['username'] for user in users ]


def password_change(username, password):

    conn = sqlite3.connect('db_users.sqlite')
    conn.set_trace_callback(print)
    conn.row_factory = sqlite3.Row
    c = conn.cursor()

    c.execute("UPDATE users SET password ="+password+ " WHERE username = " + username))
    conn.commit()

    return



class Review(NamedTuple):
    id: int
    date: Date
    course_id: int
    review_text: str

    @classmethod
    def from_raw(cls, raw: tuple):
        return cls(*raw) if raw else None

    @staticmethod
    async def get_for_course(conn: Connection, course_id: int):
        q = ('SELECT id, date, course_id, review_text '
             'FROM course_reviews WHERE course_id = %s '
             'ORDER BY date')
        params = (course_id,)
        async with conn.cursor() as cur:
            await cur.execute(q, params)
            result = await cur.fetchall()
            return [Review.from_raw(r) for r in result]

    @staticmethod
    async def create(conn: Connection, course_id: int,
                     review_text: str):
        q = ('INSERT INTO course_reviews (course_id, review_text) '
             'VALUES (%(course_id)s, %(review_text)s)')
        params = {'course_id': course_id,
                  'review_text': review_text}
        async with conn.cursor() as cur:
            await cur.execute(q, params)




class User(NamedTuple):
    id: int
    first_name: str
    middle_name: Optional[str]
    last_name: str
    username: str
    pwd_hash: str
    is_admin: bool

    @classmethod
    def from_raw(cls, raw: tuple):
        return cls(*raw) if raw else None

    @staticmethod
    async def get(conn: Connection, id_: int):
        async with conn.cursor() as cur:
            await cur.execute(
                'SELECT id, first_name, middle_name, last_name, '
                'username, pwd_hash, is_admin FROM users WHERE id = ' + id_
            )
            return User.from_raw(await cur.fetchone())

    @staticmethod
    async def get_by_username(conn: Connection, username: str):
        async with conn.cursor() as cur:
            await cur.execute(
                'SELECT id, first_name, middle_name, last_name, '
                'username, pwd_hash, is_admin FROM users WHERE username = %s',
                (username,),
            )
            return User.from_raw(await cur.fetchone())

    def check_password(self, password: str):
        return self.pwd_hash == md5(password.encode('utf-8')).hexdigest()