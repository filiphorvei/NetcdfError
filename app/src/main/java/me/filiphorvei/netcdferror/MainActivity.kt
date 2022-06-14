package me.filiphorvei.netcdferror

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ucar.nc2.NCdumpW
import ucar.nc2.dataset.NetcdfDataset

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
        private const val THREDDS_URL = "https://thredds.met.no/thredds/dodsC/fou-hi/norkyst800m-1h/NorKyst-800m_ZDEPTHS_his.an.2022020900.nc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testOpendap()
    }

    private fun testOpendap() {

        val ncfile = NetcdfDataset.openFile(THREDDS_URL, null)
        Log.d(TAG, "File successfully opened: $ncfile")

        val temperature = ncfile.findVariable("temperature")
        Log.d(TAG, "Temperature: $temperature")

        if (temperature != null) {
            val data = temperature.read("2,0:2,200:203,199")
            val dataString = NCdumpW.printArray(data, "temperature_selection", null)
            Log.d(TAG, dataString)
        }

        NetcdfDataset.shutdown()
    }
}