package EverCraft.Battle

import EverCraft.Character.*

public fun run(characters: List<Character>)
{
    runRound(initiativeOrder(characters))
}

private fun runRound(characters: List<Character>)
{
    val first = characters.first()
    val last = characters.last()
    first.attack(last)
    while (charactersAlive(characters))
        runRound(listOf(last, first))
}

private fun charactersAlive(characters: List<Character>) : Boolean
{
    return characters map { c -> c.alive() } reduce { (x: Boolean, y: Boolean) -> x && y }
}

private fun initiativeOrder(characters: List<Character>) : List<Character>
{
    return characters.sortBy { char -> char.rollDice() }
}
