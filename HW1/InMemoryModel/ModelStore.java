package HW1.InMemoryModel;

import java.util.ArrayList;
import java.util.List;

import HW1.ModelElements.Camera;
import HW1.ModelElements.Flash;
import HW1.ModelElements.PoligonalModel;
import HW1.ModelElements.Scene;

public class ModelStore implements IModelChanger{
    private List<PoligonalModel> polygonalModels = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();
    private List<IModelChangedObserver> changeObservers = new ArrayList<>();

    public ModelStore(List<PoligonalModel> polygonalModels, List<Scene> scenes, List<Flash> flashes, List<Camera>  cameras){
        this.polygonalModels=polygonalModels;
        this.scenes=scenes;
        this.flashes=flashes;
        this.cameras=cameras;

    }
    
    @Override
    public void notifyChange(IModelChanger sender) {
        for (IModelChangedObserver observer : changeObservers) {
            observer.applyUpdateModel();
        }
    }
    
    public Scene getScene(int id){
        for (Scene scene : scenes) {
            if (scene.getId() == id) {
                return scene;
            }
        } 
        return null;
    }

  
}
