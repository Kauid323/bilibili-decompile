package im.setting.model.extension;

import com.bapis.bilibili.app.im.v1.KRedirect2SettingPage;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingRedirect;
import com.bilibili.lib.brouter.uri.Uri;
import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: KSettingRedirectExt.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"getJumpUrl", "", "Lcom/bapis/bilibili/app/im/v1/KSetting$KRedirect;", "Lcom/bapis/bilibili/app/im/v1/KSettingRedirect;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KSettingRedirectExtKt {
    public static final String getJumpUrl(KSetting.KRedirect $this$getJumpUrl) {
        Intrinsics.checkNotNullParameter($this$getJumpUrl, "<this>");
        return getJumpUrl($this$getJumpUrl.getValue());
    }

    public static final String getJumpUrl(KSettingRedirect $this$getJumpUrl) {
        Intrinsics.checkNotNullParameter($this$getJumpUrl, "<this>");
        KSettingRedirect.KSettingPage content = $this$getJumpUrl.getContent();
        if (content instanceof KSettingRedirect.KSettingPage) {
            BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
            Object value$iv = content.getValue();
            $this$encodeToByteArray$iv.getSerializersModule();
            byte[] bytes = $this$encodeToByteArray$iv.encodeToByteArray(KRedirect2SettingPage.Companion.serializer(), value$iv);
            String hexString = HexExtensionsKt.toHexString$default(bytes, (HexFormat) null, 1, (Object) null);
            String baseRoute = content.getValue().getUrl();
            return Uri.Companion.parse(baseRoute).buildUpon().appendQueryParameter(UtilsKt.DATA_KEY, hexString).toString();
        } else if (content instanceof KSettingRedirect.KOtherPage) {
            return ((KSettingRedirect.KOtherPage) content).getValue().getUrl();
        } else {
            if (content instanceof KSettingRedirect.KPopup) {
                return Uri.Companion.parse(((KSettingRedirect.KPopup) content).getValue().getUrl()).buildUpon().appendQueryParameter("title", ((KSettingRedirect.KPopup) content).getValue().getTitle()).appendQueryParameter("subtitle", ((KSettingRedirect.KPopup) content).getValue().getSubtitle()).build().toString();
            }
            return null;
        }
    }
}