package template

import com.justai.jaicf.activator.caila.caila
import com.justai.jaicf.builder.Scenario
import com.justai.jaicf.reactions.buttons
import com.justai.jaicf.reactions.toState

val mainScenario = Scenario {
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
                    "Да!" toState "Да!",
                    "Нет, надо подготовиться" toState "Нет"
                )
            }
        }
        state("Да!") {
            action {
                reactions.run {
                    say(
                        "COOL!"
                    )
                }
            }
        }
        state("Нет") {
            action {
                reactions.run {
                    say(
                        "BAD("
                    )
                }
            }
        }
    }

    state("bye") {
        activators {
            intent("Bye")
        }

        action {
            reactions.sayRandom(
                "See you soon!",
                "Bye-bye!"
            )
            reactions.image("https://media.giphy.com/media/EE185t7OeMbTy/source.gif")
        }
    }

    fallback {
        reactions.sayRandom(
            "Sorry, I didn't get that...",
            "Sorry, could you repeat please?"
        )
    }
}