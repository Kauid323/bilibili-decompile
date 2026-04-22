package bvc_sdk.xcode_tools;

public class BvcXcodeMoovBox {
    private long offset;
    private long size;

    public long getOffset() {
        return this.offset;
    }

    public long getSize() {
        return this.size;
    }

    public String toString() {
        return "BvcXcodeMoovBox:\n\toffset=" + this.offset + "\n\tsize=" + this.size;
    }
}