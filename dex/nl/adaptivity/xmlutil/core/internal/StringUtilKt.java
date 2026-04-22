package nl.adaptivity.xmlutil.core.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.ExperimentalXmlUtilApi;
import nl.adaptivity.xmlutil.XmlUtilInternal;

/* compiled from: StringUtil.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0007\u001a\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007\u001a\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007\u001a\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0007\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"countIndentedLength", "", "", "isNameStartCode", "", "c", "isColonValid", "isNameCodepoint", "isNameStartChar", "", "isNameChar10", "isNameChar11", "NAMESTART", "", "NAMECHAR", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class StringUtilKt {
    private static final boolean[] NAMECHAR;
    private static final boolean[] NAMESTART;

    @XmlUtilInternal
    public static final int countIndentedLength(String $this$countIndentedLength) {
        Intrinsics.checkNotNullParameter($this$countIndentedLength, "<this>");
        String $this$fold$iv = $this$countIndentedLength;
        int accumulator$iv = 0;
        for (int i = 0; i < $this$fold$iv.length(); i++) {
            char element$iv = $this$fold$iv.charAt(i);
            int acc = accumulator$iv;
            accumulator$iv = (element$iv == '\t' ? 8 : 1) + acc;
        }
        return accumulator$iv;
    }

    public static /* synthetic */ boolean isNameStartCode$default(int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return isNameStartCode(i, z);
    }

    @ExperimentalXmlUtilApi
    public static final boolean isNameStartCode(int c, boolean isColonValid) {
        if (c == 247 || c == 894) {
            return false;
        }
        if (c == 58) {
            return isColonValid;
        }
        if (!(65 <= c && c < 91) && c != 95) {
            if (!(97 <= c && c < 123)) {
                if (!(192 <= c && c < 215)) {
                    if (!(216 <= c && c < 768)) {
                        if (!(880 <= c && c < 8192) && c != 8204 && c != 8205) {
                            if (!(8304 <= c && c < 8592)) {
                                if (!(11264 <= c && c < 12272)) {
                                    if (!(12289 <= c && c < 55296)) {
                                        if (!(63744 <= c && c < 64976)) {
                                            if (!(65008 <= c && c < 65534)) {
                                                if (!(65536 <= c && c < 983040)) {
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static /* synthetic */ boolean isNameCodepoint$default(int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return isNameCodepoint(i, z);
    }

    @ExperimentalXmlUtilApi
    public static final boolean isNameCodepoint(int c, boolean isColonValid) {
        if (c == 247 || c == 894) {
            return false;
        }
        if (c == 58) {
            return isColonValid;
        }
        if (!(65 <= c && c < 91) && c != 95 && c != 45 && c != 46) {
            if (!(97 <= c && c < 123)) {
                if (!(48 <= c && c < 58) && c != 183) {
                    if (!(192 <= c && c < 215)) {
                        if (!(216 <= c && c < 8192) && c != 8204 && c != 8205 && c != 8255 && c != 8256) {
                            if (!(8304 <= c && c < 8592)) {
                                if (!(11264 <= c && c < 12272)) {
                                    if (!(12289 <= c && c < 55296)) {
                                        if (!(63744 <= c && c < 64976)) {
                                            if (!(65008 <= c && c < 65534)) {
                                                if (!(65536 <= c && c < 983040)) {
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @ExperimentalXmlUtilApi
    public static final boolean isNameStartChar(char c, boolean isColonValid) {
        if (c == 247 || c == 894) {
            return false;
        }
        if (c == ':') {
            return isColonValid;
        }
        if (!('A' <= c && c < '[') && c != '_') {
            if (!('a' <= c && c < '{')) {
                if (!(192 <= c && c < 215)) {
                    if (!(216 <= c && c < 768)) {
                        if (!(880 <= c && c < 8192) && c != 8204 && c != 8205) {
                            if (!(8304 <= c && c < 8592)) {
                                if (!(11264 <= c && c < 12272)) {
                                    if (!(12289 <= c && c < 55296)) {
                                        if (!(63744 <= c && c < 64976)) {
                                            if (!(65008 <= c && c < 65534)) {
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @ExperimentalXmlUtilApi
    public static final boolean isNameStartChar(char c) {
        if (c < 256) {
            return NAMESTART[c];
        }
        if (256 <= c && c < 768) {
            return true;
        }
        if ((880 <= c && c < 8192) || c == 8204 || c == 8205) {
            return true;
        }
        if (8304 <= c && c < 8592) {
            return true;
        }
        if (11264 <= c && c < 12272) {
            return true;
        }
        if (12289 <= c && c < 55296) {
            return true;
        }
        if (63744 <= c && c < 64976) {
            return true;
        }
        return 65008 <= c && c < 65534;
    }

    public static /* synthetic */ boolean isNameChar10$default(char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return isNameChar10(c, z);
    }

    @ExperimentalXmlUtilApi
    public static final boolean isNameChar10(char c, boolean isColonValid) {
        if (c == 247 || c == 894) {
            return false;
        }
        if (c == ':') {
            return isColonValid;
        }
        if (!('A' <= c && c < '[') && c != '_' && c != '-' && c != '.') {
            if (!('a' <= c && c < '{')) {
                if (!('0' <= c && c < ':') && c != 183) {
                    if (!(192 <= c && c < 215)) {
                        if (!(216 <= c && c < 8192) && c != 8204 && c != 8205 && c != 8255 && c != 8256) {
                            if (!(8304 <= c && c < 8592)) {
                                if (!(11264 <= c && c < 12272)) {
                                    if (!(12289 <= c && c < 55296)) {
                                        if (!(63744 <= c && c < 64976)) {
                                            if (!(65008 <= c && c < 65534)) {
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static /* synthetic */ boolean isNameChar11$default(char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return isNameChar11(c, z);
    }

    @ExperimentalXmlUtilApi
    public static final boolean isNameChar11(char c, boolean isColonValid) {
        if (c == 247 || c == 894) {
            return false;
        }
        if (c == ':') {
            return isColonValid;
        }
        if (!('A' <= c && c < '[') && c != '_' && c != '-' && c != '.') {
            if (!('a' <= c && c < '{')) {
                if (!('0' <= c && c < ':') && c != 183) {
                    if (!(192 <= c && c < 215)) {
                        if (!(216 <= c && c < 8192) && c != 8204 && c != 8205 && c != 8255 && c != 8256) {
                            if (!(8304 <= c && c < 8592)) {
                                if (!(11264 <= c && c < 12272)) {
                                    if (!(12289 <= c && c < 57344)) {
                                        if (!(63744 <= c && c < 64976)) {
                                            if (!(65008 <= c && c < 65534)) {
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @ExperimentalXmlUtilApi
    public static final boolean isNameChar11(char c) {
        if (c < 256) {
            return NAMECHAR[c];
        }
        if ((256 <= c && c < 8192) || c == 8204 || c == 8205 || c == 8255 || c == 8256) {
            return true;
        }
        if (8304 <= c && c < 8592) {
            return true;
        }
        if (11264 <= c && c < 12272) {
            return true;
        }
        if (12289 <= c && c < 57344) {
            return true;
        }
        if (63744 <= c && c < 64976) {
            return true;
        }
        return 65008 <= c && c < 65534;
    }

    static {
        boolean[] b = new boolean[256];
        for (char c = 'A'; c < '['; c = (char) (c + 1)) {
            b[c] = true;
        }
        for (char c2 = 'a'; c2 < '{'; c2 = (char) (c2 + 1)) {
            b[c2] = true;
        }
        b[58] = true;
        b[95] = true;
        for (int c3 = 192; c3 < 215; c3++) {
            b[c3] = true;
        }
        for (int c4 = 216; c4 < 247; c4++) {
            b[c4] = true;
        }
        for (int c5 = 248; c5 < 256; c5++) {
            b[c5] = true;
        }
        NAMESTART = b;
        boolean[] b2 = new boolean[256];
        for (char c6 = 'A'; c6 < '['; c6 = (char) (c6 + 1)) {
            b2[c6] = true;
        }
        for (char c7 = 'a'; c7 < '{'; c7 = (char) (c7 + 1)) {
            b2[c7] = true;
        }
        for (char c8 = '0'; c8 < ':'; c8 = (char) (c8 + 1)) {
            b2[c8] = true;
        }
        b2[58] = true;
        b2[95] = true;
        b2[45] = true;
        b2[46] = true;
        b2[183] = true;
        for (int c9 = 192; c9 < 215; c9++) {
            b2[c9] = true;
        }
        for (int c10 = 216; c10 < 256; c10++) {
            b2[c10] = true;
        }
        NAMECHAR = b2;
    }
}