// function fadeOut(el) {
//     el.style.opacity = 1;
//
//     (function fade() {
//         if ((el.style.opacity -= .05) < 0) {
//             el.style.display = "none";
//         } else {
//             requestAnimationFrame(fade);
//         }
//     })();
// }
// function fadeIn(el, display){
//     el.style.opacity = 0;
//     el.style.display = display || "block";
//
//     (function fade() {
//         var val = parseFloat(el.style.opacity);
//         if (!((val += .05) > 1)) {
//             el.style.opacity = val;
//             requestAnimationFrame(fade);
//         }
//     })();
// }

function toggleButton(stat){
    butele = $("#button-c");
    if(stat === 0){
        console.log("toggle off ");
        if(!butele.hasClass('disabled')) {
            butele.attr("disabled", true);
            butele.addClass('disabled');
        }
    }else{
        console.log("toggle on");
        if(butele.hasClass('disabled')) {
            butele.attr("disabled", false);
            butele.removeClass('disabled');
        }
    }

}

function yyyymmdd() {
    var now = new Date();
    var y = now.getFullYear();
    var m = now.getMonth() + 1;
    var d = now.getDate();
    var mm = m < 10 ? '0' + m : m;
    var dd = d < 10 ? '0' + d : d;
    return '' + y + '-' + mm + '-' + dd;
}

function updateimg(){
    console.log(yyyymmdd());
    apiurl1 = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=";
    key = "4e223febd1051d6edac11a8ce2f42d36";
    apiurl2 = "&min_upload_date=";
    date = yyyymmdd();
    apiurl3 = "&sort=date-posted-desc&accuracy=1&safe_search=3&content_type=1&media=photos&extras=owner_name%2C+url_m%2C+date_taken%2C+description&per_page=10&format=json&nojsoncallback=1";
    apiurl = apiurl1 + key + apiurl2 + date + apiurl3;
    console.log(apiurl);
    var newurl="1";
    var img_show = new Image();
    var data_taken;
    var description;
    var index = 0;

    var previousowner = sessionStorage.getItem("owner");
    console.log("之前的owner:" + previousowner);

    $.ajax({
        url: apiurl,
        type:"get",
        success:function(data){
            dd = data;
            console.log(data);
            while(!data.photos.photo[index].url_m){ // when data no url
                index++;
                if(index >= 10) updateimg();
            }

            while(data.photos.photo[index].ownername === previousowner || data.photos.photo[index].ownername === "Medical Heritage Library, Inc."){ // ignore same photo
                index++;
                console.log("Same owner");
                if(index >= 10) break;
            }


            newurl = data.photos.photo[index].url_m;

            data_taken = data.photos.photo[index].datetaken;
            description = data.photos.photo[index].description._content;
            owner = data.photos.photo[index].ownername;
            window.sessionStorage.setItem("owner", owner);

            img_show.src = newurl;

            img_ele = $("#stream-img");
            triggerbutton = $("#button-c");

            if(description === ""){
                $("#des-div").remove();
            }else{
                $("#des-div").remove();
                var cardbody = $("<div class=\"card-body\"></div>");
                var cardtext = $("<p class=\"card-text\" id=\"img-des\">" + description + "</p>");
                var desdiv = cardbody.append(cardtext).attr('id', 'des-div');
                img_ele.after(desdiv);
            }
            if(img_show.complete) {
                toggleButton(0);
                img_ele.fadeOut(1000, function () {
                    img_ele.attr("src", newurl);
                }).fadeIn(1000, function () {
                    toggleButton(1);
                });

            }else{
                img_show.onload = function() {
                    toggleButton(0);
                    img_ele.fadeOut(1000, function() {
                        img_ele.attr("src",newurl);
                    }).fadeIn(1000, function () {
                        toggleButton(1);
                    });



                };

            }
            $("#img-user").text("By: " + owner);
            $("#img-time").text(data_taken);

        },
        error:function(){
            console.log("Error");
        }
    });


}


window.onload = function() {
    updateimg();
    $("#button-c").click(function () {
        toggleButton(0);
        updateimg();
        toggleButton(1);
    })
}

