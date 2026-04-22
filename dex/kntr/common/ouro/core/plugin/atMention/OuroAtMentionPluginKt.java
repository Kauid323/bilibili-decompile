package kntr.common.ouro.core.plugin.atMention;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.OuroPoint;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: OuroAtMentionPlugin.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0002\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"AT_MENTION_CHARACTER", "", "AT_MENTION_STOP_CHARACTERS", "", "findAtMentionKeyword", "Lkntr/common/ouro/core/plugin/atMention/Keyword;", "Lkntr/common/ouro/core/OuroState;", "findLastAtAndGetSubstring", "", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroAtMentionPluginKt {
    private static final char AT_MENTION_CHARACTER = '@';
    private static final List<Character> AT_MENTION_STOP_CHARACTERS = CollectionsKt.listOf(new Character[]{' ', '\n', '\t'});

    /* JADX INFO: Access modifiers changed from: private */
    public static final Keyword findAtMentionKeyword(OuroState $this$findAtMentionKeyword) {
        String it;
        OuroTextElement.Plain plain;
        String it2;
        if ($this$findAtMentionKeyword.getSelection().isCollapsed()) {
            int selectedIndex = $this$findAtMentionKeyword.getSelection().getAnchor().getOffset();
            if (selectedIndex == 0) {
                OuroNodeStorage $this$getPreviousSelectableOrNull$iv = $this$findAtMentionKeyword.getStorage();
                OuroPoint point$iv = $this$findAtMentionKeyword.getSelection().getStart();
                int prevIndex$iv = point$iv.getIndex() - 1;
                if (prevIndex$iv >= 0) {
                    Object orNull = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv.getAllSelectables(), prevIndex$iv);
                    if (!(orNull instanceof OuroTextElement.Plain)) {
                        orNull = null;
                    }
                    plain = (OuroTextElement.Plain) orNull;
                } else {
                    plain = null;
                }
                OuroTextElement.Plain textNode = (OuroTextElement.Plain) plain;
                if (textNode == null || (it2 = findLastAtAndGetSubstring(textNode.getMeta())) == null) {
                    return null;
                }
                return new Keyword(it2, $this$findAtMentionKeyword.getTextRange(new OuroSelection($this$findAtMentionKeyword.getSelection().getAnchor(), $this$findAtMentionKeyword.getSelection().getAnchor().copy($this$findAtMentionKeyword.getSelection().getAnchor().getIndex() - 1, (textNode.getLength() - it2.length()) - 1))));
            }
            OuroNode.Selectable selectableOrNull = OuroNodeStorageUtilsKt.getSelectableOrNull($this$findAtMentionKeyword.getStorage(), $this$findAtMentionKeyword.getSelection().getStart());
            OuroTextElement.Plain plain2 = selectableOrNull instanceof OuroTextElement.Plain ? (OuroTextElement.Plain) selectableOrNull : null;
            if (plain2 == null || (it = findLastAtAndGetSubstring(StringsKt.take(plain2.getMeta(), selectedIndex))) == null) {
                return null;
            }
            return new Keyword(it, $this$findAtMentionKeyword.getTextRange(new OuroSelection($this$findAtMentionKeyword.getSelection().getAnchor(), OuroPoint.copy$default($this$findAtMentionKeyword.getSelection().getAnchor(), 0, (selectedIndex - it.length()) - 1, 1, null))));
            return null;
        }
        return null;
    }

    private static final String findLastAtAndGetSubstring(String $this$findLastAtAndGetSubstring) {
        int i = $this$findLastAtAndGetSubstring.length();
        while (true) {
            i--;
            if (-1 >= i) {
                return null;
            }
            if ($this$findLastAtAndGetSubstring.charAt(i) == '@') {
                if (i < $this$findLastAtAndGetSubstring.length() - 1) {
                    String substring = $this$findLastAtAndGetSubstring.substring(i + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return substring;
                }
                return "";
            } else if (AT_MENTION_STOP_CHARACTERS.contains(Character.valueOf($this$findLastAtAndGetSubstring.charAt(i)))) {
                return null;
            }
        }
    }
}