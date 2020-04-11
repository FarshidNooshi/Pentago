// In The Name Of GOD
package COM;

/**
 * this method is used for printing colorful and interesting in console.
 * i copied ANSI_* from stackoverflow.com and characters below the ansis are unicode characters.
 * the game supports up to 4 player in a time to play.
 */
public interface ColorfulText {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_BLACK = "\u001B[30m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_WHITE = "\u001B[37m";
    char empty = '⊛';
    char[] users = {'⊝', '⊜', '☢', '❂'};
    char counterClockwise = '⟲';
    char clockwise = '⟳';
    char winner = '⭐';// Yellow

}
