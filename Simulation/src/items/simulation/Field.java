package items.simulation;
import java.util.Random;

public class Field {
    public Field(int fieldSize,int foodCount){
        this.field = new float[fieldSize];
        this.food = foodCount;
        this.populationCap = fieldSize*2;
        fillField();
    }

    private float[] field;
    public static int populationCap;
    private float food;

    public float isThereFood(int index){
        return field[index];
    };

    public void fillField(){
        Random rand = new Random();
        for(int i = 0 ; i < this.field.length; i++){
            this.field[i] = 2.0f;
            /*
            int isFood = rand.nextInt(3);
            if(isFood==1 || isFood ==2){
                this.field[i]= food;
            }else{
                this.field[i] = 0;
            }
            */
        }
    };
}
