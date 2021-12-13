/**
 * The Balrog class implements a wrapper for the base Demon class with the following additions
 * Implements a maximum/minimum strength for the creature type [100/50]
 * Implements a maximum/minimum hitpoint total for the creature type [200/80]
 * Implements a doubled attack method to compute damage
 *
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public class Balrog extends Demon
{
    private static final int MAX_BALROG_HP = 200;
    private static final int MIN_BALROG_HP = 80;
    private static final int MAX_BALROG_STR = 100;
    private static final int MIN_BALROG_STR = 50;

    /**
     * Constructor for objects of class Balrog -
     * The instantiating class asks for a Balrog and the Balrog class is responsible for
     * returing an Balrog object with values in the appropriate range
     */
    public Balrog()
    {
        // Generated values via Randomizer class
        super(
            Randomizer.nextInt(MAX_BALROG_HP-MIN_BALROG_HP)+MIN_BALROG_HP,    
            Randomizer.nextInt(MAX_BALROG_STR-MIN_BALROG_STR)+MIN_BALROG_STR
        );
          
    }

    /**
     * Allows a balrog to determine how much damage it is causing in this round of battle.
     * Always attacks twice.
     * @return two separate attacks, summated into one damage value
     */
    public int attack() {
        return super.attack() + super.attack();
    }
}