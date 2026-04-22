package kntr.base.apm.network.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.SharedPreferences;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NetworkMetricsAggregator.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0017\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001a\u0010\u0013¨\u0006!"}, d2 = {"Lkntr/base/apm/network/internal/LocalConfig;", "", "<init>", "()V", "sp", "Lkntr/base/config/SharedPreferences;", "repeatCount", "", "getRepeatCount", "()I", "repeatInterval", "getRepeatInterval", "reportTimes", "", "getReportTimes", "()Ljava/util/Set;", "enableSDK", "", "getEnableSDK", "()Z", "enableSDK$delegate", "Lkotlin/Lazy;", "enableFirstLaunchProperty", "getEnableFirstLaunchProperty", "enableFirstLaunchProperty$delegate", "processAllowed", "getProcessAllowed", "processAllowed$delegate", "updateLocalConfig", "", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/base/config/IPlatformConfig;", "Key", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalConfig {
    private final Lazy enableFirstLaunchProperty$delegate;
    private final Lazy enableSDK$delegate;
    private final Lazy processAllowed$delegate;
    private final int repeatCount;
    private final int repeatInterval;
    private final Set<Integer> reportTimes;
    private final SharedPreferences sp = new SharedPreferences("kntr-base-preferences", true);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NetworkMetricsAggregator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0010"}, d2 = {"Lkntr/base/apm/network/internal/LocalConfig$Key;", "", "raw", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "DisableSDK", "AllowProcessNames", "RepeatInterval", "RepeatCount", "ReportTimes", "DisableFirstLaunchProperty", "value", "getValue", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum Key {
        DisableSDK("disable_sdk"),
        AllowProcessNames("allow_process_names"),
        RepeatInterval("repeat_interval"),
        RepeatCount("repeat_count"),
        ReportTimes("report_times"),
        DisableFirstLaunchProperty("disable_first_launch_property");
        
        private final String raw;
        private final String value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Key> getEntries() {
            return $ENTRIES;
        }

        Key(String raw) {
            this.raw = raw;
            this.value = "net.metrics.aggregator." + this.raw;
        }

        public final String getRaw() {
            return this.raw;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public LocalConfig() {
        Set<Integer> set;
        Integer intOrNull;
        Integer intOrNull2;
        String string$default = SharedPreferences.getString$default(this.sp, Key.RepeatCount.getValue(), null, 2, null);
        this.repeatCount = (string$default == null || (intOrNull2 = StringsKt.toIntOrNull(string$default)) == null) ? 30 : intOrNull2.intValue();
        String string$default2 = SharedPreferences.getString$default(this.sp, Key.RepeatInterval.getValue(), null, 2, null);
        this.repeatInterval = (string$default2 == null || (intOrNull = StringsKt.toIntOrNull(string$default2)) == null) ? 10 : intOrNull.intValue();
        set = NetworkMetricsAggregatorKt.getSet(this.sp, Key.ReportTimes.getValue(), SetsKt.setOf(new Integer[]{20, 300}), new Function1() { // from class: kntr.base.apm.network.internal.LocalConfig$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Integer reportTimes$lambda$0;
                reportTimes$lambda$0 = LocalConfig.reportTimes$lambda$0((String) obj);
                return reportTimes$lambda$0;
            }
        });
        this.reportTimes = set;
        this.enableSDK$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.apm.network.internal.LocalConfig$$ExternalSyntheticLambda2
            public final Object invoke() {
                boolean enableSDK_delegate$lambda$0;
                enableSDK_delegate$lambda$0 = LocalConfig.enableSDK_delegate$lambda$0(LocalConfig.this);
                return Boolean.valueOf(enableSDK_delegate$lambda$0);
            }
        });
        this.enableFirstLaunchProperty$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.apm.network.internal.LocalConfig$$ExternalSyntheticLambda3
            public final Object invoke() {
                boolean enableFirstLaunchProperty_delegate$lambda$0;
                enableFirstLaunchProperty_delegate$lambda$0 = LocalConfig.enableFirstLaunchProperty_delegate$lambda$0(LocalConfig.this);
                return Boolean.valueOf(enableFirstLaunchProperty_delegate$lambda$0);
            }
        });
        this.processAllowed$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.apm.network.internal.LocalConfig$$ExternalSyntheticLambda4
            public final Object invoke() {
                boolean processAllowed_delegate$lambda$0;
                processAllowed_delegate$lambda$0 = LocalConfig.processAllowed_delegate$lambda$0(LocalConfig.this);
                return Boolean.valueOf(processAllowed_delegate$lambda$0);
            }
        });
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public final int getRepeatInterval() {
        return this.repeatInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer reportTimes$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.toIntOrNull(it);
    }

    public final Set<Integer> getReportTimes() {
        return this.reportTimes;
    }

    public final boolean getEnableSDK() {
        return ((Boolean) this.enableSDK$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableSDK_delegate$lambda$0(LocalConfig this$0) {
        String str = null;
        String string$default = SharedPreferences.getString$default(this$0.sp, Key.DisableSDK.getValue(), null, 2, null);
        if (string$default != null) {
            str = string$default.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        boolean disabled = Intrinsics.areEqual(str, "true");
        if (disabled) {
            return false;
        }
        return this$0.getProcessAllowed();
    }

    public final boolean getEnableFirstLaunchProperty() {
        return ((Boolean) this.enableFirstLaunchProperty$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableFirstLaunchProperty_delegate$lambda$0(LocalConfig this$0) {
        String str = null;
        String string$default = SharedPreferences.getString$default(this$0.sp, Key.DisableFirstLaunchProperty.getValue(), null, 2, null);
        if (string$default != null) {
            str = string$default.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        boolean disabled = Intrinsics.areEqual(str, "true");
        if (disabled) {
            return false;
        }
        return this$0.getProcessAllowed();
    }

    private final boolean getProcessAllowed() {
        return ((Boolean) this.processAllowed$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean processAllowed_delegate$lambda$0(LocalConfig this$0) {
        Set allowProcessNames;
        allowProcessNames = NetworkMetricsAggregatorKt.getSet(this$0.sp, Key.AllowProcessNames.getValue(), SetsKt.setOf("*"), new Function1() { // from class: kntr.base.apm.network.internal.LocalConfig$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return LocalConfig.processAllowed_delegate$lambda$0$0((String) obj);
            }
        });
        return allowProcessNames.contains(Utils_androidKt.getCurrentProcessName()) || allowProcessNames.contains("*");
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String processAllowed_delegate$lambda$0$0(java.lang.String r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.base.apm.network.internal.LocalConfig.processAllowed_delegate$lambda$0$0(java.lang.String):java.lang.String");
    }

    public final void updateLocalConfig(IPlatformConfig config) {
        Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
        Iterable $this$map$iv = Key.getEntries();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Key it = (Key) item$iv$iv;
            destination$iv$iv.add(it.getValue());
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            String key = (String) element$iv;
            SharedPreferences sharedPreferences = this.sp;
            String config$default = IPlatformConfig.CC.config$default(config, key, null, 2, null);
            if (config$default == null) {
                config$default = "";
            }
            sharedPreferences.setString(key, config$default);
        }
    }
}