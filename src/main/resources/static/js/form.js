
function renderNewCampaignForm() {
    const content = document.getElementById("content");
    content.innerHTML = `
    <header>
      <h2>Add new campaign</h2>
    </header>

    <form>
      <label for="camp-name">Name</label>
      <input type="text" id="camp-name" required/>

      <label for="camp-keywords">Keywords</label>
      <input type="text" id="camp-keywords" list="keywords-list" required/>
      <datalist id="keywords-list">
        <option value="clothes">
        <option value="furniture">
        <option value="cars">
        <option value="devices">
      </datalist>

      <label for="camp-amount">Amount</label>
      <input type="number" id="camp-amount" min="0" required/>

      <label for="camp-fund">Fund</label>
      <input type="number" id="camp-fund" min="0" required/>

      <div class="radio-group">
        <p>Status</p>

        <div class="radio-item">
          <label for="camp-status-on">On</label>
          <input type="radio" id="camp-status-on" name="camp-status" value="true" required/>
        </div>

        <div class="radio-item">
          <label for="camp-status-off">Off</label>
          <input type="radio" id="camp-status-off" name="camp-status" value="false"/>
        </div>
      </div>

      <label for="camp-town">Town</label>
      <select id="camp-town" required>
        <option value="cracow">Cracow</option>
        <option value="warsaw">Warsaw</option>
        <option value="wadowice">Wadowice</option>
        <option value="gdansk">Gdansk</option>
      </select>

      <label for="camp-radius">Radius</label>
      <input type="number" id="camp-radius" min="0"/>

      <button type="submit">Add</button>
    </form>
    `;
}

function renderEditCampaignForm() {
    const content = document.getElementById("content");
    content.innerHTML = `
   <header>
    <h2>Edit campaign</h2>
   </header>

  <form>
    <label for="camp-name">Name</label>
    <input type="text" id="camp-name" required/>

    <label for="camp-keywords">Keywords</label>
    <input type="text" id="camp-keywords" list="keywords-list" required/>
    <datalist id="keywords-list">
      <option value="clothes">
      <option value="furniture">
      <option value="cars">
      <option value="devices">
    </datalist>

    <label for="camp-amount">Amount</label>
    <input type="number" id="camp-amount" min="0" required/>

    <label for="camp-fund">Fund</label>
    <input type="number" id="camp-fund" min="0" required/>

    <div class="radio-group">
      <p>Status</p>

      <div class="radio-item">
        <label for="camp-status-on">On</label>
        <input type="radio" id="camp-status-on" name="camp-status" value="true" required/>
      </div>

      <div class="radio-item">
        <label for="camp-status-off">Off</label>
        <input type="radio" id="camp-status-off" name="camp-status" value="false"/>
      </div>
    </div>

    <label for="camp-town">Town</label>
    <select id="camp-town" required>
      <option value="cracow">Cracow</option>
      <option value="warsaw">Warsaw</option>
      <option value="wadowice">Wadowice</option>
      <option value="gdansk">Gdansk</option>
    </select>

    <label for="camp-radius">Radius</label>
    <input type="number" id="camp-radius" min="0"/>

    <button type="submit">Save</button>
  </form>
    `;
}