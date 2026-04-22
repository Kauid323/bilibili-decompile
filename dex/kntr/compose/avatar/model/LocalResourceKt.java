package kntr.compose.avatar.model;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.painter.Painter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.LocalSourceEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.common.avatar.ui.generated.resources.Drawable0_commonMainKt;
import srcs.common.avatar.ui.generated.resources.Res;

/* compiled from: LocalResource.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002H\u0001¢\u0006\u0002\u0010\u0007\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"res", "Lorg/jetbrains/compose/resources/DrawableResource;", "Lkntr/compose/avatar/model/common/LocalSourceEnum;", "getRes", "(Lkntr/compose/avatar/model/common/LocalSourceEnum;)Lorg/jetbrains/compose/resources/DrawableResource;", "getPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lkntr/compose/avatar/model/common/LocalSourceEnum;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalResourceKt {

    /* compiled from: LocalResource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LocalSourceEnum.values().length];
            try {
                iArr[LocalSourceEnum.Vip.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LocalSourceEnum.SmallVip.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LocalSourceEnum.PersonalVerify.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LocalSourceEnum.EnterpriseVerify.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[LocalSourceEnum.MainlandNft.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[LocalSourceEnum.DefaultAvatar.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DrawableResource getRes(LocalSourceEnum $this$res) {
        Intrinsics.checkNotNullParameter($this$res, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$res.ordinal()]) {
            case 1:
                return Drawable0_commonMainKt.getIc_tag_bigmember(Res.drawable.INSTANCE);
            case 2:
                return Drawable0_commonMainKt.getIc_tag_smallmember(Res.drawable.INSTANCE);
            case 3:
                return Drawable0_commonMainKt.getIc_tag_official_person(Res.drawable.INSTANCE);
            case 4:
                return Drawable0_commonMainKt.getIc_tag_official_enterprise(Res.drawable.INSTANCE);
            case 5:
                return Drawable0_commonMainKt.getIc_tag_nft(Res.drawable.INSTANCE);
            case 6:
                return Drawable0_commonMainKt.getIc_default_avatar(Res.drawable.INSTANCE);
            default:
                return null;
        }
    }

    public static final Painter getPainter(LocalSourceEnum $this$getPainter, Composer $composer, int $changed) {
        Painter painterResource;
        Intrinsics.checkNotNullParameter($this$getPainter, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 721316141, "C(getPainter):LocalResource.kt#iiz7dv");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(721316141, $changed, -1, "kntr.compose.avatar.model.getPainter (LocalResource.kt:33)");
        }
        DrawableResource it = getRes($this$getPainter);
        if (it == null) {
            $composer.startReplaceGroup(1007825081);
            $composer.endReplaceGroup();
            painterResource = null;
        } else {
            $composer.startReplaceGroup(1007825082);
            ComposerKt.sourceInformation($composer, "*33@1463L19");
            painterResource = ImageResourcesKt.painterResource(it, $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return painterResource;
    }
}