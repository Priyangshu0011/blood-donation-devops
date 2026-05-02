const API_BASE = '/api';
const regForm = document.getElementById('registerForm');
const searchForm = document.getElementById('searchForm');
const regMsg = document.getElementById('registerMsg');
const searchMsg = document.getElementById('searchMsg');
const resultsContainer = document.getElementById('resultsContainer');
const donorList = document.getElementById('donorList');
function showMessage(element, isError, text) {
    element.textContent = text;
    element.className = `msg ${isError ? 'error' : 'success'}`;
    setTimeout(() => { element.classList.add('hidden'); }, 4000);
}
// Register Donor
regForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const donor = {
        name: document.getElementById('regName').value,
        bloodGroup: document.getElementById('regBloodGroup').value,
        city: document.getElementById('regCity').value
    };
    try {
        const response = await fetch(`${API_BASE}/donor`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(donor)
        });
        if (!response.ok) throw new Error('Failed to register');

        showMessage(regMsg, false, '🎉 Donor registered successfully!');
        regForm.reset();
    } catch (err) {
        showMessage(regMsg, true, '❌ Error registering donor. Is backend running?');
    }
});
// Search Donors
searchForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const bloodGroup = document.getElementById('searchBloodGroup').value;
    const city = document.getElementById('searchCity').value;
    try {
        const url = `${API_BASE}/match?blood=${encodeURIComponent(bloodGroup)}&city=${encodeURIComponent(city)}`;

        const response = await fetch(url);
        if (!response.ok) throw new Error('Failed to fetch');

        const donors = await response.json();

        donorList.innerHTML = '';
        if (donors.length === 0) {
            showMessage(searchMsg, true, 'No matching donors found in this city.');
            resultsContainer.classList.add('hidden');
        } else {
            donors.forEach(donor => {
                const li = document.createElement('li');
                li.innerHTML = `
                    <div class="donor-info">
                        <strong>${donor.name}</strong>
                        <span>📍 ${donor.city}</span>
                    </div>
                    <div class="blood-badge">${donor.bloodGroup}</div>
                `;
                donorList.appendChild(li);
            });
            resultsContainer.classList.remove('hidden');
            searchMsg.classList.add('hidden');
        }
    } catch (err) {
        showMessage(searchMsg, true, '❌ Error searching donors. Is backend running?');
        resultsContainer.classList.add('hidden');
    }
});
