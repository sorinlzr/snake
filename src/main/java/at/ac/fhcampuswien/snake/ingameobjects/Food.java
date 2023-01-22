package at.ac.fhcampuswien.snake.ingameobjects;

import at.ac.fhcampuswien.snake.util.Constants;

import java.util.Objects;

public class Food {

    private final Position position;

    private String foodType;

    public int getScoreValue() {
        return scoreValue;
    }

    private int scoreValue;

    //TODO : Multiply the Score Value with the chosen Difficulty Level: EASY : *1 | MEDIUM : *2 | HARD : *3
    private final static int REGULAR_SCORE_VALUE = 1;
    private final static int SPECIAL_SCORE_VALUE = 3;

    private int specialFoodTimeToLive;

    private final static String[] REGULAR_FOOD_TYPES = new String[]{"Apple.png", "Bannana.png", "Cherry.png",
            "Grape.png", "Lemon.png", "Orange.png", "Peach.png", "Pear.png", "Pineapple.png", "Plum.png",
            "Strawberry.png", "Watermelon.png"};

   private final static String[] SPECIAL_FOOD_TYPES = new String[]{"Mathias.png", "Sorin.png",
            "Lukas.png", "Arik.png", "Benjamin.png", "Aleksandar.png"};

    //private final static String[] SPECIAL_FOOD_TYPES = new String[]{"Sorin.png"};


    /**
     * This Constructor creates a new food Element.
     * It checks for collisions with the SNAKE Object.
     * By random there will also be a FoodType assigned.
     */
    public Food(Snake snake, Wall wall, Food currentlyExistingRegularFood, boolean isSpecialFood, String previousFoodType) {
        if(isSpecialFood){
            //TODO: multiply by difficulty level
            this.scoreValue=SPECIAL_SCORE_VALUE;
            // range: 18 - 36
            this.specialFoodTimeToLive = (int) (18 + (Math.random() * 18));
            do {
                int foodTypeNumber = (int) (Math.random() * SPECIAL_FOOD_TYPES.length);
                this.foodType = SPECIAL_FOOD_TYPES[foodTypeNumber];
            } while (Objects.equals(foodType, previousFoodType));
        } else {
            //TODO: multiply by difficulty level
            this.scoreValue=REGULAR_SCORE_VALUE;
            this.specialFoodTimeToLive = -1;
            do {
                int foodTypeNumber = (int) (Math.random() * REGULAR_FOOD_TYPES.length);
                foodType = REGULAR_FOOD_TYPES[foodTypeNumber];
            } while (Objects.equals(foodType, previousFoodType));
        }
        boolean isTargetFieldFree;
        int foodXCoord;
        int foodYCoord;
        // We reduce "2" from segmentNumberX, because there are two Colums being used for the outer walls.
        int segmentNumberX = Constants.NUMBER_OF_ROWS_AND_COLS - 2;
        // We reduce "3" from segmentNumberY, because there are two rows being used for the outer walls.
        // Additionally there is 1 row used for the status bar at the top.
        int segmentNumberY = Constants.NUMBER_OF_ROWS_AND_COLS - 3;
        do {
            isTargetFieldFree = true;
            foodXCoord = (int) (Math.random() * segmentNumberX) + 1;
            foodYCoord = (int) (Math.random() * segmentNumberY) + 1;

            // Since the Location of the Elements of the Snake is in PX, we need to multiply
            // the row and column number by the Object Size in PX.
            foodXCoord *= Constants.OBJECT_SIZE_MEDIUM;
            foodYCoord *= Constants.OBJECT_SIZE_MEDIUM;

            // Check if calculated Position is inhibited by the snake
            int i = 0;
            do {
                if (snake.getSegments().get(i).getX() == foodXCoord &&
                        snake.getSegments().get(i).getY() == foodYCoord) isTargetFieldFree = false;
                i++;
            } while (isTargetFieldFree && i < snake.getSegments().size());

            // Check if calculated Position is inhibited by the wall
            if (wall != null && isTargetFieldFree) {
                int j = 0;
                do {
                    if (wall.getSegments().get(j).getX() == foodXCoord &&
                            wall.getSegments().get(j).getY() == foodYCoord) isTargetFieldFree = false;
                    j++;
                } while (isTargetFieldFree && j < wall.getSegments().size());
            }

            // Check if currently existing regular Food is on desired Position
            if(isSpecialFood && currentlyExistingRegularFood != null && isTargetFieldFree){
                if (currentlyExistingRegularFood.position.getX() == foodXCoord &&
                        currentlyExistingRegularFood.position.getY() == foodYCoord) isTargetFieldFree = false;
            }


        } while (!isTargetFieldFree);
        position = new Position(foodXCoord, foodYCoord);
    }

    public Position getLocation() {
        return position;
    }

    public String getFoodType() {
        return foodType;
    }

    public int getSpecialFoodTimeToLive(){
        return specialFoodTimeToLive;
    }

    public void decreaseSpecialFoodTimeToLive(){
        specialFoodTimeToLive--;
    }
}
