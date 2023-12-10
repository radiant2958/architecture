package ru.geekbrains.lesson5;

import java.util.Collection;

public interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();
    void renderModel(Model3D model);
    void renderAllModels();

    void addNewModel(Model3D model);
    void removeModel(Model3D model);

    void addNewTexture(Texture texture);
    void removeTexture(Texture texture);


}
