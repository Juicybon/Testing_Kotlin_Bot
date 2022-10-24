package template.connections

import com.justai.jaicf.channel.jaicp.JaicpPollingConnector
import com.justai.jaicf.channel.telegram.TelegramChannel
import TestBot
import com.justai.jaicf.channel.jaicp.channels.ChatApiChannel
import com.justai.jaicf.channel.jaicp.channels.ChatWidgetChannel
import com.justai.jaicf.channel.jaicp.channels.TelephonyChannel

fun main() {
    JaicpPollingConnector(
        botApi = TestBot,
        accessToken = "your JAICF project token",
        channels = listOf(
            TelegramChannel
        )
    ).runBlocking()
}