package mvc.model;

public class Client implements Comparable<Client> {
    private int id;
    private final int timpSosire;
    private int timpServire;

    public Client(int timpSosire, int timpServire) {
        this.timpSosire = timpSosire;
        this.timpServire = timpServire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getTimpSosire() {
        return timpSosire;
    }

    public int getTimpServire() {
        return timpServire;
    }

    public void decreaseTimpServire() {
        timpServire--;
    }

    @Override
    public int compareTo(Client client) {
        if (this.timpSosire < client.timpSosire)
            return -1;
        else if (this.timpSosire > client.timpSosire)
            return 1;
        return 0;
    }
}