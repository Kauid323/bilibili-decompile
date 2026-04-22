package nl.adaptivity.xmlutil.core;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import nl.adaptivity.xmlutil.XmlException;
import nl.adaptivity.xmlutil.XmlUtil;
import org.apache.commons.codec.CharEncoding;

/* compiled from: KtXmlReaderJava.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"KtXmlReader", "Lnl/adaptivity/xmlutil/core/KtXmlReader;", "inputStream", "Ljava/io/InputStream;", "encoding", "", "relaxed", "", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KtXmlReaderJavaKt {
    public static /* synthetic */ KtXmlReader KtXmlReader$default(InputStream inputStream, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return KtXmlReader(inputStream, str, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x00be A[Catch: Exception -> 0x0164, TryCatch #2 {Exception -> 0x0164, blocks: (B:164:0x0091, B:166:0x0097, B:167:0x009e, B:169:0x00b0, B:172:0x00be, B:174:0x00c2, B:176:0x00c8, B:178:0x00d2, B:179:0x00d5, B:181:0x00db, B:183:0x00e3, B:185:0x00e7, B:187:0x00ed, B:189:0x00f7, B:190:0x00fa, B:192:0x0100, B:193:0x0104, B:194:0x0107, B:206:0x013b, B:207:0x0144, B:195:0x010a, B:196:0x010c, B:198:0x0112, B:200:0x0118, B:201:0x011b, B:203:0x0121, B:204:0x012f, B:205:0x013a, B:208:0x0145, B:209:0x0150, B:210:0x0151, B:211:0x015c), top: B:251:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x01f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final KtXmlReader KtXmlReader(InputStream inputStream, String encoding, boolean relaxed) {
        XmlException xmlException;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        BufferedInputStream bufferedInput = ((inputStream instanceof BufferedInputStream) && ((BufferedInputStream) inputStream).markSupported()) ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, 4096);
        bufferedInput.mark(500);
        char[] srcBuf = new char[500];
        String enc = encoding;
        if (enc == null) {
            int srcBufCount = 0;
            int chk = 0;
            while (srcBufCount < 4) {
                try {
                    int i = bufferedInput.read();
                    if (i < 0) {
                        break;
                    }
                    chk = UInt.constructor-impl(UInt.constructor-impl(chk << 8) | UInt.constructor-impl(i));
                    int srcBufCount2 = srcBufCount + 1;
                    try {
                        srcBuf[srcBufCount] = (char) i;
                        srcBufCount = srcBufCount2;
                    } catch (Exception e) {
                        e = e;
                        xmlException = !(e instanceof XmlException) ? (XmlException) e : null;
                        if (xmlException == null) {
                            xmlException = new XmlException("Invalid stream or encoding: " + e, e);
                        }
                        throw xmlException;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            bufferedInput.reset();
            if (srcBufCount == 4) {
                switch (chk) {
                    case -131072:
                        bufferedInput.skip(4L);
                        enc = "UTF-32LE";
                        break;
                    case 60:
                        enc = "UTF-32BE";
                        srcBuf[0] = Typography.less;
                        break;
                    case 65279:
                        bufferedInput.skip(4L);
                        enc = "UTF-32BE";
                        break;
                    case 3932223:
                        enc = CharEncoding.UTF_16BE;
                        srcBuf[0] = Typography.less;
                        srcBuf[1] = '?';
                        break;
                    case 1006632960:
                        enc = "UTF-32LE";
                        srcBuf[0] = Typography.less;
                        break;
                    case 1006649088:
                        enc = CharEncoding.UTF_16LE;
                        srcBuf[0] = Typography.less;
                        srcBuf[1] = '?';
                        break;
                    case 1010792557:
                        bufferedInput.mark(4000);
                        bufferedInput.skip(4L);
                        while (true) {
                            int i2 = bufferedInput.read();
                            if (i2 != -1) {
                                int srcBufCount3 = srcBufCount + 1;
                                try {
                                    srcBuf[srcBufCount] = (char) i2;
                                    if (i2 == 62) {
                                        String xmlDeclContent = StringsKt.concatToString(srcBuf, 0, srcBufCount3 + 0);
                                        int encAttrOffset = -1;
                                        do {
                                            encAttrOffset = StringsKt.indexOf$default((CharSequence) xmlDeclContent, "encoding", encAttrOffset + 1, false, 4, (Object) null);
                                            if (encAttrOffset > 0) {
                                            }
                                            if (encAttrOffset >= 0) {
                                                int eqPos = encAttrOffset + 8;
                                                if (relaxed) {
                                                    while (eqPos < xmlDeclContent.length() && XmlUtil.isXmlWhitespace(xmlDeclContent.charAt(eqPos))) {
                                                        eqPos++;
                                                    }
                                                }
                                                if (eqPos >= xmlDeclContent.length() || xmlDeclContent.charAt(eqPos) != '=') {
                                                    throw new IllegalStateException("Missing equality character in encoding attribute".toString());
                                                }
                                                int openQuotPos = eqPos + 1;
                                                if (relaxed) {
                                                    while (openQuotPos < xmlDeclContent.length() && XmlUtil.isXmlWhitespace(xmlDeclContent.charAt(openQuotPos))) {
                                                        openQuotPos++;
                                                    }
                                                }
                                                if (openQuotPos >= xmlDeclContent.length()) {
                                                    throw new IllegalStateException("Missing quote for encoding attribute".toString());
                                                }
                                                char delim = xmlDeclContent.charAt(openQuotPos);
                                                switch (delim) {
                                                    case '\"':
                                                    case '\'':
                                                        int endQuotPos = openQuotPos + 1;
                                                        while (endQuotPos < xmlDeclContent.length() && xmlDeclContent.charAt(endQuotPos) != delim) {
                                                            endQuotPos++;
                                                        }
                                                        if (endQuotPos < xmlDeclContent.length()) {
                                                            String substring = xmlDeclContent.substring(openQuotPos + 1, endQuotPos);
                                                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                                            enc = substring;
                                                            break;
                                                        } else {
                                                            throw new IllegalStateException("Missing closing quote in encoding".toString());
                                                        }
                                                        break;
                                                    default:
                                                        throw new IllegalStateException("Missing quote (' or \") for encoding".toString());
                                                }
                                            }
                                        } while (!XmlUtil.isXmlWhitespace(xmlDeclContent.charAt(encAttrOffset - 1)));
                                        if (encAttrOffset >= 0) {
                                        }
                                    } else {
                                        srcBufCount = srcBufCount3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    if (!(e instanceof XmlException)) {
                                    }
                                    if (xmlException == null) {
                                    }
                                    throw xmlException;
                                }
                            }
                        }
                        bufferedInput.reset();
                        break;
                    default:
                        if (UInt.constructor-impl(chk & (-65536)) == -16842752) {
                            bufferedInput.skip(2L);
                            enc = CharEncoding.UTF_16BE;
                            srcBuf[0] = (char) ((srcBuf[2] << '\b') | srcBuf[3]);
                            break;
                        } else if (UInt.constructor-impl((-65536) & chk) == -131072) {
                            bufferedInput.skip(2L);
                            enc = CharEncoding.UTF_16LE;
                            srcBuf[0] = (char) ((srcBuf[3] << '\b') | srcBuf[2]);
                            break;
                        } else if (UInt.constructor-impl(chk & (-256)) == -272908544) {
                            bufferedInput.skip(3L);
                            enc = "UTF-8";
                            srcBuf[0] = srcBuf[3];
                            break;
                        }
                        break;
                }
            }
        }
        if (enc == null) {
            enc = "UTF-8";
        }
        return new KtXmlReader(new InputStreamReader(bufferedInput, enc), enc, relaxed);
    }
}