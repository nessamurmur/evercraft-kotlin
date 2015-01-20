package EverCraft.App

import EverCraft.Character.*
import EverCraft.Battle

fun main(args: Array<String>) {
    val attacker: Character = Character("Nate", Alignment.GOOD)
    val defender: Character = Character("Tim", Alignment.EVIL)
    Battle.run(attacker, defender)
}
