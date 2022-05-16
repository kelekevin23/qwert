<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="csrf-token" content=<?php $token = csrf_token();
                                    echo $token; ?>>
    <title>Szakdolgozat2022</title>

    <!-- Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap">

    <!-- Styles -->
    <link rel="stylesheet" href="{{ asset('css/app.css') }}">


    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="{{ asset('js/app.js') }}" defer></script>

    <link rel="stylesheet" href="css/stilus.css">
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/ajax.js"></script>
    <script src="js/script.js"></script>
    <script src="js/szakdoga.js"></script>
</head>

<body class="antialiased">


    <main>

        <header>
            <h1 class="kozepre">Számalk-Szalézi technikum és Szakgimnázium 2020-2022 évfolyam szoftverfejlesztőinek
                szakdolgozatai</h1>
        </header>
        <section class="bejelentkezes kozepre">
            <h2>A szakdolgozatokat bejelentkezés után tudja megnézni!</h2>

            <div class=" px-6 py-4 sm:block">
                <a href="{{ url('/index') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Szakdolgozatok</a>
                <a href="/" class="aut" id="logout">Kijelentkezés
                    <form method="POST" action="logout">
                        <input type="hidden" name="_token">
                    </form>
                </a>
                <a href="{{ route('logout') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Kijelentkezés</a>
            </div>


        </section>
        <aside>
            <table>
                <tr class="tablazatSor">
                    <td class="cime"></td>
                    <td class="neve"></td>
                    <td class="link"></td>
                    <td class="eler"></td>
                    <td class="modositas"></td>
                    <td class="torol"></td>
                </tr>
            </table>
        </aside>

        <article class="tartalom">
            <table class="tablazat">

            </table>

            <div class="ujadat">
                <form>
                    <div style="display:none"><input type="text" id="id"></div>
                    <div class="sor"><label for="szakdoga_nev">Szakdolgozat címe</label><input type="text" id="szakdoga_nev"></div>
                    <div class="sor"><label for="tagokneve">Készítők neve</label><input type="text" id="tagokneve">
                    </div>
                    <div class="sor"><label for="oldallink">Az oldal elérhetősége </label><input type="text" id="oldallink">
                    </div>
                    <div class="sor"><label for="githublink"> GitHub elérhetőség</label><input type="text" id="githublink">
                    </div>
                    <div class="gomb">
                        <button id="uj">Új</button>
                        <button id="modosit" disabled>Módosít</button>
                    </div>
                </form>
            </div>
        </article>
        <footer class="kozepre">
            Laravel v{{ Illuminate\Foundation\Application::VERSION }} (PHP v{{ PHP_VERSION }})
        </footer>
    </main>
    </div>
    </div>
</body>

</html>