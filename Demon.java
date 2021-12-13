/**
 * The Demon class implements a wrapper for the base Creature class
 * Implements a 5% chance to override attack and cause +50 damage
 * 
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public abstract class Demon extends Creature
{
    /**
     * Constructor for objects of class Demon -
     * Should never be instantiated directly.
     * @param health The base health of the Demon
     * @param strength The strength of the Demon
     */
    public Demon(int health, int strength)
    {
        super(health, strength);
          
    }

    /**
     * Allows a demon to determine how much damage it is causing in this round of battle.
     * Has a 10% to do magical damage and double the damage returned another creature
     * @return a value to be used to cause damage to another creature
     */
    public int attack() {
        if (Randomizer.nextInt(20) == 1) {
            return super.attack() + 50;
        }
        return super.attack();
    }
}