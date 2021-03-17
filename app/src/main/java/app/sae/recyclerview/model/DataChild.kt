package app.sae.recyclerview.model

import com.google.gson.annotations.SerializedName

data class DataChild(
    @SerializedName("idBarang")
    var idBarang: String? = "",
    @SerializedName("nama")
    var nama: String? = "",
    @SerializedName("keterangan")
    var keterangan: String? = "",
    @SerializedName("img")
    var img: String? = ""
)
