
function renderNewCampaignForm() {
    const content = document.getElementById("content");
    content.innerHTML = `
    <header>
      <h2>Add new campaign</h2>
    </header>

    <form id="new-camp-form">
      <label for="camp-name">Name</label>
      <input type="text" id="camp-name" name="name" required/>

      <label for="camp-keywords">Keywords</label>
      <input type="text" id="camp-keywords" name="keywords" list="keywords-list" required/>
      <datalist id="keywords-list">
        <option value="clothes">
        <option value="furniture">
        <option value="cars">
        <option value="devices">
      </datalist>

      <label for="camp-amount">Amount</label>
      <input type="number" id="camp-amount" name="amount" min="0" required/>

      <label for="camp-fund">Fund</label>
      <input type="number" id="camp-fund" name="fund" min="0" required/>

      <div class="radio-group">
        <p>Status</p>

        <div class="radio-item">
          <label for="camp-status-on">On</label>
          <input type="radio" id="camp-status-on" name="status" value="true" required/>
        </div>

        <div class="radio-item">
          <label for="camp-status-off">Off</label>
          <input type="radio" id="camp-status-off" name="status" value="false"/>
        </div>
      </div>

      <label for="camp-town">Town</label>
      <select id="camp-town" name="town" required>
        <option value="cracow">Cracow</option>
        <option value="warsaw">Warsaw</option>
        <option value="wadowice">Wadowice</option>
        <option value="gdansk">Gdansk</option>
      </select>

      <label for="camp-radius">Radius</label>
      <input type="number" id="camp-radius" name="radius" min="0"/>

      <button type="submit">Add</button>
      <button onclick="dashboard()" class="btn-cancel">Cancel</button>
    </form>
    `;

    document.getElementById("new-camp-form").addEventListener("submit", (e) => {
        e.preventDefault();
        sendFormData(e, "/new");
    });
}

function renderEditCampaignForm(id) {
    const content = document.getElementById("content");
    content.innerHTML = `
   <header>
    <h2>Edit campaign</h2>
   </header>

  <form id="edit-camp-form">
      <label for="camp-name">Name</label>
      <input type="text" id="camp-name" name="name" required/>

      <label for="camp-keywords">Keywords</label>
      <input type="text" id="camp-keywords" name="keywords" list="keywords-list" required/>
      <datalist id="keywords-list">
        <option value="clothes">
        <option value="furniture">
        <option value="cars">
        <option value="devices">
      </datalist>

      <label for="camp-amount">Amount</label>
      <input type="number" id="camp-amount" name="amount" min="0" required/>

      <label for="camp-fund">Fund</label>
      <input type="number" id="camp-fund" name="fund" min="0" required/>

      <div class="radio-group">
        <p>Status</p>

        <div class="radio-item">
          <label for="camp-status-on">On</label>
          <input type="radio" id="camp-status-on" name="status" value="true" required/>
        </div>

        <div class="radio-item">
          <label for="camp-status-off">Off</label>
          <input type="radio" id="camp-status-off" name="status" value="false"/>
        </div>
      </div>

      <label for="camp-town">Town</label>
      <select id="camp-town" name="town" required>
        <option value="cracow">Cracow</option>
        <option value="warsaw">Warsaw</option>
        <option value="wadowice">Wadowice</option>
        <option value="gdansk">Gdansk</option>
      </select>

      <label for="camp-radius">Radius</label>
      <input type="number" id="camp-radius" name="radius" min="0"/>

    <button type="submit">Save</button>
    <button onclick="dashboard()" class="btn-cancel">Cancel</button>
  </form>
    `;

    initializeFieldsToEdit(id);

    document.getElementById("edit-camp-form").addEventListener("submit", (e) => {
        e.preventDefault();
        sendFormData(e, `/edit/${id}`);
    });
}

async function initializeFieldsToEdit(id) {
    const response = await fetch("/api/getCampaign/" + id);
    const campaign = await response.json();

    document.getElementById("camp-name").value = campaign.name;
    document.getElementById("camp-keywords").value = campaign.keywords;
    document.getElementById("camp-amount").value = campaign.amount;
    document.getElementById("camp-fund").value = campaign.fund;
    document.getElementById("camp-radius").value = campaign.radius;
    document.getElementById("camp-town").value = campaign.town;

    if (campaign.status) document.getElementById("camp-status-on").checked = true;
    else document.getElementById("camp-status-off").checked = true;
}

async function sendFormData(e, endpoint) {
    const form = e.target;
    const formData = new FormData(form);
    const data = Object.fromEntries(formData.entries());

    const response = await fetch("/api" + endpoint, {
        method: endpoint === "/new" ? "POST" : "PUT",
        headers: { "content-type": "application/json" },
        body: JSON.stringify(data)
    });

    if(!response.ok) alert("Not enough money!");
    dashboard();
}