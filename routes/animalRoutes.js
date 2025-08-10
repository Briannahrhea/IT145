// import express
const express = require('express');
// create router object
const router = express.Router();
// importing animal controller
const animalController = require('../controllers/animalController');

// routes to add, reserve, view, update, and delete animals
router.get('/animals', animalController.getAnimals);
router.post('/animals', animalController.addAnimal);
router.put('/animals/:id/reserve', animalController.reserveAnimal);
router.put('/animals/:id', animalController.updateAnimal);
router.delete('/animals/:id', animalController.deleteAnimal);

module.exports = router;
