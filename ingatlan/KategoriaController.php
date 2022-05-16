<?php

namespace App\Http\Controllers;

use App\Models\kategoriak;
use Illuminate\Http\Request;

class KategoriaController extends Controller
{

    //összes kategória lekérése
    //modell beimportálása
    public function index(){
        $kategoriak = response()->json(kategoriak::all());
        return $kategoriak;
    }
}
