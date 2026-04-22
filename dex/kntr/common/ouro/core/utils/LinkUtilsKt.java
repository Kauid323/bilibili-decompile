package kntr.common.ouro.core.utils;

import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* compiled from: LinkUtils.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"ATTR_WHITESPACE", "Lkotlin/text/Regex;", "ALLOWED_URI_LITERAL", "", "ALLOWED_URI_REGEX", "EMOTE_REGEX_LITERAL", "EMOTE_REGEX", "TEST_REGEX", "isAllowedUri", "", "uri", "isEmote", "rawText", "extractUris", "", "Lkntr/common/ouro/core/utils/MatchString;", "text", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LinkUtilsKt {
    private static final Regex ATTR_WHITESPACE = new Regex("[\\u0000-\\u0020\\u00A0\\u1680\\u180E\\u2000-\\u2029\\u205F\\u3000]");
    private static final String ALLOWED_URI_LITERAL = "https?://(www.)?[-a-zA-Z0-9@:%._+~#=]{1,256}.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_+.~#?&/=]*)";
    private static final Regex ALLOWED_URI_REGEX = new Regex(ALLOWED_URI_LITERAL);
    private static final String EMOTE_REGEX_LITERAL = "\\[[^]]*]";
    private static final Regex EMOTE_REGEX = new Regex(EMOTE_REGEX_LITERAL);
    private static final Regex TEST_REGEX = new Regex("\\[[^]]*]|" + ALLOWED_URI_REGEX, SetsKt.setOf(new RegexOption[]{RegexOption.MULTILINE, RegexOption.IGNORE_CASE}));

    public static final boolean isAllowedUri(String uri) {
        String str = uri;
        if (str == null || str.length() == 0) {
            return false;
        }
        String cleanedUri = ATTR_WHITESPACE.replace(StringsKt.trim(uri).toString(), "");
        return ALLOWED_URI_REGEX.containsMatchIn(cleanedUri);
    }

    public static final boolean isEmote(String rawText) {
        String str = rawText;
        if (str == null || str.length() == 0) {
            return false;
        }
        String cleanedRawText = ATTR_WHITESPACE.replace(StringsKt.trim(rawText).toString(), "");
        return EMOTE_REGEX.containsMatchIn(cleanedRawText);
    }

    public static final List<MatchString> extractUris(String text) {
        boolean z;
        String str = text;
        if (str == null || str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        List res = new ArrayList();
        String trimmedText = StringsKt.trim(text).toString();
        int current = 0;
        Object obj = null;
        List list = SequencesKt.toList(Regex.findAll$default(TEST_REGEX, trimmedText, 0, 2, (Object) null));
        List $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            MatchResult it = (MatchResult) element$iv;
            int first = it.getRange().getFirst();
            if (first > current) {
                String substring = trimmedText.substring(current, first);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                res.add(new MatchString(substring, MatchStringType.Text));
            }
            int last = it.getRange().getLast();
            String uri = trimmedText.substring(first, last + 1);
            Intrinsics.checkNotNullExpressionValue(uri, "substring(...)");
            List list2 = list;
            if (StringsKt.startsWith$default(uri, "http", false, 2, obj)) {
                res.add(new MatchString(uri, MatchStringType.Link));
                z = false;
            } else {
                z = false;
                if (StringsKt.startsWith$default(uri, "[", false, 2, obj)) {
                    res.add(new MatchString(uri, MatchStringType.Emote));
                } else {
                    res.add(new MatchString(uri, MatchStringType.Text));
                }
            }
            current = last + 1;
            list = list2;
            obj = null;
        }
        if (current < trimmedText.length()) {
            String substring2 = trimmedText.substring(current, trimmedText.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            res.add(new MatchString(substring2, MatchStringType.Text));
        }
        return res;
    }
}