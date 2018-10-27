package com.uttampanchasara.sharedelementtransition.models

import android.os.Parcel
import android.os.Parcelable

class Item(val name: String, val author: String, private val mFileName: String) : Parcelable {
    val id: Int
        get() = name.hashCode() + mFileName.hashCode()

    val photoUrl: String
        get() = LARGE_BASE_URL + mFileName

    val thumbnailUrl: String
        get() = THUMB_BASE_URL + mFileName

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(author)
        writeString(mFileName)
    }

    companion object {
        private val LARGE_BASE_URL =
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/large/"

        private val THUMB_BASE_URL =
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/"

        var ITEMS = arrayOf(
            Item("Flying in the Light", "Romain Guy", "flying_in_the_light.jpg"),
            Item("Caterpillar", "Romain Guy", "caterpillar.jpg"),
            Item("Look Me in the Eye", "Romain Guy", "look_me_in_the_eye.jpg"),
            Item("Flamingo", "Romain Guy", "flamingo.jpg"),
            Item("Rainbow", "Romain Guy", "rainbow.jpg"),
            Item("Over there", "Romain Guy", "over_there.jpg"),
            Item("Jelly Fish 2", "Romain Guy", "jelly_fish_2.jpg"),
            Item("Lone Pine Sunset", "Romain Guy", "lone_pine_sunset.jpg")
        )

        fun getItem(id: Int): Item? {
            for (item in ITEMS) {
                if (item.id == id) {
                    return item
                }
            }
            return null
        }

        @JvmField
        val CREATOR: Parcelable.Creator<Item> = object : Parcelable.Creator<Item> {
            override fun createFromParcel(source: Parcel): Item = Item(source)
            override fun newArray(size: Int): Array<Item?> = arrayOfNulls(size)
        }
    }
}