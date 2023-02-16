package views;

import loggers.ILogger;

import java.time.LocalDateTime;

public class ViewOperationWithLog implements IViewOperations{

    private IViewOperations viewOperations;
    private ILogger iLogger;

    public ViewOperationWithLog(IViewOperations viewOperations, ILogger logger) {
        this.viewOperations = viewOperations;
        this.iLogger = logger;
    }

    private String logText(String method){
        return logText(LocalDateTime.now(), method);
    }

    private String logText(LocalDateTime dateTime, String method){
        String text = String.format("\ndate: %s, method: %s", dateTime.toString(), method);
        return text;
    }

    @Override
    public void read() throws Exception {
        String text = logText("read");
        iLogger.log(text);
        viewOperations.read();
    }

    @Override
    public void delete() throws Exception {
        String text = logText("delete");
        iLogger.log(text);
        viewOperations.delete();
    }

    @Override
    public void update() throws Exception {
        String text = logText("update");
        iLogger.log(text);
        viewOperations.update();
    }

    @Override
    public void list() throws Exception {
        String text = logText("list");
        iLogger.log(text);
        viewOperations.list();
    }

    @Override
    public void create() throws Exception {
        String text = logText("create");
        iLogger.log(text);
        viewOperations.create();
    }

    @Override
    public void showHelp() {
        String text = logText("showHelp");
        iLogger.log(text);
        viewOperations.showHelp();
    }

    @Override
    public String prompt(String message) {
        return viewOperations.prompt(message);
    }
}
