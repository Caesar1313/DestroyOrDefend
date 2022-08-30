package DestroyOrDefend;

public interface Behave {
    void attack(Forces obj) throws InterruptedException;
    void attack(Base obj) throws InterruptedException;
    void upgrade();
}
