package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ModifyNameV2.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent;", "", "<init>", "()V", "GetNickNameCopyWriteIntent", "UseAndSubmitIntent", "SaveSubmitIntent", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent$GetNickNameCopyWriteIntent;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent$SaveSubmitIntent;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent$UseAndSubmitIntent;", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class ModifyNameV2Intent {
    public static final int $stable = 0;

    public /* synthetic */ ModifyNameV2Intent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ModifyNameV2Intent() {
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent$GetNickNameCopyWriteIntent;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class GetNickNameCopyWriteIntent extends ModifyNameV2Intent {
        public static final int $stable = 0;
        public static final GetNickNameCopyWriteIntent INSTANCE = new GetNickNameCopyWriteIntent();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GetNickNameCopyWriteIntent) {
                GetNickNameCopyWriteIntent getNickNameCopyWriteIntent = (GetNickNameCopyWriteIntent) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1856651894;
        }

        public String toString() {
            return "GetNickNameCopyWriteIntent";
        }

        private GetNickNameCopyWriteIntent() {
            super(null);
        }
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent$UseAndSubmitIntent;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent;", "name", "", "source", "from", LoginSceneProcessor.SCENE_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getSource", "getFrom", "getScene", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class UseAndSubmitIntent extends ModifyNameV2Intent {
        public static final int $stable = 0;
        private final String from;
        private final String name;
        private final String scene;
        private final String source;

        public static /* synthetic */ UseAndSubmitIntent copy$default(UseAndSubmitIntent useAndSubmitIntent, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = useAndSubmitIntent.name;
            }
            if ((i & 2) != 0) {
                str2 = useAndSubmitIntent.source;
            }
            if ((i & 4) != 0) {
                str3 = useAndSubmitIntent.from;
            }
            if ((i & 8) != 0) {
                str4 = useAndSubmitIntent.scene;
            }
            return useAndSubmitIntent.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.source;
        }

        public final String component3() {
            return this.from;
        }

        public final String component4() {
            return this.scene;
        }

        public final UseAndSubmitIntent copy(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "source");
            return new UseAndSubmitIntent(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UseAndSubmitIntent) {
                UseAndSubmitIntent useAndSubmitIntent = (UseAndSubmitIntent) obj;
                return Intrinsics.areEqual(this.name, useAndSubmitIntent.name) && Intrinsics.areEqual(this.source, useAndSubmitIntent.source) && Intrinsics.areEqual(this.from, useAndSubmitIntent.from) && Intrinsics.areEqual(this.scene, useAndSubmitIntent.scene);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.source.hashCode()) * 31) + (this.from == null ? 0 : this.from.hashCode())) * 31) + (this.scene != null ? this.scene.hashCode() : 0);
        }

        public String toString() {
            String str = this.name;
            String str2 = this.source;
            String str3 = this.from;
            return "UseAndSubmitIntent(name=" + str + ", source=" + str2 + ", from=" + str3 + ", scene=" + this.scene + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UseAndSubmitIntent(String name, String source, String from, String scene) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(source, "source");
            this.name = name;
            this.source = source;
            this.from = from;
            this.scene = scene;
        }

        public final String getName() {
            return this.name;
        }

        public final String getSource() {
            return this.source;
        }

        public final String getFrom() {
            return this.from;
        }

        public final String getScene() {
            return this.scene;
        }
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent$SaveSubmitIntent;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SaveSubmitIntent extends ModifyNameV2Intent {
        public static final int $stable = 0;
        private final String name;

        public static /* synthetic */ SaveSubmitIntent copy$default(SaveSubmitIntent saveSubmitIntent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = saveSubmitIntent.name;
            }
            return saveSubmitIntent.copy(str);
        }

        public final String component1() {
            return this.name;
        }

        public final SaveSubmitIntent copy(String str) {
            return new SaveSubmitIntent(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SaveSubmitIntent) && Intrinsics.areEqual(this.name, ((SaveSubmitIntent) obj).name);
        }

        public int hashCode() {
            if (this.name == null) {
                return 0;
            }
            return this.name.hashCode();
        }

        public String toString() {
            return "SaveSubmitIntent(name=" + this.name + ")";
        }

        public SaveSubmitIntent(String name) {
            super(null);
            this.name = name;
        }

        public final String getName() {
            return this.name;
        }
    }
}