
function renderDashboardView() {
    const content = document.getElementById("content");
    content.innerHTML = `
  <header>
    <h2>Welcome on your campaign dashboard</h2>
  </header>

  <main>
    <div class="top-bar">
      <h3>Your campaigns</h3>
      <button onclick="navigate('/new')">Add new</button>
    </div>

    <div id="table-container">
      <table>
        <thead>
        <tr>
          <th>Name</th>
          <th>Keywords</th>
          <th>Status</th>
          <th>Town</th>
          <th>Bid</th>
          <th>Fund</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>row</td>
          <td>row</td>
          <td>row</td>
          <td>row</td>
          <td>row</td>
          <td>row</td>
          <td class="actions">
            <button onclick="navigate('/edit')">Edit</button>
            <button>Delete</button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </main>
    `;
    loadCampaigns();
}

async function loadCampaigns() {
    const response = await fetch("/api/getAll");
    console.log(await response.json());
}