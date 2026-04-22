package tv.danmaku.ijk.media.player;

import java.io.File;

public interface IjkLibLoader {
    File findLibrary(String str);

    void loadLibrary(String str) throws UnsatisfiedLinkError, SecurityException;
}