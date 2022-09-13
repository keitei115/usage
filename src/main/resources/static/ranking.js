var positionYrank;
var positionYpage;
var STORAGE_KEY_RANK = "scrollYrank";
var STORAGE_KEY_PAGE = "scrollYpage";
function checkOffsetRank(){
    positionYrank = pranking.scrollTop;
    localStorage.setItem(STORAGE_KEY_RANK, positionYrank);
}
function checkOffsetPage(){
    positionYpage = window.pageYOffset;
    localStorage.setItem(STORAGE_KEY_PAGE, positionYpage);
}
function getToday(){
    var today = new Date();
    document.getElementById("d").value = today.toLocaleDateString("ja-JP",{year:"numeric",month:"2-digit",day:"2-digit"}).replace(/\//g,"-");
}
window.addEventListener('DOMContentLoaded', function() {
    positionYrank = localStorage.getItem(STORAGE_KEY_RANK);
    positionYpage = localStorage.getItem(STORAGE_KEY_PAGE);
    if(positionYrank !== null){pranking.scrollTo(0, positionYrank);}
    if(positionYpage !== null){scrollTo(0, positionYrank);}
    pranking.addEventListener("scroll", checkOffsetRank, false);
    window.addEventListener("scroll", checkOffsetPage, false);
    getToday();
})