package views;

public interface IViewOperations {

    public void read() throws Exception;

    public void delete() throws Exception;

    public void update() throws Exception;

    public void list() throws Exception;

    public void create() throws Exception;

    public void showHelp();

    public String prompt(String message);

}
