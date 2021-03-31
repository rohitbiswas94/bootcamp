package datastructures;

public class RobotBoundedInCircle {

    private static boolean isRobotBounded(String instructions) {
        if (instructions.length() == 1) {
            if (instructions.charAt(0) == 'L' || instructions.charAt(0) == 'R')
                return true;
            else
                return false;
        }
        int x = 0, y = 0;
        int axis = 'y'; //Initially facing north
        int xMovement = 1;
        int yMovement = 1;
        int xDir = 1;
        int yDir = 1;
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                if (axis == 'y') {
                    y = y + yMovement;
                } else {
                    x = x + xMovement;
                }
            } else if (c == 'L') {
                if (axis == 'y') {
                    axis = 'x';
                    xMovement = yDir == 1 ? -1 : 1;
                    xDir = yDir == 1 ? -1 : 1;
                } else {
                    axis = 'y';
                    yMovement = xDir == 1 ? 1 : -1;
                    yDir = xDir == 1 ? 1 : -1;
                }
            } else {
                if (axis == 'y') {
                    axis = 'x';
                    xMovement = yDir == 1 ? 1 : -1;
                    xDir = yDir == 1 ? 1 : -1;
                } else {
                    axis = 'y';
                    yMovement = xDir == 1 ? -1 : 1;
                    yDir = xDir == 1 ? -1 : 1;
                }
            }
        }

        if (x == 0 && y == 0) return true;
         /*
         If the robot is facing north then it will never be bounded in a circle.
         Else if its facing any other direction then it will be bounded in a circle.
         */
        return axis != 'y' || yDir != 1;
    }

    public static void main(String[] args) {
        String command = "GLGGLRRG";
        System.out.println(isRobotBounded(command));
    }
}
