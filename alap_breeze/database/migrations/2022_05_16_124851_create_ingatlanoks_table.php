<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ingatlanoks', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger("kategoria"); //unsigned!!
            $table->string("leiras");
            $table->date("hirdetesDatuma")->useCurrent();
            $table->boolean("tehermentes");
            $table->integer("ar");
            $table->string("kepUrl");

            // forign("jelen tábla külső kulcsa")
            // references("másik tálba elsődleges kulcsa")
            // on("másik tábla neve")
            $table->foreign('kategoria')->references('id')->on('kategoriaks');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('ingatlanoks');
    }
};
