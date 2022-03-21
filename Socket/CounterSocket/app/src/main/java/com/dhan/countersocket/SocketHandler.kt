package com.dhan.countersocket


import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

/**
 * Created by David Chhetri on 20,March,2022
 */
object SocketHandler {
    lateinit var mSocket: Socket

    @Synchronized
    fun setSocket(){
        try{
            mSocket = IO.socket("http://10.0.2.2:3000")
        }catch (e : URISyntaxException){

        }
    }

    fun getSocket(): Socket{
        return  mSocket
    }
}