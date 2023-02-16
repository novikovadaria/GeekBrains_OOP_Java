package views;

import controllers.NoteController;
import model.Fields;
import model.Note;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ViewNote {

    private final NoteController noteController;

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run(){
        boolean isContinue = true;
        showHelp();
        while (isContinue){
            try{

                String command = prompt("Введите команду: ");
                Commands com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT){
                    isContinue = false;
                    continue;
                }

                switch (com){
                    case CREATE:
                        create();
                        break;
                    case READ:
                        read();
                        break;
                    case UPDATE:
                        update();
                        break;
                    case LIST:
                        list();
                        break;
                    case HELP:
                        showHelp();
                        break;
                    case DELETE:
                        delete();
                        break;
                }
            }catch (Exception e){
                System.out.println("Произошла ошибка");
            }
        }
    }

    private void read() throws Exception {
        String id = prompt("Идентификатор записи: ");
        Note note = noteController.readNote(id);
        System.out.println(note);
    }

    private void delete() throws Exception{
        String id = prompt("идентификатор записи: ");
        noteController.deleteNote(id);
    }

    private void update() throws Exception {
        String noteId = prompt("Идентификатор записи: ");
        String fieldName = prompt("Какое поле (HEAD, TEXT): ");
        String param = prompt("Введите на то что хотите изменить: ");

        Note note = noteController.readNote(noteId);
        noteController.updateNote(note, Fields.valueOf(fieldName.toUpperCase()), param);
    }

    private void list() throws Exception {
        List<Note> noteList = noteController.getNotes();
        for (Note note : noteList){
            System.out.println(note);
        }
    }
    private void create() throws Exception {
        String head = prompt("Заголовок: ");
        String text = prompt("Текст: ");

        Note note = new Note(head, text);
        noteController.saveNote(note);
    }

    private void showHelp() {
        System.out.println("Список команд:");
        for(Commands c : Commands.values()) {
            System.out.println(c);
        }
    }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
