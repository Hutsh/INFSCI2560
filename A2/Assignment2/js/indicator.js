active_tab = $("a.nav-active");
track = $("#nav-indicator-track");
init_offset = active_tab.offset();
init_offset.top = track.offset().top;
indicator = $("#nav-indicator");
indicator.offset(init_offset);
indicator.width(active_tab.width());
$("a.nav-item").hover(function(){
    console.log("you");
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
