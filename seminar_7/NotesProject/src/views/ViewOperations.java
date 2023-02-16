package views;

import controllers.IController;
import model.Fields;
import model.Note;

import java.util.List;
import java.util.Scanner;

public class ViewOperations implements IViewOperations{

    private IController noteController;

    public ViewOperations(IController controller) {
        this.noteController = controller;
    }

    public void read() throws Exception {
        String id = prompt("Идентификатор записи: ");
        Note note = noteController.readNote(id);
        System.out.println(note);
    }

    public void delete() throws Exception{
        String id = prompt("идентификатор записи: ");
        noteController.deleteNote(id);
    }

    public void update() throws Exception {
        String noteId = prompt("Идентификатор записи: ");
        String fieldName = prompt("Какое поле (HEAD, TEXT): ");
        String param = prompt("Введите на то что хотите изменить: ");

        Note note = noteController.readNote(noteId);
        noteController.updateNote(note, Fields.valueOf(fieldName.toUpperCase()), param);
    }

    public void list() throws Exception {
        List<Note> noteList = noteController.getNotes();
        for (Note note : noteList){
            System.out.println(note);
        }
    }
    public void create() throws Exception {
        String head = prompt("Заголовок: ");
        String text = prompt("Текст: ");

        Note note = new Note(head, text);
        noteController.saveNote(note);
    }

    public void showHelp(){
        System.out.println("Список команд:");
        for(Commands c : Commands.values()) {
            System.out.println(c);
        }
    }
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
