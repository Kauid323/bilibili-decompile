package io.ktor.client.plugins.cache;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: HttpCacheEntry.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/client/plugins/cache/ValidateStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ShouldValidate", "ShouldNotValidate", "ShouldWarn", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum ValidateStatus {
    ShouldValidate,
    ShouldNotValidate,
    ShouldWarn;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ValidateStatus> getEntries() {
        return $ENTRIES;
    }
}