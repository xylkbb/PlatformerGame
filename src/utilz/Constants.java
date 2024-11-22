package utilz;

public class Constants {
    // TODO: Nothing to do on this one, just something to read and learn from.
    // You can organize Constants into categories by using static inner classes.
    // That way to access a constant you can say Constants.Direction.LEFT, etc.
    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;

        // TODO: Note:  All of these are public, static, and finalX
        // TODO: create an int named LEFT and initialize to 0.X
        // TODO: create an int named UP and initialize to 1. X
        // TODO: create an int named RIGHT and initialize to 2. X
        // TODO: create an int named DOWN and initialize to 3. X
    }

    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;
        // TODO: Note:  All of these are public static, and final. X
        // TODO: create an int named IDLE and initialize to 0.X
        // TODO: create an int named RUNNING and initialize to 1.X
        // TODO: create an int named JUMP and initialize to 2. X
        // TODO: create an int named FALLING and initialize to 3.X
        // TODO: create an int named GROUND and initialize to 4.X
        // TODO: create an int named HIT and initialize to 5.X
        // TODO: create an int named ATTACK_1 and initialize to 6. X
        // TODO: create an int named ATTACK_JUMP_1 and initialize to 7. X
        // TODO: create an int named ATTACK_JUMP_2 and initialize to 8. X

        public static int GetSpriteAmount(int player_action) {
            // TODO: Note:  the cases without a return are meant to fall through to the first one with a return.
            // not a mistake.
            switch (player_action) {
                case RUNNING: {
                    return 6;
                }
                case IDLE: {
                    return 5;
                }
                case HIT: {
                    return 4;
                }
                case JUMP: {
                }
                case ATTACK_1: {
                }
                case ATTACK_JUMP_1: {
                }
                case ATTACK_JUMP_2: {
                    return 3;
                }
                case GROUND: {
                    return 2;
                }
                case FALLING: {
                }
                default:
                    return 1;
            }


            // TODO: create a switch statement using switch(player_action) X
            // TODO: case RUNNING: return 6  X
            // TODO: case IDLE: return 5 X
            // TODO: case HIT: return 4 X
            // TODO: case JUMP: X
            // TODO: case ATTACK_1: X
            // TODO: case ATTACK_JUMP_1: X
            // TODO: case ATTACK_JUMP_2: return 3 X
            // TODO: case GROUND: return 2 X
            // TODO: case FALLING:X

        }
    }
}
