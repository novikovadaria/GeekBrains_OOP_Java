package model;

import java.util.List;

public class Repository implements IRepository {

    private NotesMapper mapper;
    private IFileOperation fileOperation;

    public Repository(NotesMapper mapper, IFileOperation fileOperation) {
        this.mapper = mapper;
        this.fileOperation = fileOperation;
    }

    public Repository(IFileOperation fileOperation) {
        this(new NotesMapperJSON(), fileOperation);
    }

    @Override
    public List<Note> getAllNotes() throws Exception{
        String text = fileOperation.readText();
        List<Note> notes = mapper.map(text);
        return notes;
    }

    @Override
    public String createNote(Note note) throws Exception{

        List<Note> notes = getAllNotes();
        int maxId = 0;
        for (Note currentNote : notes){
            int id = Integer.parseInt(currentNote.getId());
            if (maxId < id){
                maxId = id;
            }
        }
        int newId = maxId + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);

        String text = mapper.map(notes);
        fileOperation.saveText(text);

        return id;

    }

    @Override
    public void updateNote(Note note, Fields field, Object param) throws Exception{
        if (field == Fields.HEAD){
            note.setHead((String) param);
        } else if (field == Fields.TEXT) {
            note.setText((String) param);
        }

        saveNote(note);
    }

    @Override
    public void deleteNote(Note note) throws Exception{
        List<Note> list = getAllNotes();

        int findIndex = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(note.getId())){
                findIndex = i;
                break;
            }
        }

        if (findIndex > -1){
            list.remove(findIndex);
        }

        String text = mapper.map(list);
        fileOperation.saveText(text);

    }

    @Override
    public void saveNote(Note note) throws Exception{

        if (note == null){
            return;
        }

        List<Note> list = getAllNotes();

        for (int i = 0; i < list.size(); i++) {
            Note currentNote = list.get(i);
            if (currentNote.getId().equals(note.getId())){
                list.set(i, note);
                break;
            }
        }

        String text = mapper.map(list);
        fileOperation.saveText(text);

    }


}
