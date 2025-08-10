// Resources used to better webpage interactivity/server communication:
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide
// https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch

// JavaScript for handling the form submissions and UI logic
  // Form and element references
  const form = document.getElementById('animalForm');
  const list = document.getElementById('animalList');
  const filterSpecies = document.getElementById('filterSpecies');
  const filterStatus = document.getElementById('filterStatus');

  // New animal submission
  form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = new FormData(form);
    const data = Object.fromEntries(formData);
    // New animals are not reserved by default
    data.reserved = false;
    const response = await fetch('/api/animals', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data)
    });
    const result = await response.json();
    // Confirmation of animal addition
    alert(result.message || 'Animal added');
    form.reset();
    // Refresh animal list upon submission
    loadAnimals();
  });

  // Load and filter animals from API
  async function loadAnimals() {
    const status = filterStatus.value;
    let url = '/api/animals';
    if (filterStatus.value) {
      url += `?status=${filterStatus.value}`;
    }
    const res = await fetch(url);
    const animals = await res.json();

    // Filter by species
    const filtered = filterSpecies.value
      ? animals.filter(a => a.species === filterSpecies.value)
      : animals;

    // Clear current list
    list.innerHTML = '';

    // Populate animal list
    filtered.forEach(a => {
      const li = document.createElement('li');
      li.className = 'list-group-item d-flex justify-content-between align-items-center';
      li.innerHTML = `
        <span>${a.name} (${a.breed}, ${a.species}, Age: ${a.age})</span>
        <div>
          ${
            a.reserved
              ? '<span class="badge bg-secondary me-2">Reserved</span>'
              : `<button class="btn btn-sm btn-success me-2" onclick="reserveAnimal(${a.id})">Reserve</button>`
          }
          <button class="btn btn-sm btn-warning me-2" onclick="showUpdateForm(${a.id}, '${a.trainingStatus}', '${a.inServiceCountry}')">Update</button>
          <button class="btn btn-sm btn-danger" onclick="deleteAnimal(${a.id})">Delete</button>
        </div>
      `;
      list.appendChild(li);
    });
  }

  // Mark an animal as reserved
  async function reserveAnimal(id) {
    const res = await fetch(`/api/animals/${id}/reserve`, { method: 'PUT' });
    const result = await res.json();
    alert(result.message || 'Animal reserved');
    loadAnimals();
  }

  // Delete an animal
  async function deleteAnimal(id) {
    if (!confirm('Are you sure you want to delete this animal?')) return;
    const res = await fetch(`/api/animals/${id}`, { method: 'DELETE' });
    const result = await res.json();
    alert(result.message || 'Animal deleted');
    loadAnimals();
  }

  // Show the update form with pre-filled data
  function showUpdateForm(id, trainingStatus, inServiceCountry) {
    document.getElementById('updateFormContainer').style.display = 'block';
    document.getElementById('updateId').value = id;
    document.getElementById('updateTraining').value = trainingStatus;
    document.getElementById('updateCountry').value = inServiceCountry;
  }

  // Hide the update form
  function hideUpdateForm() {
    document.getElementById('updateFormContainer').style.display = 'none';
  }

  // Animal update form submission
  document.getElementById('updateForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('updateId').value;
    const trainingStatus = document.getElementById('updateTraining').value;
    const inServiceCountry = document.getElementById('updateCountry').value;

    const res = await fetch(`/api/animals/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ trainingStatus, inServiceCountry })
    });
    const result = await res.json();
    alert(result.message || 'Animal updated');
    hideUpdateForm();
    loadAnimals();
  });

  // Initial load of animal list on page load
  // Debugging - Ensure loadAnimals runs when the page is ready
  document.addEventListener('DOMContentLoaded', () => {
    loadAnimals();
  });
