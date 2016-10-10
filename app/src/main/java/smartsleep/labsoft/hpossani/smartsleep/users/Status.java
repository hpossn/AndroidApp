package smartsleep.labsoft.hpossani.smartsleep.users;

/**
 * Created by hpossani on 10/10/16.
 */

public class Status {
    private User user;
    private boolean logado;

    public Status(User user, boolean logado) {
        this.user = user;
        this.logado = logado;
    }

    public void logar() {
        this.logado = true;
    }

    public void logout() {
        this.logado = false;
    }

    public boolean isLogado() {
        return logado;
    }
}
