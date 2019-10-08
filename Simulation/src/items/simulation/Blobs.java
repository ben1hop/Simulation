package items.simulation;
import java.util.Random;

public class Blobs {

    public Blobs(){
        this.energy=1;
        this.place=-1;
        this.type = "";
    }

    public Blobs(int startEnergy, String type){
        this.energy=startEnergy;
        this.place=-1;
        this.type=type;
        this.population++;
    }

    private String type;
    private int energy;
    public int place;
    public float stash;
    public static int population=0;

    public boolean reproduce(){
        if(this.stash >= 2){
            return true;
        }
        // If he has food between 1-2 , that float number becomes his survival chance
        else if(this.stash > 1){
            //System.out.println(this.stash+"rep value");
            int chance = Math.round((this.stash-1)*100);
            //System.out.println(chance+" rep chance");
            Random rand = new Random();
            int success = rand.nextInt(101);
            //System.out.println("Rep= "+ chance+": chance "+success+": roll");
            if(success <= chance){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    };

    public boolean survive(){
        if(this.stash >= 1){
            return true;
        }
        // If he has food between 0-1 , that number becomes his survival chance
        else if(this.stash > 0){
            //System.out.println(this.stash+"survive value");
            int chance = Math.round(this.stash*100);
            //System.out.println(chance+" survive chance");
            Random rand = new Random();
            int success = rand.nextInt(101);
            //System.out.println("Survive= "+chance+": chance "+success+": roll");
            if(success <= chance){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public String thisType(){return this.type;}


    public int move(int sizeOfField){
        Random rand = new Random();
        this.place = rand.nextInt(sizeOfField);
        return this.place;
    };

    public void setBack(){
        this.place = -1;
    }

}