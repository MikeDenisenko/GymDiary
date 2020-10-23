package com.mike.gymdiary.Utility;

public class NetworkUtility {

   /* String publisher(Quest quest, user : User) : String {
        try {

            val url = URL("http://questy-vapor.herokuapp.com/api/quests/" +  quest.questId + "/publish")
            with(url.openConnection() as HttpURLConnection) {

                val OAuth: String = "Bearer " + user.token.signature
                setRequestProperty("Authorization", OAuth)
                doOutput = true
                requestMethod = "PUT"  // optional default is GET
                println("\nSent 'PUT' request to URL : $url; Response Code : $responseCode")
                val allText = inputStream.bufferedReader().use(BufferedReader::readText)
                println (allText)
                disconnect()
                return allText
            }

        } catch (ex: Exception) {
            return ex.message.toString()
        }
    }*/

}
