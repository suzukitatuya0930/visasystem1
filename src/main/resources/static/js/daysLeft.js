var expirationDateStr = document.getElementById("expirationDate").textContent;
var expirationDate = new Date(expirationDateStr);
var now = new Date();
var daysLeft = Math.round((expirationDate - now) / (1000 * 60 * 60 * 24));
document.getElementById("daysLeft").textContent = daysLeft + " days left";
