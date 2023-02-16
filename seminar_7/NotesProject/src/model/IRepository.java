package model;

import java.util.List;

public interface IRepository {

    List<Note> getAllNotes() throws Exception;
    String createNote(Note note) throws Exception;
    void updateNote(Note note, Fields field, Object param) throws Exception;

    void deleteNote(Note note) throws Exception;

    void saveNote(Note note) throws Exception;

}
