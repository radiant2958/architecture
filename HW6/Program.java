package ru.geekbrains.lesson6;


import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.notes.application.ConcreteNoteEditor;
import ru.geekbrains.lesson6.notes.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.notes.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.DatabaseContext;
import ru.geekbrains.lesson6.notes.presentation.queries.controllers.NotesController;
import ru.geekbrains.lesson6.notes.presentation.queries.views.NotesConsolePresenter;
import java.util.Calendar;
import java.util.Date;
public class Program {

    public static void main(String[] args) {
        NotesController notesController = new NotesController(new ConcreteNoteEditor(new NotesConsolePresenter(), new DatabaseContext(new NotesDatabase())));
        notesController.routeGetAll();
    
        
       

        // Создаем новую заметку
        int userId = 1; 
        String title = "Новая Заметка";
        String details = "Это детали новой заметки";
        Date creationDate = new Date(); 
        
        int noteId = 34; 
        Note newNote = new Note(noteId, userId, title, details, creationDate);

        
        notesController.routeAddNote(newNote);

       
        notesController.routeGetAll();
    
    
    }
}


