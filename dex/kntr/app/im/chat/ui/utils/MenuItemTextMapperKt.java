package kntr.app.im.chat.ui.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import bili.resource.im.Res;
import bili.resource.im.String0_commonMainKt;
import com.bapis.bilibili.app.im.v1.KMsgMenuContent;
import kotlin.Metadata;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: MenuItemTextMapper.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"defaultStringRes", "Lorg/jetbrains/compose/resources/StringResource;", "Lcom/bapis/bilibili/app/im/v1/KMsgMenuContent;", "(Lcom/bapis/bilibili/app/im/v1/KMsgMenuContent;Landroidx/compose/runtime/Composer;I)Lorg/jetbrains/compose/resources/StringResource;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MenuItemTextMapperKt {
    public static final StringResource defaultStringRes(KMsgMenuContent $this$defaultStringRes, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 150778338, "C(defaultStringRes):MenuItemTextMapper.kt#we9gw3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(150778338, $changed, -1, "kntr.app.im.chat.ui.utils.defaultStringRes (MenuItemTextMapper.kt:16)");
        }
        StringResource stringResource = null;
        KMsgMenuContent.IItem item = $this$defaultStringRes != null ? $this$defaultStringRes.getItem() : null;
        if (item instanceof KMsgMenuContent.KCopy) {
            stringResource = String0_commonMainKt.getIm_global_string_10(Res.string.INSTANCE);
        } else if (item instanceof KMsgMenuContent.KDelete) {
            stringResource = String0_commonMainKt.getIm_global_string_420(Res.string.INSTANCE);
        } else if (item instanceof KMsgMenuContent.KRecall) {
            stringResource = String0_commonMainKt.getIm_global_string_209(Res.string.INSTANCE);
        } else if (item instanceof KMsgMenuContent.KReport) {
            stringResource = String0_commonMainKt.getIm_global_string_490(Res.string.INSTANCE);
        } else if (item instanceof KMsgMenuContent.KSaveSticker) {
            stringResource = String0_commonMainKt.getIm_global_string_154(Res.string.INSTANCE);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stringResource;
    }
}