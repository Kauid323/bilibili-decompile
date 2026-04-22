package kntr.common.ouro.core.utils;

import com.bilibili.emoticon.Emote;
import com.bilibili.emoticon.EmoticonSize;
import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmoteHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"SMALL_STICKER_FONT_SCALE", "", "LARGE_STICKER_SIZE", "STICKER_HORIZONTAL_PADDING", "nodeStorage", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/drawable/OuroInlineContent;", "Lcom/bilibili/emoticon/Emote;", "bgColor", "Lkntr/common/ouro/core/model/mark/OuroColor;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class EmoteHelperKt {
    private static final float LARGE_STICKER_SIZE = 46.0f;
    private static final float SMALL_STICKER_FONT_SCALE = 1.3f;
    private static final float STICKER_HORIZONTAL_PADDING = 1.0f;

    /* compiled from: EmoteHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EmoticonSize.values().length];
            try {
                iArr[EmoticonSize.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EmoticonSize.LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ NodeStorage nodeStorage$default(Emote emote, OuroColor ouroColor, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroColor = null;
        }
        return nodeStorage(emote, ouroColor);
    }

    public static final NodeStorage<OuroInlineContent> nodeStorage(Emote $this$nodeStorage, OuroColor bgColor) {
        OuroDrawableMark.Size sizeMark;
        int pictureSize;
        Intrinsics.checkNotNullParameter($this$nodeStorage, "<this>");
        List inlineContent = new ArrayList();
        switch (WhenMappings.$EnumSwitchMapping$0[$this$nodeStorage.getSize().ordinal()]) {
            case 1:
                sizeMark = new OuroDrawableMark.Size.ScaledByFontSize((float) SMALL_STICKER_FONT_SCALE, (float) SMALL_STICKER_FONT_SCALE, 2.0f, 0.0f, 8, (DefaultConstructorMarker) null);
                break;
            case 2:
                sizeMark = new OuroDrawableMark.Size.Specified(48.0f, LARGE_STICKER_SIZE);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        OuroDrawableMark.Padding paddingMark = new OuroDrawableMark.Padding(1.0f, 0.0f, 2, (DefaultConstructorMarker) null);
        inlineContent.add(sizeMark);
        inlineContent.add(paddingMark);
        if (bgColor != null) {
            inlineContent.add(new OuroBackgroundColorMark(bgColor, 0.0f, 2, (DefaultConstructorMarker) null));
        }
        switch (WhenMappings.$EnumSwitchMapping$0[$this$nodeStorage.getSize().ordinal()]) {
            case 1:
                pictureSize = 22;
                break;
            case 2:
                pictureSize = 46;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        NodeStorageBuilder $this$nodeStorage_u24lambda_u240 = new NodeStorageBuilder(new OuroInlineContent(new OuroMarks(inlineContent)), null, null, 6, null);
        $this$nodeStorage_u24lambda_u240.addChild((OuroNode.Parent<T>) $this$nodeStorage_u24lambda_u240.getRoot(), (T) new OuroRemoteImage.Sticker($this$nodeStorage.getName(), $this$nodeStorage.getUrl(), pictureSize, pictureSize));
        return OuroNodeMutableStorage.CC.build$default($this$nodeStorage_u24lambda_u240, false, 1, null);
    }
}