
dashboard();

function dashboard() {
    renderDashboardView();
}

function newCamp() {
    renderNewCampaignForm();
}

function editCamp(id) {
    renderEditCampaignForm(id);
}

async function removeCamp(id) {
    await fetch(`/api/remove/${id}`, {
        method: 'delete'
    });
    dashboard();
}