package template.connections

import com.justai.jaicf.channel.telegram.TelegramChannel
import com.justai.jaicf.channel.jaicp.JaicpServer
import template.testBot

fun main() {
    JaicpServer(
        botApi = testBot,
        accessToken = "45398849-9eef-492f-b160-425b3ca242c6",
        channels = listOf(
            TelegramChannel
        )
    ).start(wait = true)
}