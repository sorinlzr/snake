package at.ac.fhcampuswien.snake.ingameobjects;

import at.ac.fhcampuswien.snake.util.Constants;

public class Food{

    private final Position position;

    private final String foodType;

    private final static String[] FOOD_TYPES = new String[]{"Apple.png", "Bannana.png", "Cherry.png",
            "Grape.png", "Lemon.png", "Orange.png", "Peach.png", "Pear.png", "Pineapple.png", "Plum.png",
            "Strawberry.png", "Watermelon.png"};


    /**
     * This Contructor creates a new food Element.
     * It checks for collisions with the SNAKE Object.
     * By random there will also be a FoodType assigned.
     */
    public Food(Snake snake, Wall wall) {
        boolean isTargetFieldFree;
        int foodXCoord;
        int foodYCoord;
        int segmentNumberX = Constants.NUMBER_OF_ROWS_AND_COLS - 2 ;
        int segmentNumberY = Constants.NUMBER_OF_ROWS_AND_COLS - 3 ;
        do {
            isTargetFieldFree = true;
            foodXCoord = (int) (Math.random() * segmentNumberX) + 1;
            foodYCoord = (int) (Math.random() * segmentNumberY) + 1;

            // Since the Location of the Elements of the Snake is in PX, we need to multiply
            // the row and column number by the Object Size in PX.
            foodXCoord *= Constants.OBJECT_SIZE_MEDIUM;
            foodYCoord *= Constants.OBJECT_SIZE_MEDIUM;

            // Check if calculated Position is inhibited by the snake
            int i=0;
            do {
                if(snake.getSegments().get(i).getX() == foodXCoord &&
                        snake.getSegments().get(i).getY() == foodYCoord) isTargetFieldFree = false;
                i++;
            } while (isTargetFieldFree && i < snake.getSegments().size());

            // Check if calculated Position is inhibited by the wall
            int j=0;
            do {
                if(wall.getSegments().get(j).getX() == foodXCoord &&
                        wall.getSegments().get(j).getY() == foodYCoord) isTargetFieldFree = false;
                j++;
            } while (isTargetFieldFree && j < wall.getSegments().size());


        }while(!isTargetFieldFree);
        position = new Position(foodXCoord,foodYCoord);

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
