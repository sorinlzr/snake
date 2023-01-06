package at.ac.fhcampuswien.snake.ingameobjects;

import at.ac.fhcampuswien.snake.util.Constants;

public class Food{

    private final Position position;

    private final String foodType;

    /**
     * This Contructor creates a new food Element.
     * It checks for collisions with the SNAKE Object.
     * By random there will also be a FoodType assigned.
     */
    public Food(Snake snake) {
        boolean isTargetFieldFree = true;
        int foodXCoord;
        int foodYCoord;
        int segmentNumber = Constants.SCREEN_SIZE_MEDIUM / Constants.OBJECT_SIZE_MEDIUM;
        do {
            foodXCoord = (int) (Math.random() * segmentNumber);
            foodYCoord = (int) (Math.random() * segmentNumber);

            // Since the Location of the Elements of the Snake is in PX, we need to multiply
            // the row and column number by the Object Size in PX.
            foodXCoord *= Constants.OBJECT_SIZE_MEDIUM;
            foodYCoord *= Constants.OBJECT_SIZE_MEDIUM;

            int i=0;
            do {
                if(snake.getSegments().get(i).getX() == foodXCoord &&
                        snake.getSegments().get(i).getY() == foodYCoord) isTargetFieldFree = false;
                i++;
            } while (isTargetFieldFree && i < snake.getSegments().size());

        }while(!isTargetFieldFree);
        position = new Position(foodXCoord,foodYCoord);

        String[] FOOD_TYPES = new String[]{"Apple.png", "Bannana.png", "Cherry.png",
                "Grape.png", "Lemon.png", "Orange.png", "Peach.png", "Pear.png", "Pineapple.png", "Plum.png",
                "Strawberry.png", "Watermelon.png"};
        int foodTypeNumber = (int) (Math.random() * FOOD_TYPES.length);
        foodType = FOOD_TYPES[foodTypeNumber];
    }

    public Position getLocation() {
        return position;
    }

    public String getFoodType() {
        return foodType;
    }
}
