package jdbc.project.dao;

public interface UserDao {
    void findAll();

    void login(String name, String password);

    void loginPrepared(String name, String password);

    void insert(String name, String password);

    void delete(int id);

    void update(String newName, String newPassword, int whichId);
}
