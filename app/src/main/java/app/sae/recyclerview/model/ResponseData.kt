package app.sae.recyclerview.model

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("status")
    var status: String? = "",
    @SerializedName("msg")
    var msg: String? = "",
    @SerializedName("data")
    var data: List<DataParent?>? = listOf()
)
