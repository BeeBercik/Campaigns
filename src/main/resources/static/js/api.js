
export async function getAllCampaigns() {
    const res = await fetch("/api/getAll");
    return await res.json();
}

export async function getCampaignById(id) {
    const res = await fetch("/api/getCampaign/" + id);
    return await res.json();
}

export async function createCampaign(data) {
    const res = await fetch("/api/new", {
        method: "POST",
        headers: { "content-type": "application/json" },
        body: JSON.stringify(data),
    });
    return res;
}

export async function updateCampaign(id, data) {
    const res = await fetch("/api/edit/" + id, {
        method: "PUT",
        headers: { "content-type": "application/json" },
        body: JSON.stringify(data),
    });
    return res;
}

export async function deleteCampaign(id) {
    const res = await fetch(`/api/remove/${id}`, {
        method: "DELETE",
    });
    return res;
}

export async function getBalance() {
    const res = await fetch("/api/balance");
    return await res.json();
}