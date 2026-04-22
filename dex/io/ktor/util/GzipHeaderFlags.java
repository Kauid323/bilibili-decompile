package io.ktor.util;

import kotlin.Metadata;

/* compiled from: EncodersJvm.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/ktor/util/GzipHeaderFlags;", "", "<init>", "()V", "", "FTEXT", "I", "FHCRC", "EXTRA", "FNAME", "FCOMMENT", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class GzipHeaderFlags {
    public static final int EXTRA = 4;
    public static final int FCOMMENT = 16;
    public static final int FHCRC = 2;
    public static final int FNAME = 8;
    public static final int FTEXT = 1;
    public static final GzipHeaderFlags INSTANCE = new GzipHeaderFlags();

    private GzipHeaderFlags() {
    }
}