function do_auth(username, password) {
    var db = pgp(config.db.connectionString);

    var q = "SELECT * FROM users WHERE name = '" + username + "' AND password ='" + password + "';";

    return db.one(q);
}



function list_products() {

    var q = "SELECT * FROM products;";

    return db.many(q);
}

function getProduct(product_id) {

    var q = "SELECT * FROM products WHERE id = '" + product_id + "';";

    return db.one(q);
}

function search(query) {

    var q = "SELECT * FROM products WHERE name ILIKE '%" + query + "%' OR description ILIKE '%" + query + "%';";

    return db.many(q);

}

function purchase(cart) {

    var q = "INSERT INTO purchases(mail, product_name, user_name, product_id, address, phone, ship_date, price) VALUES('" +
        cart.mail + "', '" +
        cart.product_name + "', '" +
        cart.username + "', '" +
        cart.product_id + "', '" +
        cart.address + "', '" +
        cart.ship_date + "', '" +
        cart.phone + "', '" +
        cart.price +
        "');";

    return db.one(q);

}

function get_purcharsed(username) {

    var q = "SELECT * FROM purchases WHERE user_name = '" + username + "';";

    return db.many(q);

}




class UsersModel {

    findUserById(parameter) {
        return new Promise((resolve, reject) => {
            let query = "SELECT * FROM users WHERE id =" + parameter[0] + ";"
            executeQuery(query)
                .then((result) => { return resolve(result) })
                .catch((err) => { reject(err) });
        });
    }
    authenticateUser(parameter) {
        return new Promise((resolve, reject) => {
            let query = "SELECT * FROM users WHERE email ='" + parameter[0] + "' AND password = '" + parameter[1] + "'";
            executeQuery(query).then((result) => {
                resolve(result);
            }).catch((err) => {
                reject(err);
            });
        });
    }

    updateUserById(parameters) {
        let user = parameters[0];
        let id = parameters[1];
        return new Promise((resolve, reject) => {
            let query = queries.updateUserById;
            executeQueryWithParam(query, [user.fullname, user.username, user.email, user.phone, id]).then((result) => {
                resolve(result);
            }).catch((err) => {
                console.log("error : " + err);
                reject(err);
            });
        });
    }

    searchByName(parameters) {
        let username = parameters[0];
        return new Promise((resolve, reject) => {
            let query = "select id,username,email,fullname,phone from users where username like '%" + username + "%';";

            executeQuery(query).then((result) => {
                resolve(result);
            }).catch((err) => {
                console.log("error : " + err);
                reject(err);
            });
        });
    }

    registerUser(user) {
        user = user[0];
        return new Promise((resolve, reject) => {
            let query = queries.addUser;
            executeQueryWithParam(query, [user.fullname, user.username, user.email, user.phone, user.password]).then((result) => {
                resolve();
            }).catch((err) => {
                console.log("error : " + err);
                reject(err);
            });
        });
    }

    changePassword(params) {
        let password = params[0];
        let userId = params[1];
        return new Promise((resolve, reject) => {
            let query = queries.changePassword;
            executeQueryWithParam(query, [password, userId]).then((result) => {
                resolve();
            }).catch((err) => {
                console.log("error : " + err);
                reject(err);
            });
        });
    }

}
