package EverCraft.Character

import java.util.Random

enum class Alignment {
    GOOD
    EVIL
    NEUTRAL
}

class Character(val name: String, val alignment: Alignment,
                val ac: Int = 10, var hp: Int = 5)
{

    fun rollDice(n: Int = 20): Int {
        return Random().nextInt(n)
    }

    fun attack(defender: Character, damage: Int = 1) {
        when (rollDice()) {
            20 -> defender.takeDamage(damage * 2)
            in defender.ac..19 -> defender.takeDamage(damage)
            else -> miss(defender)
        }
    }

    fun takeDamage(damage: Int) {
        hp = hp minus damage
        if (hp <= 0)
            println("$name has died!")
        else
            println("$name only has $hp hp!")

    }

    fun miss(defender: Character) {
        println("$name missed ${defender.name}")
    }

    fun alive() : Boolean {
        return hp > 0
    }
}

