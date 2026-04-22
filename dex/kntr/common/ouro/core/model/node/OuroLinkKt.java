package kntr.common.ouro.core.model.node;

import com.bapis.bilibili.dynamic.common.KBgStyle;
import com.bapis.bilibili.dynamic.common.KContentLinkCard;
import com.bapis.bilibili.dynamic.common.KLinkNode;
import com.bapis.bilibili.dynamic.common.KOpusBizType;
import com.bapis.bilibili.dynamic.common.KVideoTs;
import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroItalicMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroSemiBoldMark;
import kntr.common.ouro.core.model.mark.OuroStrikethroughMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: OuroLink.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001ap\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u001a\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0013\u001aN\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003*\u00020\u00152\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"UNIVERSAL_LINK_DEFAULT_ICON", "", "createLinkStorage", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/OuroUniversalLink;", "url", "title", "icon", "encodedData", "", "fontColor", "Lkntr/common/ouro/core/model/mark/OuroColor;", "bgColor", "bold", "", "italic", "underline", "strikethrough", "createStorage", "Lkntr/common/ouro/core/model/node/LinkParseResult;", "Lkntr/common/ouro/core/model/node/OuroAtMentionLink;", "Lkntr/common/ouro/core/model/node/AtMentionUser;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroLinkKt {
    public static final String UNIVERSAL_LINK_DEFAULT_ICON = "http://i0.hdslb.com/bfs/kfptfe/floor/fa4b3fe748a481948e7f608cad511e849f072917.png";

    public static /* synthetic */ NodeStorage createLinkStorage$default(String str, String str2, String str3, byte[] bArr, OuroColor ouroColor, OuroColor ouroColor2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return createLinkStorage(str, str2, (i & 4) != 0 ? UNIVERSAL_LINK_DEFAULT_ICON : str3, (i & 8) != 0 ? null : bArr, (i & 16) != 0 ? OuroColor.Companion.getLb7() : ouroColor, (i & 32) == 0 ? ouroColor2 : null, (i & 64) != 0 ? false : z, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? false : z3, (i & 512) == 0 ? z4 : false);
    }

    public static final NodeStorage<OuroUniversalLink> createLinkStorage(final String url, final String title, final String icon, byte[] encodedData, final OuroColor fontColor, final OuroColor bgColor, final boolean bold, final boolean italic, final boolean underline, final boolean strikethrough) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(fontColor, "fontColor");
        return NodeStorage.mutate$core_debug$default(new NodeStorage(new OuroUniversalLink(url, encodedData), null, null, 6, null), false, new Function1() { // from class: kntr.common.ouro.core.model.node.OuroLinkKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit createLinkStorage$lambda$0;
                createLinkStorage$lambda$0 = OuroLinkKt.createLinkStorage$lambda$0(OuroColor.this, bgColor, icon, title, url, bold, italic, underline, strikethrough, (NodeStorageBuilder) obj);
                return createLinkStorage$lambda$0;
            }
        }, 1, null);
    }

    public static final Unit createLinkStorage$lambda$0(OuroColor $fontColor, OuroColor $bgColor, String $icon, String $title, String $url, boolean $bold, boolean $italic, boolean $underline, boolean $strikethrough, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        List prefixInlineContentMarks = new ArrayList();
        prefixInlineContentMarks.add(new OuroDrawableMark.Size.Specified(20.0f, 20.0f));
        prefixInlineContentMarks.add(new OuroForegroundColorMark($fontColor));
        if ($bgColor != null) {
            prefixInlineContentMarks.add(new OuroBackgroundColorMark($bgColor, 0.0f, 2, (DefaultConstructorMarker) null));
        }
        OuroInlineContent prefixInlineContent = new OuroInlineContent(new OuroMarks(prefixInlineContentMarks));
        OuroRemoteImage.Image image = new OuroRemoteImage.Image($icon, 20, 20, 0, 8, (DefaultConstructorMarker) null);
        $this$mutate.add(prefixInlineContent, image);
        String str = $title;
        if (str.length() == 0) {
            str = $url;
        }
        String linkTitle = str;
        List $this$createLinkStorage_u24lambda_u240_u241 = new ArrayList();
        $this$createLinkStorage_u24lambda_u240_u241.add(new OuroForegroundColorMark($fontColor));
        if ($bgColor != null) {
            $this$createLinkStorage_u24lambda_u240_u241.add(new OuroBackgroundColorMark($bgColor, 0.0f, 2, (DefaultConstructorMarker) null));
        }
        if ($bold) {
            $this$createLinkStorage_u24lambda_u240_u241.add(OuroSemiBoldMark.INSTANCE);
        }
        if ($italic) {
            $this$createLinkStorage_u24lambda_u240_u241.add(OuroItalicMark.INSTANCE);
        }
        if ($underline) {
            $this$createLinkStorage_u24lambda_u240_u241.add(OuroUnderlineMark.INSTANCE);
        }
        if ($strikethrough) {
            $this$createLinkStorage_u24lambda_u240_u241.add(OuroStrikethroughMark.INSTANCE);
        }
        OuroMarks marks = new OuroMarks($this$createLinkStorage_u24lambda_u240_u241);
        OuroTextElement.Plain plainText = new OuroTextElement.Plain((char) 8205 + linkTitle, marks);
        $this$mutate.addChildren($this$mutate.getRoot(), CollectionsKt.listOf(new OuroNode[]{prefixInlineContent, plainText}));
        return Unit.INSTANCE;
    }

    public static final NodeStorage<OuroUniversalLink> createStorage(LinkParseResult $this$createStorage) {
        Intrinsics.checkNotNullParameter($this$createStorage, "<this>");
        String url = $this$createStorage.getUrl();
        String title = $this$createStorage.getTitle();
        String icon = $this$createStorage.getIcon();
        BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
        Object value$iv = new KLinkNode($this$createStorage.getTitle(), $this$createStorage.getUrl(), (String) null, (String) null, KOpusBizType.Companion.fromValue($this$createStorage.getType()), $this$createStorage.getBizId(), (KVideoTs) null, (KLinkNode.KLinkNodeStyle) null, (List) null, (KBgStyle) null, (KContentLinkCard) null, (KLinkNode.KHashTagType) null, 4044, (DefaultConstructorMarker) null);
        $this$encodeToByteArray$iv.getSerializersModule();
        return createLinkStorage$default(url, title, icon, $this$encodeToByteArray$iv.encodeToByteArray(KLinkNode.Companion.serializer(), value$iv), null, null, false, false, false, false, 1008, null);
    }

    public static /* synthetic */ NodeStorage createStorage$default(AtMentionUser atMentionUser, OuroColor ouroColor, OuroColor ouroColor2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroColor = OuroColor.Companion.getLb7();
        }
        return createStorage(atMentionUser, ouroColor, (i & 2) != 0 ? null : ouroColor2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) == 0 ? z4 : false);
    }

    public static final NodeStorage<OuroAtMentionLink> createStorage(final AtMentionUser $this$createStorage, OuroColor fontColor, OuroColor bgColor, boolean bold, boolean italic, boolean underline, boolean strikethrough) {
        Intrinsics.checkNotNullParameter($this$createStorage, "<this>");
        Intrinsics.checkNotNullParameter(fontColor, "fontColor");
        List $this$createStorage_u24lambda_u240 = new ArrayList();
        $this$createStorage_u24lambda_u240.add(new OuroForegroundColorMark(fontColor));
        if (bgColor != null) {
            $this$createStorage_u24lambda_u240.add(new OuroBackgroundColorMark(bgColor, 0.0f, 2, (DefaultConstructorMarker) null));
        }
        if (bold) {
            $this$createStorage_u24lambda_u240.add(OuroSemiBoldMark.INSTANCE);
        }
        if (italic) {
            $this$createStorage_u24lambda_u240.add(OuroItalicMark.INSTANCE);
        }
        if (underline) {
            $this$createStorage_u24lambda_u240.add(OuroUnderlineMark.INSTANCE);
        }
        if (strikethrough) {
            $this$createStorage_u24lambda_u240.add(OuroStrikethroughMark.INSTANCE);
        }
        final OuroMarks marks = new OuroMarks($this$createStorage_u24lambda_u240);
        return NodeStorage.mutate$core_debug$default(new NodeStorage(new OuroAtMentionLink($this$createStorage), null, null, 6, null), false, new Function1() { // from class: kntr.common.ouro.core.model.node.OuroLinkKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit createStorage$lambda$1;
                createStorage$lambda$1 = OuroLinkKt.createStorage$lambda$1(AtMentionUser.this, marks, (NodeStorageBuilder) obj);
                return createStorage$lambda$1;
            }
        }, 1, null);
    }

    public static final Unit createStorage$lambda$1(AtMentionUser $this_createStorage, OuroMarks $marks, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        $this$mutate.addChild((OuroNode.Parent<T>) $this$mutate.getRoot(), (T) new OuroTextElement.Plain("@" + StringsKt.trim($this_createStorage.getName()).toString() + " ", $marks));
        return Unit.INSTANCE;
    }
}