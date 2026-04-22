package tv.danmaku.bili.videopage.common.helper;

import android.content.SharedPreferences;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoDetailsSharedPreferences.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/FavGuidePref;", "", "<init>", "()V", "defaultPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isExposed", "", "key", "Ltv/danmaku/bili/videopage/common/helper/FavGuidePref$FavGuideKey;", "isExposed-7MNBA5M", "(Ljava/lang/String;)Z", "saveExposed", "", "saveExposed-7MNBA5M", "(Ljava/lang/String;)V", "FavGuideKey", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FavGuidePref {
    public static final FavGuidePref INSTANCE = new FavGuidePref();
    private static final SharedPreferences defaultPref = BiliGlobalPreferenceHelper.getBLKVSharedPreference(FoundationAlias.getFapp());

    private FavGuidePref() {
    }

    /* renamed from: isExposed-7MNBA5M  reason: not valid java name */
    public final boolean m1949isExposed7MNBA5M(String str) {
        Intrinsics.checkNotNullParameter(str, "$v$c$tv-danmaku-bili-videopage-common-helper-FavGuidePref-FavGuideKey$-key$0");
        return defaultPref.getBoolean(str, false);
    }

    /* renamed from: saveExposed-7MNBA5M  reason: not valid java name */
    public final void m1950saveExposed7MNBA5M(String str) {
        Intrinsics.checkNotNullParameter(str, "$v$c$tv-danmaku-bili-videopage-common-helper-FavGuidePref-FavGuideKey$-key$0");
        SharedPreferences $this$edit_u24default$iv = defaultPref;
        Intrinsics.checkNotNullExpressionValue($this$edit_u24default$iv, "defaultPref");
        SharedPreferences.Editor editor$iv = $this$edit_u24default$iv.edit();
        editor$iv.putBoolean(str, true);
        editor$iv.apply();
    }

    /* compiled from: VideoDetailsSharedPreferences.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/FavGuidePref$FavGuideKey;", "", "pref", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getPref", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @JvmInline
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class FavGuideKey {
        private final String pref;
        public static final Companion Companion = new Companion(null);
        private static final String unite = m1952constructorimpl("pref_key_fav_guide_exposed_unite");
        private static final String story = m1952constructorimpl("pref_key_fav_guide_exposed_story");
        private static final String podcast = m1952constructorimpl("pref_key_fav_guide_exposed_podcast");

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ FavGuideKey m1951boximpl(String str) {
            return new FavGuideKey(str);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static String m1952constructorimpl(String str) {
            Intrinsics.checkNotNullParameter(str, "pref");
            return str;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m1953equalsimpl(String str, Object obj) {
            return (obj instanceof FavGuideKey) && Intrinsics.areEqual(str, ((FavGuideKey) obj).m1957unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1954equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1955hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1956toStringimpl(String str) {
            return "FavGuideKey(pref=" + str + ")";
        }

        public boolean equals(Object obj) {
            return m1953equalsimpl(this.pref, obj);
        }

        public int hashCode() {
            return m1955hashCodeimpl(this.pref);
        }

        public String toString() {
            return m1956toStringimpl(this.pref);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ String m1957unboximpl() {
            return this.pref;
        }

        /* compiled from: VideoDetailsSharedPreferences.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/FavGuidePref$FavGuideKey$Companion;", "", "<init>", "()V", "unite", "Ltv/danmaku/bili/videopage/common/helper/FavGuidePref$FavGuideKey;", "getUnite-86Ftn0E", "()Ljava/lang/String;", "Ljava/lang/String;", "story", "getStory-86Ftn0E", "podcast", "getPodcast-86Ftn0E", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getUnite-86Ftn0E  reason: not valid java name */
            public final String m1960getUnite86Ftn0E() {
                return FavGuideKey.unite;
            }

            /* renamed from: getStory-86Ftn0E  reason: not valid java name */
            public final String m1959getStory86Ftn0E() {
                return FavGuideKey.story;
            }

            /* renamed from: getPodcast-86Ftn0E  reason: not valid java name */
            public final String m1958getPodcast86Ftn0E() {
                return FavGuideKey.podcast;
            }
        }

        private /* synthetic */ FavGuideKey(String pref) {
            this.pref = pref;
        }

        public final String getPref() {
            return this.pref;
        }
    }
}