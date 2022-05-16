class Ajax {
    constructor(token) {
        this.token = token;
    }

    selectAjax(api, myCallback) {
        const tomb = [];
        $.ajax({
            url: api,
            type: "GET",
            success: function (result) {
                result.forEach((element) => {
                    tomb.push(element);
                });
                myCallback(tomb);
            },
            error:function(data,textStatus,errorThrown){
                //console.log(result);
                console.log(data.responseJSON.message);
            },
        });
    }
    insertAjax(api, adat) {
        adat._token = this.token;
        $.ajax({
            headers: { X_CSRF_TOKEN: this.token },
            url: api,
            type: "POST",
            data: adat,
            success: function () {
                console.log("Sikeres adatfeltöltés");
            },
            error:function(data,textStatus,errorThrown){
                //console.log(result);
                console.log(data.responseJSON.message);
            },
        });
    }
    deleteAjax(api) {
        $.ajax({
            headers: { X_CSRF_TOKEN: this.token },
            url: api,
            type: "DELETE",
            success: function () {
                console.log("Sikeres törlés");
            },
            error: function (result) {
                console.log(result);
            },
        });
    }
    updateAjax(apivegpont, id, ujAdat){
        $.ajax({
            headers: { X_CSRF_TOKEN: this.token},
            url: apivegpont+"/"+id, 
            type: "PUT",
            data:ujAdat,
            success: function (result) {
                console.log(result);
            },
            error:function(data,textStatus,errorThrown){
                
                console.log(data.responseJSON.message);
            },
        });
    }
}
