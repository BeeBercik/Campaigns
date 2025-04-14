
function renderDashboardView() {
    const content = document.getElementById("content");
    content.innerHTML = `
  <header>
    <h2>Welcome on your campaign dashboard</h2>
  </header>

  <main>
    <div class="top-bar">
      <h3>Your campaigns</h3>
      <button onclick="newCamp('/new')" class="btn-new">Add new</button>
      <p id="account-balance"></p>
    </div>

    <div id="table-container">
      <table>
        <thead>
        <tr>
          <th>Name</th>
          <th>Town</th>
          <th>Bid amount</th>
          <th>Fund</th>
          <th>Radius</th>
          <th>Keywords</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody>
                <!--  generating with js -->
        </tbody>
      </table>
    </div>
  </main>
    `;
    loadCampaigns();
}

async function loadCampaigns() {
    const response = await fetch("/api/getAll");
    let campaigns = await response.json();

    for (const campaign of campaigns) {
        const tr = document.createElement("tr");

        tr.innerHTML = `<tr>
          <td>${campaign.name}</td>
          <td>${campaign.town}</td>
          <td>${campaign.amount},-</td>
          <td class="single-camp-fund">${campaign.fund},-</td>
          <td>${campaign.radius}km</td>
          <td>${campaign.keywords}</td>
          <td>${campaign.status ? "On" : "Off"}</td>
          <td class="actions">
            <button onclick="editCamp(${campaign.id})" class="btn-edit">Edit</button>
            <button onclick="removeCamp(${campaign.id})" class="btn-delete">Delete</button>
          </td></tr>`;

        document.querySelector("tbody").appendChild(tr);
    }
    updateBalance();
}

async function updateBalance() {
    const response = await  fetch("/api/balance");
    const balance = await response.json();
    document.getElementById("account-balance").innerHTML = `<b>Account balance: ${balance},-</b>`;
}


