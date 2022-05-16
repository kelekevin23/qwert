$(function () {
    const token = $('meta[name="csrf-token"]').attr("content");

    const ajaxhivas = new Ajax(token);
    ajaxhivas.selectAjax("/ingatlanVisszaad", adatfelvesz);
    ajaxhivas.selectAjax("/kategoriaVisszaad", selectFeltolt);

    function adatfelvesz(adatok) {
        const szuloElem = $(".tarolo");
        const sablonElem = $(".masolat");

        /*let elem = "";
        elem += "<div class=row><div class=col  d-flex justify-content-center p-3 border>Kategória</div>";
        elem += "<div class=col  d-flex justify-content-center p-3 border>Leírás</div>";
        elem += "<div class=col  d-flex justify-content-center p-3 border>Hirdetés dátuma</div>";
        elem += "<div class=col  d-flex justify-content-center p-3 border>Tehermentes</div>";
        elem += "<div class=col  d-flex justify-content-center p-3 border>Fénykép</div>";
        elem += "</div>";
        $(".tarolo").append(elem);*/

        adatok.forEach((element, index) => {
            let ujelem = sablonElem.clone().appendTo(szuloElem);
            const szakd = new Ingatlan(ujelem, element);
        });

        sablonElem.remove();
    }

    function selectFeltolt(adatok) {
        adatok.forEach((element, index) => {
            $("#kateg").append(
                "<option value=" + element.id + ">" + element.nev + "</option>"
            );
        });
    }

    var date = new Date();
    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    var today = year + "-" + month + "-" + day;
    $("#datum").attr("value", today);

    $(".kuldes").on("click", () => {
        let teher = 0;
        if ($("#teher").is(":checked")) {
            teher = 1;
        }

        const data = {
            kategoria: $("#kateg").val(),
            leiras: $("#leiras").val(),
            hirdetesDatuma: $("#datum").val(),
            tehermentes: teher,
            ar: 100000,
            kepUrl: $("#kep").val(),
        };

        
        ajaxhivas.insertAjax("/ingatlanUj", data);
        location.reload();
       //ajaxhivas.selectAjax("/ingatlanVisszaad", adatfelvesz);
    });

    $(".modositando").on("click", () => {
        let id = $("#jelenId").val();
        const data = {
            leiras: $("#leiras").val(),
        };

        ajaxhivas.updateAjax("/ingatlanModosit", id, data);
        location.reload();
    });
    $(window).on("torol", (event) => {
        //console.log(event.detail);
        ajaxhivas.deleteAjax("/ingatlanTorol/" + event.detail);
        location.reload();
    });
});
