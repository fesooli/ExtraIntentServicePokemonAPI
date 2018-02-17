package br.com.fellipe.extraintentservice

import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver

/**
 * Created by logonrm on 17/02/2018.
 */
class DownloadResultReceiver(handler: Handler) : ResultReceiver(handler) {
    private var mReceiver: Receiver? = null

    fun setReceiver(receiver: Receiver) {
        mReceiver = receiver
    }

    interface Receiver {
        fun onReceiverResult(resultCode: Int, resultData: Bundle)
    }

    override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
        if(mReceiver!= null) {
            mReceiver!!.onReceiverResult(resultCode, resultData)
        }
    }
}