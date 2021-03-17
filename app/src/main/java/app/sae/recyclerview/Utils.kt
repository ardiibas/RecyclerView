package app.sae.recyclerview

import android.content.Context
import java.io.IOException

object Utils {
    fun loadJSONFromAsset(context: Context, fileName: Int): String? {
        val readFile: String?
        readFile = try {
            val `is` = context.resources.openRawResource(fileName)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return readFile
    }
}