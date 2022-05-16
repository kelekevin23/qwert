<?php

use App\Http\Controllers\IngatlanokController;
use App\Http\Controllers\KategoriaController;
use Illuminate\Support\Facades\Route;


/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});


//Controllerek beimportálása
//'index' az a név ami KategoriaController-ben szereplő metódus neve
Route::get('/kategoriaVisszaad', [KategoriaController::class, 'index']);


Route::get('/ingatlanVisszaad', [IngatlanokController::class, 'adatok']);
Route::post('/ingatlanUj', [IngatlanokController::class, 'ujadat']);

//paraméteresnél {} ben van a változó
Route::put('/ingatlanModosit/{id}', [IngatlanokController::class, 'modosit']);
Route::delete('/ingatlanTorol/{id}', [IngatlanokController::class, 'torles']);



Route::get('/dashboard', function () {
    return view('dashboard');
})->middleware(['auth'])->name('dashboard');

require __DIR__.'/auth.php';
