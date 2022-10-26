package template

import com.justai.jaicf.activator.catchall.catchAll
import com.justai.jaicf.activator.event.event
import com.justai.jaicf.builder.Scenario
import com.justai.jaicf.channel.telegram.callback
import com.justai.jaicf.channel.telegram.telegram
import com.justai.jaicf.model.scenario.Scenario
import com.justai.jaicf.reactions.buttons
import com.justai.jaicf.reactions.toState
import io.ktor.client.request.*
import template.dataBase.GetTasks

val testScenario = Scenario {
    var numberQuestion: Int = 1
    var points: Int = 0
    state("test") {
        activators {
            catchAll()
        }
        action {
            var pushedButton: String
                reactions.run {
                    if(numberQuestion>20) {
                        say("Твой результат " + points.toString() + " из 20")
                        go("../start/Bye")
                    }
                    say(template.dataBase.GetQuestion(GetTasks(numberQuestion)))
                    var buttonsCount = 0
                    while(buttonsCount < template.dataBase.GetVarCount(GetTasks(numberQuestion)))
                    {
                        buttonsCount++
                        buttons(buttonsCount.toString())
                    }
                }
            activator.catchAll?.run {
                pushedButton = request.input
                if(pushedButton.toInt() == template.dataBase.GetRightVar(GetTasks(numberQuestion)))
                    points+=1
                numberQuestion+=1
            }
        }
    }
}


