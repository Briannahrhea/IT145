// import express library
const express = require('express');
// import body parser to parse JSON requests
const bodyParser = require('body-parser');
// import animal routes from the routes folder
const animalRoutes = require('./routes/animalRoutes');
// load login variables from .env file
require('dotenv').config();

// instance of express application and port for server
const app = express();
const PORT = 3000;

// parse JSON requests
app.use(bodyParser.json());
// use api animal routes
app.use('/api', animalRoutes);

// import path and static files
const path = require('path');
app.use(express.static(path.join(__dirname, 'public')));

// start server and listen on port
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
