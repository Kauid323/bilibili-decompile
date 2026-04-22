package video.biz.offline.base.infra.storage.diskfile;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: IDiskFile.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileType;", "", "<init>", "()V", "RootDir", "TaskJson", "Video", "Audio", "Cover", PlayerLogModule.Danmaku, "Index", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Audio;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Cover;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Danmaku;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Index;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType$RootDir;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType$TaskJson;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Video;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class FileType {
    public static final int $stable = 0;

    public /* synthetic */ FileType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: IDiskFile.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileType$RootDir;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class RootDir extends FileType {
        public static final int $stable = 0;
        public static final RootDir INSTANCE = new RootDir();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RootDir) {
                RootDir rootDir = (RootDir) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1393211469;
        }

        public String toString() {
            return "RootDir";
        }

        private RootDir() {
            super(null);
        }
    }

    private FileType() {
    }

    /* compiled from: IDiskFile.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileType$TaskJson;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class TaskJson extends FileType {
        public static final int $stable = 0;
        public static final TaskJson INSTANCE = new TaskJson();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TaskJson) {
                TaskJson taskJson = (TaskJson) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -482985563;
        }

        public String toString() {
            return "TaskJson";
        }

        private TaskJson() {
            super(null);
        }
    }

    /* compiled from: IDiskFile.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Video;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType;", "isDash", "", "index", "", "<init>", "(ZI)V", "()Z", "getIndex", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Video extends FileType {
        public static final int $stable = 0;
        private final int index;
        private final boolean isDash;

        public static /* synthetic */ Video copy$default(Video video2, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = video2.isDash;
            }
            if ((i2 & 2) != 0) {
                i = video2.index;
            }
            return video2.copy(z, i);
        }

        public final boolean component1() {
            return this.isDash;
        }

        public final int component2() {
            return this.index;
        }

        public final Video copy(boolean z, int i) {
            return new Video(z, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Video) {
                Video video2 = (Video) obj;
                return this.isDash == video2.isDash && this.index == video2.index;
            }
            return false;
        }

        public int hashCode() {
            return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isDash) * 31) + this.index;
        }

        public String toString() {
            boolean z = this.isDash;
            return "Video(isDash=" + z + ", index=" + this.index + ")";
        }

        public Video(boolean isDash, int index) {
            super(null);
            this.isDash = isDash;
            this.index = index;
        }

        public final boolean isDash() {
            return this.isDash;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    /* compiled from: IDiskFile.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Audio;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType;", "isDash", "", "index", "", "<init>", "(ZI)V", "()Z", "getIndex", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Audio extends FileType {
        public static final int $stable = 0;
        private final int index;
        private final boolean isDash;

        public static /* synthetic */ Audio copy$default(Audio audio, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = audio.isDash;
            }
            if ((i2 & 2) != 0) {
                i = audio.index;
            }
            return audio.copy(z, i);
        }

        public final boolean component1() {
            return this.isDash;
        }

        public final int component2() {
            return this.index;
        }

        public final Audio copy(boolean z, int i) {
            return new Audio(z, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Audio) {
                Audio audio = (Audio) obj;
                return this.isDash == audio.isDash && this.index == audio.index;
            }
            return false;
        }

        public int hashCode() {
            return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isDash) * 31) + this.index;
        }

        public String toString() {
            boolean z = this.isDash;
            return "Audio(isDash=" + z + ", index=" + this.index + ")";
        }

        public Audio(boolean isDash, int index) {
            super(null);
            this.isDash = isDash;
            this.index = index;
        }

        public final boolean isDash() {
            return this.isDash;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    /* compiled from: IDiskFile.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Cover;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Cover extends FileType {
        public static final int $stable = 0;
        public static final Cover INSTANCE = new Cover();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Cover) {
                Cover cover = (Cover) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 543362335;
        }

        public String toString() {
            return "Cover";
        }

        private Cover() {
            super(null);
        }
    }

    /* compiled from: IDiskFile.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Danmaku;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType;", "isNew", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Danmaku extends FileType {
        public static final int $stable = 0;
        private final boolean isNew;

        public static /* synthetic */ Danmaku copy$default(Danmaku danmaku, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = danmaku.isNew;
            }
            return danmaku.copy(z);
        }

        public final boolean component1() {
            return this.isNew;
        }

        public final Danmaku copy(boolean z) {
            return new Danmaku(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Danmaku) && this.isNew == ((Danmaku) obj).isNew;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isNew);
        }

        public String toString() {
            return "Danmaku(isNew=" + this.isNew + ")";
        }

        public Danmaku(boolean isNew) {
            super(null);
            this.isNew = isNew;
        }

        public final boolean isNew() {
            return this.isNew;
        }
    }

    /* compiled from: IDiskFile.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileType$Index;", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Index extends FileType {
        public static final int $stable = 0;
        public static final Index INSTANCE = new Index();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Index) {
                Index index = (Index) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 548856378;
        }

        public String toString() {
            return "Index";
        }

        private Index() {
            super(null);
        }
    }
}