active_tab = $("a.nav-active");
init_offset = active_tab.offset();
init_offset.top += active_tab.height()+2;
indicator = $("#nav-indicator");
indicator.offset(init_offset);
indicator.width(active_tab.width());

$("a.nav-item").hover(function(){
    nav_offset = $(this).offset();
    nav_offset.top += $(this).height()+2;

    indicator.offset(nav_offset);
    indicator.width($(this).width()-2);
}, function(){
    ori_offset = active_tab.offset();
    ori_offset.top += $(this).height()+2;
    indicator.offset(ori_offset);
    indicator.width(active_tab.width()-2);
});