package controllers;

import model.Fields;
import model.Note;

import java.util.List;

public interface IController {

    public void saveNote(Note note) throws Exception;

    public void deleteNote(String noteId) throws Exception;

    public void updateNote(Note note, Fields field, Object param) throws Exception;

    public Note readNote(String noteId) throws Exception;

    public List<Note> getNotes() throws Exception;

    public Note getNoteById(String noteId) throws Exception;

}
