import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.regex.RegexActivator
import template.scenario.mainScenario
import java.util.*

val TestBot = BotEngine(
    scenario = mainScenario,
    activators = arrayOf(
        RegexActivator
    )
)