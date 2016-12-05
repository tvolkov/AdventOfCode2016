package com.company.day5

import java.security.MessageDigest
import java.util.*

fun main(args: Array<String>) {
    println(calculatePassword1(args[0]))
    println(calculatePassword2(args[0]))
}

fun  calculatePassword1(doorId: String): String {
    val md5: MessageDigest = MessageDigest.getInstance("MD5")
    var index: Int = 0
    var password: String = ""
    while (password.length < 8){
        val hash = md5.digest((doorId + index).toByteArray())
        val hexPassword = byteToStr(hash)
        if (hexPassword.startsWith("00000")){
            password += hexPassword[5]
        }
        index++
    }
    return password
}

fun calculatePassword2(doorId: String): String {
    val md5: MessageDigest = MessageDigest.getInstance("MD5")
    var index: Int = 0
    var password: CharArray = CharArray(8)
    var storedIndices: ArrayList<Int> = arrayListOf()
    while (storedIndices.size < 8){
        val hash = md5.digest((doorId + index).toByteArray())
        val hexPassword = byteToStr(hash)
        if (hexPassword.startsWith("00000")){
            var positionChar = hexPassword[5]
            if (positionChar in '0'..'9'){
                val position: Int = Integer.parseInt(positionChar.toString())
                if (position in 0..7 && !storedIndices.contains(position)){
                    password[position] = hexPassword[6]
                    storedIndices.add(position)
                }
            }
        }
        index++
    }
    return String(password)
}

val hexChars: CharArray = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7','8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

fun  byteToStr(hash: ByteArray): String {
    var chars: CharArray = CharArray(hexChars.size shl 1)
    for (i in hash.indices){
        val v = hash[i].toInt() and 0xFF
        chars[i shl 1] = hexChars[v ushr 4]
        chars[(i shl 1) + 1] = hexChars[v and 0x0F]
    }
    return String(chars)
}
