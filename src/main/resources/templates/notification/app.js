function handleButton(data) {
    change();
    document.getElementById("cumu-btn" + data).style.fontWeight = "600";
    document.getElementById("cumu-btn" + data).style.color = "#111111";
    document.getElementById("cumu-btn" + data).style.borderBottom =
        "2px solid #111111";
}

function change() {
    for (let i = 1; i <= 4; i++) {
        document.getElementById("cumu-btn" + i).style.borderBottom = "none";
        document.getElementById("cumu-btn" + i).style.color = "#d3d3d3";
    }
}