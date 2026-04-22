package tv.danmaku.bili.auth;

import android.net.Uri;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.dd.DeviceDecision;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthExts.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0016\u001a\n\u0010\u0017\u001a\u00020\u0016*\u00020\u0016\u001a\n\u0010\u0018\u001a\u00020\u0002*\u00020\u0019\u001a\n\u0010\u001a\u001a\u00020\u0002*\u00020\u0019\u001a\n\u0010\u001b\u001a\u00020\u0002*\u00020\u0019\u001a\u0012\u0010\u001c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004\"\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\r\"\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\r\"!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u001e"}, d2 = {"sourceEventMidCheckList", "", "", "getSourceEventMidCheckList", "()Ljava/util/List;", "sourceEventMidCheckList$delegate", "Lkotlin/Lazy;", "sourceEventFacialOnlyMidCheckList", "getSourceEventFacialOnlyMidCheckList", "sourceEventFacialOnlyMidCheckList$delegate", "realnameVersionControl", "", "getRealnameVersionControl", "()Z", "realnameVersionControl$delegate", "realnameMadifyControl", "getRealnameMadifyControl", "realnameMadifyControl$delegate", "realnameModifyList", "getRealnameModifyList", "realnameModifyList$delegate", "checkResult", "", "compatResult", "privateName", "Ltv/danmaku/bili/auth/BiliAuthStatus;", "privateNamePrefix", "privateCode", "appendSourceEvent", "sourceEvent", "auth_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthExtsKt {
    private static final Lazy sourceEventMidCheckList$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.BiliAuthExtsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            List sourceEventMidCheckList_delegate$lambda$0;
            sourceEventMidCheckList_delegate$lambda$0 = BiliAuthExtsKt.sourceEventMidCheckList_delegate$lambda$0();
            return sourceEventMidCheckList_delegate$lambda$0;
        }
    });
    private static final Lazy sourceEventFacialOnlyMidCheckList$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.BiliAuthExtsKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            List sourceEventFacialOnlyMidCheckList_delegate$lambda$0;
            sourceEventFacialOnlyMidCheckList_delegate$lambda$0 = BiliAuthExtsKt.sourceEventFacialOnlyMidCheckList_delegate$lambda$0();
            return sourceEventFacialOnlyMidCheckList_delegate$lambda$0;
        }
    });
    private static final Lazy realnameVersionControl$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.BiliAuthExtsKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            boolean realnameVersionControl_delegate$lambda$0;
            realnameVersionControl_delegate$lambda$0 = BiliAuthExtsKt.realnameVersionControl_delegate$lambda$0();
            return Boolean.valueOf(realnameVersionControl_delegate$lambda$0);
        }
    });
    private static final Lazy realnameMadifyControl$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.BiliAuthExtsKt$$ExternalSyntheticLambda3
        public final Object invoke() {
            boolean realnameMadifyControl_delegate$lambda$0;
            realnameMadifyControl_delegate$lambda$0 = BiliAuthExtsKt.realnameMadifyControl_delegate$lambda$0();
            return Boolean.valueOf(realnameMadifyControl_delegate$lambda$0);
        }
    });
    private static final Lazy realnameModifyList$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.BiliAuthExtsKt$$ExternalSyntheticLambda4
        public final Object invoke() {
            List realnameModifyList_delegate$lambda$0;
            realnameModifyList_delegate$lambda$0 = BiliAuthExtsKt.realnameModifyList_delegate$lambda$0();
            return realnameModifyList_delegate$lambda$0;
        }
    });

    public static final List<String> getSourceEventMidCheckList() {
        return (List) sourceEventMidCheckList$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List sourceEventMidCheckList_delegate$lambda$0() {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "auth.biz.source_event.midcheck", (Object) null, 2, (Object) null);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            ArrayList list = new ArrayList();
            list.add("200");
            list.add(BiliAuthConstants.SOURCE_EVENT_PC_MAIN);
            list.add(BiliAuthConstants.SOURCE_EVENT_PC_GAME);
            return list;
        }
        return StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null);
    }

    public static final List<String> getSourceEventFacialOnlyMidCheckList() {
        return (List) sourceEventFacialOnlyMidCheckList$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List sourceEventFacialOnlyMidCheckList_delegate$lambda$0() {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "auth.biz.source_event.facial_only.midcheck", (Object) null, 2, (Object) null);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            ArrayList list = new ArrayList();
            list.add("400");
            return list;
        }
        return StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null);
    }

    public static final boolean getRealnameVersionControl() {
        return ((Boolean) realnameVersionControl$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean realnameVersionControl_delegate$lambda$0() {
        return ConfigManager.Companion.ab2().getWithDefault("ff_auth.version.control", false);
    }

    public static final boolean getRealnameMadifyControl() {
        return ((Boolean) realnameMadifyControl$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean realnameMadifyControl_delegate$lambda$0() {
        return ConfigManager.Companion.ab2().getWithDefault("ff_auth.modify.control", false);
    }

    public static final List<String> getRealnameModifyList() {
        return (List) realnameModifyList$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List realnameModifyList_delegate$lambda$0() {
        List split$default;
        String dd = DeviceDecision.INSTANCE.dd("dd_auth.modify.list", "modify,change");
        return (dd == null || (split$default = StringsKt.split$default(dd, new String[]{","}, false, 0, 6, (Object) null)) == null) ? CollectionsKt.emptyList() : split$default;
    }

    public static final int checkResult(int $this$checkResult) {
        if ($this$checkResult == 3) {
            return 1;
        }
        return $this$checkResult;
    }

    public static final int compatResult(int $this$compatResult) {
        switch ($this$compatResult) {
            case -1:
                return 3;
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
            default:
                return 0;
        }
    }

    public static final String privateName(BiliAuthStatus $this$privateName) {
        Intrinsics.checkNotNullParameter($this$privateName, "<this>");
        char[] name = $this$privateName.getCurrentName().toCharArray();
        Intrinsics.checkNotNullExpressionValue(name, "toCharArray(...)");
        int size = name.length;
        if ((name.length == 0) || size < 2) {
            return $this$privateName.getCurrentName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ArraysKt.first(name));
        for (int i = 1; i < size; i++) {
            sb.append("*");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final String privateNamePrefix(BiliAuthStatus $this$privateNamePrefix) {
        Intrinsics.checkNotNullParameter($this$privateNamePrefix, "<this>");
        char[] name = $this$privateNamePrefix.getCurrentName().toCharArray();
        Intrinsics.checkNotNullExpressionValue(name, "toCharArray(...)");
        int size = name.length;
        if ((name.length == 0) || size < 2) {
            return $this$privateNamePrefix.getCurrentName();
        }
        StringBuilder sb = new StringBuilder();
        int i = size - 1;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("*");
        }
        sb.append(ArraysKt.last(name));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final String privateCode(BiliAuthStatus $this$privateCode) {
        Intrinsics.checkNotNullParameter($this$privateCode, "<this>");
        char[] code = $this$privateCode.getCurrentCardCode().toCharArray();
        Intrinsics.checkNotNullExpressionValue(code, "toCharArray(...)");
        if ((code.length == 0) || code.length < 3) {
            return $this$privateCode.getCurrentCardCode();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ArraysKt.first(code));
        int lastIndex = ArraysKt.getLastIndex(code);
        for (int i = 1; i < lastIndex; i++) {
            sb.append("*");
        }
        sb.append(ArraysKt.last(code));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final String appendSourceEvent(String $this$appendSourceEvent, String sourceEvent) {
        Intrinsics.checkNotNullParameter($this$appendSourceEvent, "<this>");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        Uri.Builder uri = Uri.parse($this$appendSourceEvent).buildUpon();
        if (!Intrinsics.areEqual(sourceEvent, "1")) {
            uri.appendQueryParameter(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, sourceEvent);
        }
        String uri2 = uri.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        return uri2;
    }
}