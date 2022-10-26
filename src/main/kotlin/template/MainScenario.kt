package template

import com.justai.jaicf.builder.Scenario
import com.justai.jaicf.reactions.buttons
import com.justai.jaicf.reactions.toState

val mainScenario = Scenario {
    append(testScenario)
    state("start") {
        activators {
            regex("/start")
        }
        action {
            reactions.run {
                say(
                    "Привет! Это тестирование на уровень знания " +
                            "языка программирования Kotlin. Начнем?"
                )
                buttons(
                    "Да!" toState "Yes",
                    "Нет, надо подготовиться" toState "Bye"
                )
            }
        }
        state("Yes") {
            action {
                reactions.run {
                    say(
                        "Для выбора варианта ответа пиши его число в бот"
                    )
                    go("../../test")
                }
            }
        }
        state("Bye") {
            action {
                reactions.run {
                    say(
                        "До скорых встреч!"
                    )
                }
            }
        }
    }

    fallback {
        reactions.sayRandom(
            "Sorry, I didn't get that...",
            "Sorry, could you repeat please?"
        )
    }
}