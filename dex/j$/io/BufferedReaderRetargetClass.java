package j$.io;

import j$.util.stream.Stream;
import java.io.BufferedReader;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BufferedReaderRetargetClass {
    public static /* synthetic */ Stream lines(BufferedReader bufferedReader) {
        return bufferedReader instanceof BufferedReaderRetargetInterface ? ((BufferedReaderRetargetInterface) bufferedReader).lines() : DesugarBufferedReader.lines(bufferedReader);
    }
}