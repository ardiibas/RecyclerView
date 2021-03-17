package app.sae.recyclerview.model

import com.google.gson.annotations.SerializedName

data class DataParent(
    @SerializedName("idRuang")
    var idRuang: String? = "",
    @SerializedName("nama")
    var nama: String? = "",
    @SerializedName("img")
    var img: String? = "",
    @SerializedName("data")
    var data: List<DataChild?>? = listOf()
)
