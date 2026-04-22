package bvc_sdk.xcode_tools;

public class BvcXcodeTools {
    public static final int PARSE_PACKETS_OFF = 0;
    public static final int PARSE_PACKETS_ON = 1;

    private static native BvcXcodeMoovBox bvcMoovBox(String str);

    private static native BvcXcodeKeyFrames keyFrames(String str);

    private static native BvcXcodeProbeMeta xcodeProbe(String str, int i);

    static {
        System.loadLibrary("bvc-xcode-tools");
    }

    public static BvcXcodeProbeMeta bvcXcodeProbe(String pathname, int parsePackets) {
        return xcodeProbe(pathname, parsePackets);
    }

    public static BvcXcodeKeyFrames bvcXcodeKeyFrames(String pathname) {
        return keyFrames(pathname);
    }

    public static BvcXcodeMoovBox bvcXcodeMoovBox(String pathname) {
        return bvcMoovBox(pathname);
    }
}