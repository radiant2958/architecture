package HW1.ModelElements;


import java.util.ArrayList;
import java.util.List;

public class Scene {
    private int id;
    private List<PoligonalModel> models;
    private List<Flash> flashes;
    private List<Camera> cameras;

    // Конструктор
    public Scene(int id) {
        this.id = id;
        this.models = new ArrayList<>();
        this.flashes = new ArrayList<>();
        this.cameras = new ArrayList<>();
    }

   
    public void addModel(PoligonalModel model) {
        models.add(model);
    }
    
    public void removeModel(PoligonalModel model) {
        models.remove(model);
    }
    
    public PoligonalModel getModel(int index) {
        return models.get(index);
    }
    
    public List<PoligonalModel> getAllModels() {
        return new ArrayList<>(models);
    }

   
    public void addFlash(Flash flash) {
        flashes.add(flash);
    }
    
    public void removeFlash(Flash flash) {
        flashes.remove(flash);
    }
    
    public Flash getFlash(int index) {
        return flashes.get(index);
    }
    
    public List<Flash> getAllFlashes() {
        return new ArrayList<>(flashes);
    }

  
    public void addCamera(Camera camera) {
        cameras.add(camera);
    }
    
    public void removeCamera(Camera camera) {
        cameras.remove(camera);
    }
    
    public Camera getCamera(int index) {
        return cameras.get(index);
    }
    
    public List<Camera> getAllCameras() {
        return new ArrayList<>(cameras);
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}


