package com.vishu.newflowers
import android.os.Parcel
import android.os.Parcelable

data class Flower(
    val name: String,
    val description: String,
    val imageUrl: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Flower> {
        override fun createFromParcel(parcel: Parcel): Flower {
            return Flower(parcel)
        }

        override fun newArray(size: Int): Array<Flower?> {
            return arrayOfNulls(size)
        }
    }
}
