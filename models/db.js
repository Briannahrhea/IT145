// Reference for Connection Pooling:
// https://medium.com/@havus.it/understanding-connection-pooling-for-mysql-28be6c9e2dc0

// mySQL package
const mysql = require('mysql2');
// load login variables from .env file
require('dotenv').config();

// connection pool for improved performance
const pool = mysql.createPool({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME
});

module.exports = pool.promise();
