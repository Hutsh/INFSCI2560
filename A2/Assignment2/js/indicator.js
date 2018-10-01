active_tab = $("a.nav-active");
track = $("#nav-indicator-track");
init_offset = active_tab.offset();
init_offset.top = track.offset().top;
indicator = $("#nav-indicator");
indicator.offset(init_offset);
indicator.width(active_tab.width());
$("a.nav-item").hover(function(){
    nav_offset = $(this).offset();
    nav_offset.top = track.offset().top;

    indicator.offset(nav_offset);
    indicator.width($(this).width()-2);

    $(this).css("color","black");
}, function(){
    ori_offset = active_tab.offset();
    ori_offset.top = track.offset().top;
    indicator.offset(ori_offset);
    indicator.width(active_tab.width()-2);
    if( $(this).hasClass("nav-inactive")){
        $(this).css("color","#b7b7b7");
    }
});

function togglemenu() {
    $('#navbarNav').toggleClass('show');
}

//Pure Js version
//
// function getElementLeft(element){
//     var actualLeft = element.offsetLeft;
//     var current = element.offsetParent;
//     while (current !== null){
//         actualLeft += current.offsetLeft;
//         current = current.offsetParent;
//     }
//     return actualLeft;
// }
//
// function getElementTop(element){
//     var actualTop = element.offsetTop;
//     var current = element.offsetParent;
//     while (current !== null){
//         actualTop += current.offsetTop;
//         current = current.offsetParent;
//     }
//     return actualTop;
// }
//
//
// window.onload=function() {
//
//     active_tab = document.getElementById("nav-active");
//     track = document.getElementById("nav-indicator-track");
//     indicator = document.getElementById("nav-indicator");
//
//     ind_init = [getElementLeft(active_tab), getElementTop(track), active_tab.offsetWidth]; //left, top, width
//     console.log(ind_init);
//     indicator.style.width = toString(ind_init[2]) + "px";
//
// }
//
//
//
//
//











