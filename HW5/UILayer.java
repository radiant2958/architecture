package ru.geekbrains.lesson5;

public interface UILayer {

    void openProject(String fileName);
    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();
    void renderModel(int i);

    void addNewModel();
    void removeModel(int modelId);
    void addNewTexture();
    void removeTexture(int textureId);
    


}
