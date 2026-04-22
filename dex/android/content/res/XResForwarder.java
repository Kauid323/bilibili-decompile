package android.content.res;

public class XResForwarder {
    private final int id;
    private final Resources res;

    public XResForwarder(Resources res, int id) {
        this.res = res;
        this.id = id;
    }

    public Resources getResources() {
        return this.res;
    }

    public int getId() {
        return this.id;
    }
}