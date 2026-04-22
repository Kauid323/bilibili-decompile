package bvc_sdk.xcode_tools;

import com.ashampoo.xmp.internal.XMPRDFWriter;
import java.util.Arrays;

public class BvcXcodeKeyFrames {
    private long capacity;
    private BvcXcodeKeyFrame[] key_frames;
    private long size;

    public BvcXcodeKeyFrame[] getKeyFrames() {
        return this.key_frames;
    }

    public long getSize() {
        return this.size;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public String toString() {
        return "BvcXcodeKeyFrames：\n\tkey_frames=" + Arrays.toString(this.key_frames).replaceAll("\t", "\t\t") + "\n\tsize=" + this.size + "\n\tcapacity=" + this.capacity + XMPRDFWriter.XMP_DEFAULT_NEWLINE;
    }

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class BvcXcodeKeyFrame {
        private long pos;
        private long pts;
        private double pts_time;

        public long getPts() {
            return this.pts;
        }

        public double getPtsTime() {
            return this.pts_time;
        }

        public long getPos() {
            return this.pos;
        }

        public String toString() {
            return "BvcXcodeKeyFrame\n\tpts='" + this.pts + "'\n\tpts_time='" + this.pts_time + "'\n\tpos='" + this.pos + '\'' + XMPRDFWriter.XMP_DEFAULT_NEWLINE;
        }
    }
}