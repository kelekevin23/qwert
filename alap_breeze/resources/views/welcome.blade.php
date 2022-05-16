<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Token!!!!! -->
    <meta name="csrf-token" content=<?php $token = csrf_token(); echo $token; ?>>
    <title>Gyakorlás</title>


    <!-- bootstrap -->
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap" rel="stylesheet">

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    <!-- fájlok a public mappából, onnan kell kezdeni! -->
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/script.js"></script>
    <script src="js/ajax.js"></script>
    <script src="js/ingatlanok.js"></script>
    <link rel="stylesheet" href="css/index.css">
</head>

<body class="container container-fluid">
    <h1>Ajánlataink</h1>
    <div class="tarolo container">
        <div class="row">
            <div class="col-2  d-flex justify-content-center p-3 border">Kategória</div>
            <div class="col-2  d-flex justify-content-center p-3 border">Leírás</div>
            <div class="col-2  d-flex justify-content-center p-3 border">Hirdetés dátuma</div>
            <div class="col-2  d-flex justify-content-center p-3 border">Tehermentes</div>
            <div class="col-2  d-flex justify-content-center p-3 border">Fénykép</div>
            <div class="col-1  d-flex justify-content-center p-3 border"></div>
            <div class="col-1  d-flex justify-content-center p-3 border"></div>
        </div>

    </div>
    <div class="row masolat">
        <div class="col-2  d-flex justify-content-center p-3 border kategoria"></div>
        <div class="col-2  d-flex justify-content-center p-3 border leiras"></div>
        <div class="col-2  d-flex justify-content-center p-3 border datum"></div>
        <div class="col-2  d-flex justify-content-center p-3 border teher"></div>
        <div class="col-2  d-flex justify-content-center p-3 border fenykep"></div>
        <div class="col-1  d-flex justify-content-center p-3 border torles"></div>
        <div class="col-1  d-flex justify-content-center p-3 border modositas"></div>
    </div>
    <input type="hidden" id="jelenId" value="">
    <div class="form-control">
        <label for="kateg">Ingatlan kategóriája</label><br>
        <select name="kateg" id="kateg" class="w-50">
            <option value="valasztas">Kérem válasszon!</option>
        </select>

        <br><br>
        <label for="datum">Hirdetés dátuma</label><br>
        <input type="date" id="datum" name="datum" />

        <br><br>
        <label for="leiras">Ingatlan leírása</label><br>
        <textarea id="leiras" name="leiras" rows="4" cols="50"></textarea>

        <br><br>
        <input type="checkbox" name="teher" id="teher" />
        <label for="teher">Tehermentes</label>

        <br><br>
        <label for="kep">Fénykép az ingatlanról</label><br>
        <input type="text" name="kep" id="kep" />

        <br><br>
        <div class="btn btn-primary kuldes">Küldés</div>
        <div class="btn btn-danger m-3">Törlés</div>
        <div class="btn btn-info m-3">Info</div>
        <div class="btn btn-warning m-3 modositando">Módosítás</div>
    </div>
</body>

</html>