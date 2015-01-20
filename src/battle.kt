package EverCraft.Battle

import EverCraft.Character.*

public fun run(char1: Character, char2: Character)
{
    runRound(char1, char2)
}

private fun runRound(attacker: Character, defender: Character)
{
    attacker.attack(defender)
    if (charactersAlive(attacker, defender)) runRound(defender, attacker)
}

private fun charactersAlive(vararg characters: Character) : Boolean
{
    return characters map { c -> c.alive() } reduce { (x: Boolean, y: Boolean) -> x && y }
}

