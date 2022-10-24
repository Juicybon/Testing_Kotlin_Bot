package template

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.regex.RegexActivator
import java.util.*

val testBot = BotEngine(
    scenario = mainScenario,
    activators = arrayOf(
        RegexActivator
    )
)