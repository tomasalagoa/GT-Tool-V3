from flask import session, Flask, jsonify, request, Response, render_template, render_template_string, url_for

@app.route('/', methods = ['GET'])
def sitemap():
    links = []
    for rule in app.url_map.iter_rules():
        print(rule)
        if ("GET" in rule.methods or "POST" in rule.methods) and has_no_empty_params(rule):
            if not 'static' in rule.endpoint:
                url = url_for(rule.endpoint, **(rule.defaults or {}))
                links.append((url, rule.endpoint, ','.join(rule.methods)))

    return render_template('index.html', urls = links)


@app.route('/register/user', methods = ['POST'])
def reg_customer():
    try:
        content = request.json
        if content:
            username = content['username']
            password = content['password']
            hash_pass = hashlib.md5(password).hexdigest()
            new_user = User(username, hash_pass)
            db.session.add(new_user)
            db.session.commit()
            user_created = 'User: {0} has been created'.format(username)
            return jsonify({'Created': user_created}),200
    except Exception as e:
        return jsonify({'Error': str(e.message)}),404

@app.route('/register/customer', methods = ['POST'])
def reg_user():
    try:
        content = request.json
        if content:
            username = content['username']
            password = content['password']
            first_name = content['first_name']
            last_name = content['last_name']
            email = content['email']
            ccn = content['ccn']
            cust = Customer(first_name, last_name, email, username, password, ccn)
            db.session.add(cust)
            db.session.commit()
            user_created = 'Customer: {0} has been created'.format(username)
            return jsonify({'Created': user_created}),200
    except Exception as e:
        return jsonify({'Error': str(e.message)}),404


@app.route('/login', methods = ['POST'])
def login():
    '''
    You will need to authenticate to this URI first. You will need to pass a JSON body with a username and password key.
    If you enter a valid username and password, a JWT token is returned in the HTTP Response in the Authorization header.
    This token can be used for subsequent requests.
    '''
    try:
        content = request.json
        print(content)
        username = content['username']
        password = content['password']
        auth_user = User.query.filter_by(username = username, password = password).first()
        if auth_user:
            auth_token = jwt.encode({'user': username, 'exp': get_exp_date(), 'nbf': datetime.datetime.utcnow(), 'iss': 'we45', 'iat': datetime.datetime.utcnow()}, app.config['SECRET_KEY_HMAC'], algorithm='HS256')
            resp = Response(json.dumps({'Authenticated': True, "User": username}))
            #resp.set_cookie('SESSIONID', auth_token)
            resp.headers['Authorization'] = "{0}".format(auth_token)
            resp.status_code = 200
            resp.mimetype = 'application/json'
            return resp
        else:
            return jsonify({'Error': 'No User here...'}),404
    except:
        return jsonify({'Error': 'Unable to recognize Input'}),404

@app.route('/fetch/customer', methods = ['POST'])
def fetch_customer():
    token = request.headers.get('Authorization')
    if not token:
        return jsonify({'Error': 'Not Authenticated!'}),403
    else:
        if not verify_jwt(token):
            return jsonify({'Error': 'Invalid Token'}),403
        else:
            content = request.json
            if content:
                customer_id = content['id']
                customer_record = Customer.query.get(customer_id)
                customer_dict = {'id': customer_record.id, 'firstname': customer_record.first_name,
                                 'lastname': customer_record.last_name, 'email': customer_record.email,
                                 'cc_num': customer_record.ccn, 'username': customer_record.username
                                }
                if customer_record:
                    return jsonify(customer_dict),200
                else:
                    return jsonify({'Error': 'No Customer Found'}),404
            else:
                return jsonify({'Error': 'Invalid Request'}),400


@app.route('/get/<cust_id>', methods = ['GET'])
def get_customer(cust_id):
    token = request.headers.get('Authorization')
    if not token:
        return jsonify({'Error': 'Not Authenticated!'}), 403
    else:
        if not insecure_verify(token):
            return jsonify({'Error': 'Invalid Token'}), 403
        else:
            if cust_id:
                customer_record = Customer.query.get(cust_id)
                if customer_record:
                    customer_dict = {'id': customer_record.id, 'firstname': customer_record.first_name,
                                 'lastname': customer_record.last_name, 'email': customer_record.email,
                                 'cc_num': customer_record.ccn, 'username': customer_record.username
                                }
                    return jsonify(customer_dict),200
                else:
                    return jsonify({'Error': 'No Customer Found'}),404
            else:
                return jsonify({'Error': 'Invalid Request'}),400




@app.route('/search', methods = ['POST'])
def search_customer():
    token = request.headers.get('Authorization')
    if not token:
        return jsonify({'Error': 'Not Authenticated!'}),403
    else:
        if not verify_jwt(token):
            return jsonify({'Error': 'Invalid Token'}),403
        else:
            content = request.json
            results = []
            if content:
                try:
                    search_term = content['search']
                    print(search_term)
                    str_query = "SELECT first_name, last_name, username FROM customer WHERE username = '%s';" % search_term
                    # mycust = Customer.query.filter_by(username = search_term).first()
                    # return jsonify({'Customer': mycust.username, 'First Name': mycust.first_name}),200

                    search_query = db.engine.execute(str_query)
                    for result in search_query:
                        results.append(list(result))
                    print(results)
                    return jsonify(results),200
                except Exception as e:
                    template = '''<html>
                        <head>
                        <title>Error</title>
                        </head>
                        <body>
                        <h1>Oops Error Occurred</h1>
                        <h3>%s</h3>
                        </body>
                        </html>
                        ''' % str(e)
                    return render_template_string(template, dir=dir, help=help, locals=locals), 404


@app.route("/xxe")
def index():
    return render_template(
        'test.html')


@app.route("/xxe_uploader", methods=['GET', 'POST'])  # /<string:name>/")
def hello():
    if request.method == 'POST':

        f = request.files['file']
        rand = random.randint(1, 100)
        fname = secure_filename(f.filename)
        fname = str(rand) + fname  # change file name
        cwd = os.getcwd()
        file_path = cwd + '/Files/' + fname
        f.save(file_path)  # save file locally

        # Access saved file
        document = Document(file_path)
        for para in document.paragraphs:
            print (para.text)  # '\n\n'.join([para.text for paragraph in document.paragraphs])

    # return "file uploaded successfully"
    return render_template('view.html', name=para.text)

@app.route("/yaml")
def yaml_upload():
    return render_template(
        'yaml_test.html')

@app.route("/yaml_hammer", methods = ['POST'])
def yaml_hammer():
    if request.method == "POST":
        f = request.files['file']
        rand = random.randint(1, 100)
        fname = secure_filename(f.filename)
        fname = str(rand) + fname  # change file name
        cwd = os.getcwd()
        file_path = cwd + '/Files/' + fname
        f.save(file_path)  # save file locally

        with open(file_path, 'r') as yfile:
            y = yfile.read()

        ydata = yaml.load(y)

    return render_template('view.html', name = json.dumps(ydata))