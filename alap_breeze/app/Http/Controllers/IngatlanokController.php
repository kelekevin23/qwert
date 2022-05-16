<?php

namespace App\Http\Controllers;

use App\Models\ingatlanok;
use Illuminate\Http\Request;

class IngatlanokController extends Controller
{
    
    //modell beimportálása

    //összetett lekérdezés --> azt a nevet kell megadni a with-ben ami a modell metódusának neve
    public function adatok(){
        $adatok = response()->json(ingatlanok::with('kategoria')->get());
        return $adatok;
    }

    //összes kategória lekérése
    public function index(){
        $ingatlanok = response()->json(ingatlanok::all());
        return $ingatlanok;
    }
    
    //$request --> átvett adathalmaz a script.js-ből
    public function ujadat(Request $request){
        $ujadat = new ingatlanok();
        $ujadat->kategoria = $request->kategoria;
        $ujadat->hirdetesDatuma = $request->hirdetesDatuma;
        $ujadat->leiras = $request->leiras;
        $ujadat->tehermentes = $request->tehermentes;
        $ujadat->ar = $request->ar;
        $ujadat->kepUrl = $request->kepUrl;
        $ujadat->save(); //save
        
    }
    
    public function modosit(Request $request, $id) {
        $ingatlan = ingatlanok::find($id); //keresés
       /* $ingatlan->kategoria = $request->kategoria;
        $ingatlan->hirdetesDatuma = $request->hirdetesDatuma;
        $ingatlan->tehermentes = $request->tehermentes;
        $ingatlan->ar = $request->ar;
        $ingatlan->kepUrl = $request->kepUrl;*/
        $ingatlan->leiras = $request->leiras;
        $ingatlan->save();
    }

    public function torles($id){
        //$torol = ingatlanok::where('id', $id)->firstOrFail();
        $torol = ingatlanok::find($id); //keresés
        $torol->delete();
    }
}
