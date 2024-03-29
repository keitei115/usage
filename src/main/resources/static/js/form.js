window.addEventListener('DOMContentLoaded', function () {
    $("#p1list").autocomplete({ source: function (request, response) { hiraSearch(request, response, pnamelist) } });
    $("#p2list").autocomplete({ source: function (request, response) { hiraSearch(request, response, pnamelist) } });
    $("#p3list").autocomplete({ source: function (request, response) { hiraSearch(request, response, pnamelist) } });
    $("#p4list").autocomplete({ source: function (request, response) { hiraSearch(request, response, pnamelist) } });
    $("#p5list").autocomplete({ source: function (request, response) { hiraSearch(request, response, pnamelist) } });
    $("#p6list").autocomplete({ source: function (request, response) { hiraSearch(request, response, pnamelist) } });

    $("#i1list").autocomplete({ source: function (request, response) { hiraSearch(request, response, inamelist) } });
    $("#i2list").autocomplete({ source: function (request, response) { hiraSearch(request, response, inamelist) } });
    $("#i3list").autocomplete({ source: function (request, response) { hiraSearch(request, response, inamelist) } });
    $("#i4list").autocomplete({ source: function (request, response) { hiraSearch(request, response, inamelist) } });
    $("#i5list").autocomplete({ source: function (request, response) { hiraSearch(request, response, inamelist) } });
    $("#i6list").autocomplete({ source: function (request, response) { hiraSearch(request, response, inamelist) } });

    $("#m1_1list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m1_2list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m1_3list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m1_4list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });

    $("#m2_1list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m2_2list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m2_3list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m2_4list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });

    $("#m3_1list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m3_2list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m3_3list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m3_4list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });

    $("#m4_1list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m4_2list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m4_3list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m4_4list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });

    $("#m5_1list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m5_2list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m5_3list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m5_4list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });

    $("#m6_1list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m6_2list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m6_3list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });
    $("#m6_4list").autocomplete({ source: function (request, response) { hiraSearch(request, response, mnamelist) } });

    $("#n1list").autocomplete({ source: nnamelist });
    $("#n2list").autocomplete({ source: nnamelist });
    $("#n3list").autocomplete({ source: nnamelist });
    $("#n4list").autocomplete({ source: nnamelist });
    $("#n5list").autocomplete({ source: nnamelist });
    $("#n6list").autocomplete({ source: nnamelist });
})

document.getElementById("a1list").addEventListener("focus", { name: ["p1list", "a1list"], handleEvent: getAbilityOption });
document.getElementById("a2list").addEventListener("focus", { name: ["p2list", "a2list"], handleEvent: getAbilityOption });
document.getElementById("a3list").addEventListener("focus", { name: ["p3list", "a3list"], handleEvent: getAbilityOption });
document.getElementById("a4list").addEventListener("focus", { name: ["p4list", "a4list"], handleEvent: getAbilityOption });
document.getElementById("a5list").addEventListener("focus", { name: ["p5list", "a5list"], handleEvent: getAbilityOption });
document.getElementById("a6list").addEventListener("focus", { name: ["p6list", "a6list"], handleEvent: getAbilityOption });

function getAbilityOption(e) {
    var abilist = abidict.filter(e => e.name == document.getElementById(this.name[0]).value)[0].ability;
    var select = document.getElementById(this.name[1]);
    for (i = select.length; i > 0; i--) { select.remove(i) }
    abilist.forEach((function (e) {
        var option = document.createElement("option")
        option.value = e;
        option.text = e;
        select.appendChild(option);
    }));
}

function hiraSearch(request, response, datalist) {
    var suggests = [];
    var regexp = new RegExp('(' + request.term + ')');
    $.each(datalist, function (i, values) {
        if (values[0].match(regexp) || values[1].match(regexp)) {
            suggests.push(values[0]);
        }
    });
    response(suggests);
}