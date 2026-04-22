package tv.danmaku.biliplayer.preload.repository;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PreloadElement.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadPriority;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "compareTo", "other", "compareTo-E-Jy1Qw", "(II)I", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@JvmInline
public final class PreloadPriority implements Comparable<PreloadPriority> {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int LevelH = m2147constructorimpl(1);
    private static final int Level1 = m2147constructorimpl(2);
    private static final int Level2 = m2147constructorimpl(3);
    private static final int Level3 = m2147constructorimpl(4);
    private static final int Level4 = m2147constructorimpl(5);
    private static final int LevelL = m2147constructorimpl(6);
    private static final int Default = m2147constructorimpl(7);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PreloadPriority m2145boximpl(int i) {
        return new PreloadPriority(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m2147constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2148equalsimpl(int i, Object obj) {
        return (obj instanceof PreloadPriority) && i == ((PreloadPriority) obj).m2153unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2149equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2150hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2151toStringimpl(int i) {
        return "PreloadPriority(value=" + i + ")";
    }

    public boolean equals(Object obj) {
        return m2148equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2150hashCodeimpl(this.value);
    }

    public String toString() {
        return m2151toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2153unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(PreloadPriority preloadPriority) {
        return m2152compareToEJy1Qw(preloadPriority.m2153unboximpl());
    }

    private /* synthetic */ PreloadPriority(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: compareTo-E-Jy1Qw  reason: not valid java name */
    public int m2152compareToEJy1Qw(int other) {
        return m2146compareToEJy1Qw(this.value, other);
    }

    /* renamed from: compareTo-E-Jy1Qw  reason: not valid java name */
    public static int m2146compareToEJy1Qw(int i, int i2) {
        return Intrinsics.compare(i, i2);
    }

    /* compiled from: PreloadElement.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadPriority$Companion;", "", "<init>", "()V", "LevelH", "Ltv/danmaku/biliplayer/preload/repository/PreloadPriority;", "getLevelH-3gV422k", "()I", "I", "Level1", "getLevel1-3gV422k", "Level2", "getLevel2-3gV422k", "Level3", "getLevel3-3gV422k", "Level4", "getLevel4-3gV422k", "LevelL", "getLevelL-3gV422k", "Default", "getDefault-3gV422k", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getLevelH-3gV422k  reason: not valid java name */
        public final int m2159getLevelH3gV422k() {
            return PreloadPriority.LevelH;
        }

        /* renamed from: getLevel1-3gV422k  reason: not valid java name */
        public final int m2155getLevel13gV422k() {
            return PreloadPriority.Level1;
        }

        /* renamed from: getLevel2-3gV422k  reason: not valid java name */
        public final int m2156getLevel23gV422k() {
            return PreloadPriority.Level2;
        }

        /* renamed from: getLevel3-3gV422k  reason: not valid java name */
        public final int m2157getLevel33gV422k() {
            return PreloadPriority.Level3;
        }

        /* renamed from: getLevel4-3gV422k  reason: not valid java name */
        public final int m2158getLevel43gV422k() {
            return PreloadPriority.Level4;
        }

        /* renamed from: getLevelL-3gV422k  reason: not valid java name */
        public final int m2160getLevelL3gV422k() {
            return PreloadPriority.LevelL;
        }

        /* renamed from: getDefault-3gV422k  reason: not valid java name */
        public final int m2154getDefault3gV422k() {
            return PreloadPriority.Default;
        }
    }
}