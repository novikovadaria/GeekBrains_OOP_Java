import controllers.AdapterController;
import controllers.IController;
import controllers.NoteController;
import loggers.ILogger;
import loggers.Logger;
import model.*;
import views.*;

public class Main {
    public static void main(String[] args) {
        ILogger logger = new Logger("log.txt");
        IFileOperation fileOperation = new FileOperation("notes.txt");
        IRepository repository = new Repository(new NotesMapperJSON(), fileOperation);
        IController controller = new AdapterController(repository);
        IViewOperations viewOperations = new ViewOperations(controller);
        IViewOperations viewOperationsWithLog = new ViewOperationWithLog(viewOperations, logger);
        IViewNote view = new ViewNote(viewOperationsWithLog);
        view.run();
    }
}