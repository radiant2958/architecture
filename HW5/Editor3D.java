package ru.geekbrains.lesson5;

import java.util.ArrayList;
import java.util.Collection;

public class Editor3D implements UILayer {

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    public Editor3D(){
    }

    private void initialize(){
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }

    @Override
    public void openProject(String fileName) {
        projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void showProjectSettings() {

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");
    }

    @Override
    public void saveProject() {
        System.out.println("Изменения успешно сохранены.");
        database.save();
    }

    @Override
    public void printAllModels() {
        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++){
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture: models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }
    }

    @Override
    public void printAllTextures() {
        ArrayList<Texture> textures = (ArrayList<Texture>)businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++){
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void renderModel(int i) {
        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректною.");
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void addNewModel() {
        Model3D model = new Model3D();
        businessLogicalLayer.addNewModel(model);
        System.out.println("Новая модель добавлена.");

    }

    @Override
    public void removeModel(int modelId) {
        Collection<Model3D> models = businessLogicalLayer.getAllModels();
        Model3D modelToRemove = null;

        for (Model3D model : models) {
            if (model.getId() == modelId) {
                modelToRemove = model;
                break;
            }
        }

        if (modelToRemove != null) {
            businessLogicalLayer.removeModel(modelToRemove);
            System.out.println("Модель с ID " + modelId + " удалена.");
        } else {
            System.out.println("Модель с ID " + modelId + " не найдена.");
        }

    }

    @Override
    public void addNewTexture() {
        Texture texture = new Texture();
        businessLogicalLayer.addNewTexture(texture);
        System.out.println("Новая текстура добавлена.");
    }

    @Override
    public void removeTexture(int textureId) {
        Collection<Texture> textures = businessLogicalLayer.getAllTextures();
        Texture textureToRemove = null;
    
        for (Texture texture : textures) {
            if (texture.getId() == textureId) {
                textureToRemove = texture;
                break;
            }
        }
    
        if (textureToRemove != null) {
            businessLogicalLayer.removeTexture(textureToRemove);
            System.out.println("Текстура с ID " + textureId + " удалена.");
        } else {
            System.out.println("Текстура с ID " + textureId + " не найдена.");
        }
    }

 
}