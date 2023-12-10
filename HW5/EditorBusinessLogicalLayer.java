package ru.geekbrains.lesson5;

import java.util.Collection;
import java.util.Random;

/**
 * Business Logical Layer
 * Описываем реализацию конкретных функций проекта
 */
public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess){
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model: getAllModels()) {
            processRender(model);
        }
    }

    private Random random = new Random();
    private void processRender(Model3D model){
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void addNewModel(Model3D model) {
        databaseAccess.addModel(model);
    }

    @Override
    public void removeModel(Model3D model) {
        databaseAccess.removeModel(model);
    }

    @Override
    public void addNewTexture(Texture texture) {
        databaseAccess.addTexture(texture);
    }

    @Override
    public void removeTexture(Texture texture) {
        databaseAccess.removeTexture(texture);
    }


}
