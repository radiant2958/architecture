package HW1.ModelElements;


public class Texture {
    
    private int id;
    private static int counter = 1000;

    private String name;
 
    public Texture(String name){
       
        this.name = name;
        id = ++counter;
    }
    
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }


}
