/**
 * The CyberDemon class implements a wrapper for the base Demon class with the following additions
 * Implements a maximum/minimum strength for the creature type [40/20]
 * Implements a maximum/minimum hitpoint total for the creature type [100/25]
 * 
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public class CyberDemon extends Demon
{
    private static final int MAX_CYBERDEMON_HP = 100;
    private static final int MIN_CYBERDEMON_HP = 25;
    private static final int MAX_CYBERDEMON_STR = 40;
    private static final int MIN_CYBERDEMON_STR = 20;

    /**
     * Constructor for objects of class CyberDemon -
     * The instantiating class asks for a CyberDemon and the CyberDemon class is responsible for
     * returing an CyberDemon object with values in the appropriate range
     */
    public CyberDemon()
    {
        // Generated values via Randomizer class
        super(
            Randomizer.nextInt(MAX_CYBERDEMON_HP-MIN_CYBERDEMON_HP)+MIN_CYBERDEMON_HP,    
            Randomizer.nextInt(MAX_CYBERDEMON_STR-MIN_CYBERDEMON_STR)+MIN_CYBERDEMON_STR
        );
          
    }
}