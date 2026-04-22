package im.direct.notification.interactive;

import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INStateHolder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lim/direct/notification/interactive/INPageType;", "", "pageName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPageName", "()Ljava/lang/String;", "Reply", "Like", "Companion", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum INPageType {
    Reply("reply"),
    Like("like");
    
    private final String pageName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<INPageType> getEntries() {
        return $ENTRIES;
    }

    INPageType(String pageName) {
        this.pageName = pageName;
    }

    public final String getPageName() {
        return this.pageName;
    }

    /* compiled from: INStateHolder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lim/direct/notification/interactive/INPageType$Companion;", "", "<init>", "()V", "fromName", "Lim/direct/notification/interactive/INPageType;", ContentDisposition.Parameters.Name, "", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final INPageType fromName(String name) {
            Object obj;
            Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
            Iterator it = INPageType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                INPageType it2 = (INPageType) obj;
                if (Intrinsics.areEqual(it2.getPageName(), name)) {
                    break;
                }
            }
            return (INPageType) obj;
        }
    }
}