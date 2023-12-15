package ru.geekbrains.lesson6.notes.infrastructure.persistance;

import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.database.NotesRecord;
import ru.geekbrains.lesson6.database.NotesTable;
import ru.geekbrains.lesson6.notes.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.configuration.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseContext extends DbContext implements NotesDatabaseContext {


    public DatabaseContext(Database database) {
        super(database);
    }

    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;
    }
    
    public boolean add(Note note) {
        for (NotesRecord existingRecord : ((NotesDatabase)database).getNotesTable().getRecords()) {
            if (existingRecord.getId() == note.getId()) {
                
                return false;
            }
        }

        // Создаем новую запись для добавления в базу данных
        // NotesRecord newRecord = new NotesRecord();
        // newRecord.setId(note.getId());
        // newRecord.setUserId(note.getUserId());
        // newRecord.setTitle(note.getTitle());
        // newRecord.setDetails(note.getDetails());
        // newRecord.setCreationDate(note.getCreationDate());
        NotesRecord newRecord = new NotesRecord(
            note.getTitle(),
            note.getDetails(),
            note.getCreationDate(),
            note.getEditDate(),
            note.getUserId(),
            note.getId()
        );

        
        ((NotesDatabase)database).getNotesTable().addRecord(newRecord);

        
        return saveChanges();
    }

    public boolean saveChanges() {
        
        NotesTable notesTable = ((NotesDatabase)database).getNotesTable();

        notesTable.clearRecords();

        
        for (Note note : getAll()) {
            // NotesRecord record = new NotesRecord();
            // record.setId(note.getId());
            // record.setUserId(note.getUserId());
            // record.setTitle(note.getTitle());
            // record.setDetails(note.getDetails());
            // record.setCreationDate(note.getCreationDate());
            NotesRecord record = new NotesRecord(
                note.getTitle(), 
                note.getDetails(), 
                note.getCreationDate(),
                note.getEditDate(), 
                note.getUserId(), 
                note.getId()
            );
    

            notesTable.addRecord(record);
        }

        return true;
    }

 
    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }
}
