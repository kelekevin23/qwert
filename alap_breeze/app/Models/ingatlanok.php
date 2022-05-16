<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\kategoriak;

class ingatlanok extends Model
{
    use HasFactory;

    //protected $table = "kategoriaks";
    
    //akkor kell ha több táblás lekérdezés van, és össze kell kötnünk egy másik táblával -> modell név alapján ->kategoriak,
    //első paraméter --> a kategoria tábla főkulcs
    //második paraméter --> jelen tábla külső kulcsa
    //kategória importálása
    public function kategoria() {
        return $this->hasOne(kategoriak::class, 'id', 'kategoria');
    }
}
