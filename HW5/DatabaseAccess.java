package ru.geekbrains.lesson5;

import java.util.Collection;

public interface DatabaseAccess {

    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();

    void addModel(Model3D model);
    void removeModel(Model3D model);

    void addTexture(Texture texture);
    void removeTexture(Texture texture);

    
}
