
const routes = {
    "/": renderDashboardView,
    "/new": renderNewCampaignForm,
    "/edit": renderEditCampaignForm
};

function navigate(path) {
    history.pushState({}, "", path);
    renderRoute(path);
}

function renderRoute(path) {
    const view = routes[path] || routes["/"];
    view();
}

document.addEventListener("DOMContentLoaded", () => {
    renderRoute(window.location.pathname);
});

window.addEventListener("popstate", () => {
    renderRoute(window.location.pathname);
});