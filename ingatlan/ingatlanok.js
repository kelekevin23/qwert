class Ingatlan {
    constructor(elem, adat) {
        this.elem = elem;
        this.adat = adat;

        this.kategoria = this.elem.children(".kategoria");
        this.leiras = this.elem.children(".leiras");
        this.datum = this.elem.children(".datum");
        this.teher = this.elem.children(".teher");
        this.fenykep = this.elem.children(".fenykep");
        this.torles = this.elem.children(".torles");
        this.modosit = this.elem.children(".modositas");

        this.modosit.on("click", () => {
            this.modositGomb();
        });

        this.torles.on("click", () => {
            this.torlesGomb();
        });

        this.adatBeallit(this.adat);
    }
    adatBeallit(adat) {
        this.kategoria.html(adat.kategoria.nev);
        this.leiras.html(adat.leiras);
        this.datum.html(adat.hirdetesDatuma);
        if (adat.tehermentes === 1) {
            this.teher.html("Igen");
        } else {
            this.teher.html("Nem");
        }
        this.fenykep.html(adat.kepUrl + ".jpg");
        this.torles.html("<button class=torleshez>Törlés</button>");
        this.modosit.html("<button class=modositashoz>Módosít</button>");


    }


    modositGomb() {
        console.log(this.adat);
        $("#leiras").val(this.adat.leiras);
        $("#jelenId").val(this.adat.id);
    }

    torlesGomb() {
        //console.log(this.adat);
        let esemeny = new CustomEvent("torol", {
            detail: this.adat.id,
        });
        window.dispatchEvent(esemeny);
    }
}
