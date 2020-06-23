package org.techtown.kotlinproject.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = true)
    var uid:Long?,

    @ColumnInfo(name ="email")
    var email:String?,

    @ColumnInfo(name ="password")
    var password:String?,

    @ColumnInfo(name ="phomeNum")
    var phoneNum:String?




){
    constructor() : this(null,"","","");
}


