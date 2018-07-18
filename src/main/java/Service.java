public class Service {

    public void executeBusinessLogic() {

        DAO repo = new DAO();
        repo.findAll();

        OutOfMemory oom = new OutOfMemory();
        oom.trigger();

    }
}
