package defpackage;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;

/* compiled from: CenterPlusConstant.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"CENTER_PLUS_TYPE_DEFAULT", "", "KEY_CENTER_PLUS_TYPE", "isFromCenterPlus", "", "jumpParams", "editor_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: CenterPlusConstantKt  reason: default package */
public final class CenterPlusConstantKt {
    public static final String CENTER_PLUS_TYPE_DEFAULT = "0";
    public static final String KEY_CENTER_PLUS_TYPE = "center_plus_type";

    public static final boolean isFromCenterPlus(String jumpParams) {
        boolean isFromCenterPlus;
        String str = jumpParams;
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Uri parse = Uri.parse(jumpParams);
            isFromCenterPlus = Intrinsics.areEqual(parse != null ? parse.getQueryParameter(KEY_CENTER_PLUS_TYPE) : null, "0");
        } catch (Exception e) {
            BLog.e("CenterPlusConstantKt", e);
            isFromCenterPlus = false;
        }
        if (!isFromCenterPlus) {
            boolean isFromCenterPlus2 = StringsKt.contains$default(jumpParams, "center_plus_type=0", false, 2, (Object) null);
            return isFromCenterPlus2;
        }
        return isFromCenterPlus;
    }
}