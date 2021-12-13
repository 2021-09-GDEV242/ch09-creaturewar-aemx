/**
 * Abstract class Creature - 
 * The creature is the main class from which all other battling creatures derive.
 * It is the creature's job to maintain current health values in response to 
 * requests to takeDamage. It also must report if
 * the creature is alive or knocked out. The creature is also responsible for calculating
 * damage delivered based on the creature's strength (1 to strength) 
 * 
 * @author Spencer Gunning
 * @version 2021.12.12
 */

public abstract class Creature
{
    private int strength;        // The strength of this creature
    private int maxHealth;     // The maximum hit points the creature can have (used if healing enabled)
    private int health;         // the current numberof hit points the creature has

    /**
     * default constructor - this should never actually run.
     * It is the job of dervived classes to set up the proper number of hit points and 
     * strength for the subclass
     */
    public Creature (){
        strength = 10;
        health = 10;
        maxHealth = health;
    }

    /**
     * Create a creature with a given strength and hit point level. 
     * Store max hitpoints to allow for healing to be implemented later
     * Heals must never allow for more hit points than the creature started
     * with
     * @param str the strength of the creature, used to calculate damage
     * @param hp the health of the creature at the start of the simulation, and the current health levels during battle
     */
    public Creature (int str, int hp) {
       strength = str;
       health = hp;
       maxHealth = health;
    }

    /**
     * Allows a creature to determine how much damage it is causing in this round of battle
     * @return a value between 1 and strength to be used to cause damage to another creature
     */
    public int attack(){
        return Randomizer.nextInt(strength);
    }

    /**
     * takeDamage receives a value for the amount of damage to subtract from 
     * the current total of hit points
     * @param damage value to remove from hit point count
     */
    public void takeDamage(int damage) {
        health = health - damage;
    }

    /**
     * Is this creature still capable of fighting?
     * @return true when current hit point level is greater than zero
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Is this creature knockedOut?
     * @return true when current hit point level is less than or equal to zero
     */
    public boolean isKnockedOut() {
        return health <= 0;
    }

    /**
     * How many hit points does this creature have?
     * @return the current health value of the creature 
     */
    public int getHealth() {
        return health;
    }
}