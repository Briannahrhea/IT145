// Importing database connection
const db = require('../models/db');

// Using HTTP methods, tested using POSTMAN:
// GET animals - fetches animals, filtered by reservation status
exports.getAnimals = async (req, res) => {
    const status = req.query.status;
    let query = 'SELECT * FROM rescue_animals';
    const values = [];

    // Return query based on reservation status
    if (status === 'available') {
        query += ' WHERE reserved = FALSE';
    }
    else if (status === 'reserved') {
        query += ' WHERE reserved = TRUE';
    }

    console.log(`[GET] /api/animals - Query: ${query}`);

    // Executing the query
    try {
        const [rows] = await db.query(query, values);
        console.log(`[DB] Returned ${rows.length} rows`);
        res.json(rows);
    }
    catch (err) {
        console.error('[DB ERROR]', err);
        res.status(500).json({ error: err.message });
    }
};

// POST animals - adding new animal to database
exports.addAnimal = async (req, res) => {
    // Get animal data
    const animal = req.body;
    try {
        await db.query(
            `INSERT INTO rescue_animals 
            (name, breed, species, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)`,
            [animal.name, animal.breed, animal.species, animal.gender, animal.age, animal.weight, animal.acquisitionDate, animal.acquisitionCountry, animal.trainingStatus, false, animal.inServiceCountry]
        );
        res.status(201).json({ message: "Animal added successfully." });
    }
    catch (err) {
        res.status(500).json({ error: err.message });
    }
};

// PUT animals - marks animals as reserved status
exports.reserveAnimal = async (req, res) => {
    const id = req.params.id;
    try {
        await db.query('UPDATE rescue_animals SET reserved = TRUE WHERE id = ?', [id]);
        res.json({ message: "Animal reserved successfully." });
    }
    catch (err) {
        res.status(500).json({ error: err.message });
    }
};

// DELETE animals - deletes animal from database by ID
exports.deleteAnimal = async (req, res) => {
    const id = req.params.id;
    try {
        await db.query('DELETE FROM rescue_animals WHERE id = ?', [id]);
        res.json({ message: 'Animal deleted successfully.' });
    }
    catch (err) {
        res.status(500).json({ error: err.message });
    }
};

// PUT animals - updates animal training status and in-service country
exports.updateAnimal = async (req, res) => {
    const id = req.params.id;
    const { trainingStatus, inServiceCountry } = req.body;
    try {
        await db.query(
            `UPDATE rescue_animals SET trainingStatus = ?, inServiceCountry = ? WHERE id = ?`,
            [trainingStatus, inServiceCountry, id]
        );
        res.json({ message: 'Animal updated successfully.' });
    }
    catch (err) {
        res.status(500).json({ error: err.message });
    }
};

