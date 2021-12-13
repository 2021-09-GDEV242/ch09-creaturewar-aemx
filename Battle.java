/**
 * The Battle class simulates a battle between two armies containing
 * various creatures that fight until a victory/draw condition occurs.
 * 
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public class Battle
{
    // army sizes
    private int army1Size = 100;
    private int army2Size = Randomizer.nextInt(21) + 29; // 30 to 50
    // army arrays
    private Creature[] army1 = new Creature[army1Size];
    private Creature[] army2 = new Creature[army2Size];
    // iterators (for simulation)
    private int i1 = 0;
    private int i2 = 0;

    /**
     * The default constructor for the Battle class.
     * Populates the arrays with creatures and starts the battle loop.
     */
    public Battle()
    {
        populate();
        simulate();
    }

    /**
     * Populates the armies with certain creatures
     * based on a set of given chances.
     */
    private void populate() {
        // army1
        for(int i = 0; i < army1Size; i++){
            int rand = Randomizer.nextInt(10);
            if (rand >= 7) {
                army1[i] = new Elf();
            } else {
                army1[i] = new Human();
            }
        }
        // army2
        for(int i = 0; i < army2Size; i++){
            int rand = Randomizer.nextInt(25);
            if (rand == 25) {
                army2[i] = new Balrog();
            } else if (rand >= 19) {
                army2[i] = new CyberDemon();
            } else {
                army2[i] = new Human();
            }
        }
    }

    /**
     * Simulates the war.
     */
    public void simulate() {
        while(i1 < army1Size && i2 < army2Size) {

            // initate a 1v1 battle
            Creature army1Creature = army1[i1];
            Creature army2Creature = army2[i2];
            System.out.println("[" + String.format("%03d", i1+1) + "/" + String.format("%03d", army1Size) +
                "] vs [" + String.format("%03d", i2+1) + "/" + String.format("%03d", army2Size) + "]" +
                "\nA battle begins...!"
            );

            // do the 1v1 battle
            while(army1Creature.isAlive() && army2Creature.isAlive()) {

                // army 1 does damage
                int attack1 = army1Creature.attack();
                army2Creature.takeDamage(attack1);
                System.out.println("> Army 1 did " + attack1 + " damage to Army 2..." +
                army2Creature.getHealth() + " health left!");

                // army 2 does damage
                int attack2 = army2Creature.attack(); 
                army1Creature.takeDamage(attack2);
                System.out.println("> Army 2 did " + attack2 + " damage to Army 1..." +
                army1Creature.getHealth() + " health left!");

            }

            // swap out for the next creature, if needed
            i1 += army1Creature.isAlive() ? 0 : 1;
            i2 += army2Creature.isAlive() ? 0 : 1;
            System.out.println();
        }

        System.out.println("The battle ends...");
        if (i1 < army1Size) {
            System.out.println("...and Army 1 has emerged victorious!");
        } else if (i2 < army1Size) {
            System.out.println("...and Army 2 has emerged victorious!");
        } else {
            System.out.println("...a display of pure bloodshed- there were no winners here.");
        }
    }

    /**
     * Main function
     */
    public static void main(String args[]){
        new Battle();
    }
}