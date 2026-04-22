package video.biz.offline.base.infra.utils;

import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Neuron.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/base/infra/utils/OfflineTrackType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DATAMIGRATE", "DOWNLOAD", "HITKMPOFFLINE", "HITKMPOFFLINERESET", "LOADTASKFILE", "MIGRATEDATA", "LISTLOADINGCOST", "TASKGROUP", "inTrackSampler", "", "getInTrackSampler", "()Z", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum OfflineTrackType {
    DATAMIGRATE("data_migrate"),
    DOWNLOAD("download"),
    HITKMPOFFLINE("hit_kmp_offline"),
    HITKMPOFFLINERESET("hit_kmp_offline_reset"),
    LOADTASKFILE("load_task_file"),
    MIGRATEDATA("migrate_success"),
    LISTLOADINGCOST("list_loading_cost"),
    TASKGROUP("task_group_download");
    
    private final String type;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* compiled from: Neuron.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineTrackType.values().length];
            try {
                iArr[OfflineTrackType.DATAMIGRATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineTrackType.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OfflineTrackType.HITKMPOFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[OfflineTrackType.HITKMPOFFLINERESET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[OfflineTrackType.LOADTASKFILE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[OfflineTrackType.MIGRATEDATA.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[OfflineTrackType.LISTLOADINGCOST.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[OfflineTrackType.TASKGROUP.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<OfflineTrackType> getEntries() {
        return $ENTRIES;
    }

    OfflineTrackType(String type) {
        this.type = type;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getInTrackSampler() {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 5:
            case 6:
                return true;
            case 2:
                String config$default = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, NeuronKt.DOWNLOAD_SAMPLER, (String) null, 2, (Object) null);
                if (config$default == null || (intOrNull = StringsKt.toIntOrNull(config$default)) == null) {
                    return true;
                }
                int it = intOrNull.intValue();
                return Random.Default.nextInt(it) == it + (-1);
            case 3:
                String config$default2 = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, NeuronKt.HIT_KMP_OFFLINE_SAMPLER, (String) null, 2, (Object) null);
                if (config$default2 == null || (intOrNull2 = StringsKt.toIntOrNull(config$default2)) == null) {
                    return true;
                }
                int it2 = intOrNull2.intValue();
                return Random.Default.nextInt(it2) == it2 + (-1);
            case 4:
                String config$default3 = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, NeuronKt.HIT_KMP_OFFLINE_RESET_SAMPLER, (String) null, 2, (Object) null);
                if (config$default3 == null || (intOrNull3 = StringsKt.toIntOrNull(config$default3)) == null) {
                    return true;
                }
                int it3 = intOrNull3.intValue();
                return Random.Default.nextInt(it3) == it3 + (-1);
            case 7:
                String config$default4 = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, NeuronKt.LIST_LOAD_COST_SAMPLER, (String) null, 2, (Object) null);
                if (config$default4 == null || (intOrNull4 = StringsKt.toIntOrNull(config$default4)) == null) {
                    return true;
                }
                int it4 = intOrNull4.intValue();
                return Random.Default.nextInt(it4) == it4 + (-1);
            case 8:
                String config$default5 = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, NeuronKt.DOWNLOAD_SAMPLER, (String) null, 2, (Object) null);
                if (config$default5 == null || (intOrNull5 = StringsKt.toIntOrNull(config$default5)) == null) {
                    return true;
                }
                int it5 = intOrNull5.intValue();
                return Random.Default.nextInt(it5) == it5 + (-1);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}