// スクロール位置をLocalStrageに保存し、再現する
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
document.addEventListener('DOMContentLoaded', function() {
    positionYrank = localStorage.getItem(STORAGE_KEY_RANK);
    positionYpage = localStorage.getItem(STORAGE_KEY_PAGE);
    if(positionYrank !== null){pranking.scrollTo(0, positionYrank);}
    if(positionYpage !== null){scrollTo(0, positionYpage);}
    pranking.addEventListener("scroll", checkOffsetRank, false);
    window.addEventListener("scroll", checkOffsetPage, false);
})