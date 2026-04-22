package facadeverify;

import external.org.apache.commons.lang3.CharUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class n0 {
    public int a;
    public Reader b;
    public char c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1916d;

    public n0(String str) {
        Reader stringReader = new StringReader(str);
        this.b = stringReader.markSupported() ? stringReader : new BufferedReader(stringReader);
        this.f1916d = false;
        this.a = 0;
    }

    public void a() {
        int i2;
        if (!this.f1916d && (i2 = this.a) > 0) {
            this.a = i2 - 1;
            this.f1916d = true;
            return;
        }
        throw new l0("Stepping back two steps is not supported");
    }

    public char b() {
        if (this.f1916d) {
            this.f1916d = false;
            if (this.c != 0) {
                this.a++;
            }
            return this.c;
        }
        try {
            int read = this.b.read();
            if (read <= 0) {
                this.c = (char) 0;
                return (char) 0;
            }
            this.a++;
            this.c = (char) read;
            return this.c;
        } catch (IOException e2) {
            throw new l0(e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0055, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public char c() {
        char b;
        char b2;
        while (true) {
            char b3 = b();
            if (b3 == '/') {
                char b4 = b();
                if (b4 == '*') {
                    while (true) {
                        char b5 = b();
                        if (b5 == 0) {
                            throw a("Unclosed comment");
                        }
                        if (b5 == '*') {
                            if (b() == '/') {
                                break;
                            }
                            a();
                        }
                    }
                } else if (b4 != '/') {
                    a();
                    return '/';
                } else {
                    do {
                        b = b();
                        if (b != '\n' && b != '\r') {
                        }
                    } while (b != 0);
                }
            } else if (b3 == '#') {
                do {
                    b2 = b();
                    if (b2 != '\n' && b2 != '\r') {
                    }
                } while (b2 != 0);
            } else if (b3 == 0 || b3 > ' ') {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x016c, code lost:
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object d() {
        char c = c();
        if (c != '\"') {
            if (c != '[') {
                if (c == '{') {
                    a();
                    return new m0(this);
                } else if (c != '\'') {
                    if (c != '(') {
                        StringBuffer stringBuffer = new StringBuffer();
                        char c2 = c;
                        while (c2 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c2) < 0) {
                            stringBuffer.append(c2);
                            c2 = b();
                        }
                        a();
                        String trim = stringBuffer.toString().trim();
                        if (!trim.equals("")) {
                            if (trim.equalsIgnoreCase("true")) {
                                return Boolean.TRUE;
                            }
                            if (trim.equalsIgnoreCase("false")) {
                                return Boolean.FALSE;
                            }
                            if (trim.equalsIgnoreCase("null")) {
                                return m0.b;
                            }
                            if ((c >= '0' && c <= '9') || c == '.' || c == '-' || c == '+') {
                                if (c == '0') {
                                    try {
                                        if (trim.length() > 2 && (trim.charAt(1) == 'x' || trim.charAt(1) == 'X')) {
                                            return new Integer(Integer.parseInt(trim.substring(2), 16));
                                        }
                                        return new Integer(Integer.parseInt(trim, 8));
                                    } catch (Exception e2) {
                                    }
                                }
                                try {
                                    return new Integer(trim);
                                } catch (Exception e3) {
                                    try {
                                        return new Long(trim);
                                    } catch (Exception e4) {
                                        try {
                                            return new Double(trim);
                                        } catch (Exception e5) {
                                            return trim;
                                        }
                                    }
                                }
                            }
                            return trim;
                        }
                        throw a("Missing value");
                    }
                }
            }
            a();
            return new k0(this);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        while (true) {
            char b = b();
            if (b == 0 || b == '\n' || b == '\r') {
                break;
            } else if (b == '\\') {
                char b2 = b();
                if (b2 == 'b') {
                    stringBuffer2.append('\b');
                } else if (b2 == 'f') {
                    stringBuffer2.append('\f');
                } else if (b2 == 'n') {
                    stringBuffer2.append('\n');
                } else if (b2 == 'r') {
                    stringBuffer2.append(CharUtils.CR);
                } else if (b2 == 'x') {
                    stringBuffer2.append((char) Integer.parseInt(a(2), 16));
                } else if (b2 == 't') {
                    stringBuffer2.append('\t');
                } else if (b2 != 'u') {
                    stringBuffer2.append(b2);
                } else {
                    stringBuffer2.append((char) Integer.parseInt(a(4), 16));
                }
            } else if (b == c) {
                return stringBuffer2.toString();
            } else {
                stringBuffer2.append(b);
            }
        }
    }

    public String toString() {
        return a.a(" at character ").append(this.a).toString();
    }

    public String a(int i2) {
        if (i2 == 0) {
            return "";
        }
        char[] cArr = new char[i2];
        int i3 = 0;
        if (this.f1916d) {
            this.f1916d = false;
            cArr[0] = this.c;
            i3 = 1;
        }
        while (i3 < i2) {
            try {
                int read = this.b.read(cArr, i3, i2 - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            } catch (IOException e2) {
                throw new l0(e2);
            }
        }
        this.a += i3;
        if (i3 >= i2) {
            this.c = cArr[i2 - 1];
            return new String(cArr);
        }
        throw a("Substring bounds error");
    }

    public l0 a(String str) {
        return new l0(a.a(str).append(toString()).toString());
    }
}