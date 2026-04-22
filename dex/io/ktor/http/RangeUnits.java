package io.ktor.http;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: Ranges.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/ktor/http/RangeUnits;", "", "", "unitToken", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getUnitToken", "()Ljava/lang/String;", "Bytes", "None", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum RangeUnits {
    Bytes("bytes"),
    None("none");
    
    private final String unitToken;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    RangeUnits(String unitToken) {
        this.unitToken = unitToken;
    }

    public final String getUnitToken() {
        return this.unitToken;
    }

    public static EnumEntries<RangeUnits> getEntries() {
        return $ENTRIES;
    }
}