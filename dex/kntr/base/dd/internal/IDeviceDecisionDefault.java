package kntr.base.dd.internal;

import java.util.Locale;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDeviceDecisionDefault.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/internal/IDeviceDecisionDefault;", "", "get", "", "key", "Lkntr/base/dd/internal/IDeviceDecisionDefault$Key;", "set", "", "value", "Key", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDeviceDecisionDefault {
    String get(Key key);

    void set(Key key, String str);

    /* compiled from: IDeviceDecisionDefault.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lkntr/base/dd/internal/IDeviceDecisionDefault$Key;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "KDDAppDisabled", "ObservablePropName", "DDFawkesHost", "Companion", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum Key {
        KDDAppDisabled("dd.default.app_disable_kntr_impl"),
        ObservablePropName("dd.default.observable.props"),
        DDFawkesHost("dd.default.update_host");
        
        private final String rawValue;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
        public static final Companion Companion = new Companion(null);

        public static EnumEntries<Key> getEntries() {
            return $ENTRIES;
        }

        Key(String rawValue) {
            this.rawValue = rawValue;
        }

        public final String getRawValue() {
            return this.rawValue;
        }

        /* compiled from: IDeviceDecisionDefault.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/dd/internal/IDeviceDecisionDefault$Key$Companion;", "", "<init>", "()V", "fromString", "Lkntr/base/dd/internal/IDeviceDecisionDefault$Key;", "value", "", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Key fromString(String value) {
                String v;
                Key[] values;
                if (value != null) {
                    v = value.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(v, "toLowerCase(...)");
                } else {
                    v = null;
                }
                for (Key it : Key.values()) {
                    if (Intrinsics.areEqual(it.getRawValue(), v)) {
                        return it;
                    }
                }
                return null;
            }
        }
    }
}