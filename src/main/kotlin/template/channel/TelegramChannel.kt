package template.channel

import com.justai.jaicf.channel.telegram.TelegramChannel
import template.testBot

fun main() {
    TelegramChannel(testBot, "5551533995:AAG_8rf5r1tJGdxNOuKX46wZBnx3q7_aF3w").run()
}