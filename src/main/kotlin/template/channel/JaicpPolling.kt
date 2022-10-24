package template

import com.justai.jaicf.channel.jaicp.JaicpPollingConnector
import com.justai.jaicf.channel.telegram.TelegramChannel
import template.testBot

fun main() {
    JaicpPollingConnector(
        botApi = testBot,
        accessToken = "45398849-9eef-492f-b160-425b3ca242c6",
        channels = listOf(
            TelegramChannel
        )
    ).runBlocking()

}
