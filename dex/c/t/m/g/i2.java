package c.t.m.g;

import c.t.m.g.k2;

/* compiled from: TML */
public class i2 implements k2 {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f40c;
    public String d;
    public long e;
    public String f;
    public String g;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k2.a.values().length];
            a = iArr;
            try {
                iArr[k2.a.CORELOG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[k2.a.PRELOCREQ.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[k2.a.FORMALLOCREQ.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[k2.a.MONTIOR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[k2.a.CORSSDK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public i2(k2.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
                this.a = g3.b;
                this.b = "loc_comm_rsa_pub_key_ver";
                this.f40c = "loc_comm_rsa_pub_key_64";
                this.d = "loc_comm_rsa_key_update_time";
                this.e = 5000L;
                this.f = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMi0gKCzapHg05OXTOlWf9sT20tJJ8C+h41HJZI+nGU2h4sdirRTUB7wdwRR1w604QZJmn55p4S9xBRVCZWIXX2kWmekr90vvvpQow55PYk1JyGXKz7a+yzQxmyEIsD4mtw+M7G76YQrgrjD42EcGH453xTUTdJGwjrn/eCJng6QIDAQAB";
                this.g = "0000";
                return;
            case 2:
                this.a = g3.h;
                this.b = "t_req_pre_pub_key_ver";
                this.f40c = "t_req_pre_pub_key_64";
                this.d = "t_req_pre_key_update_time";
                this.e = 5000L;
                this.f = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDN3nnu9opv0d0vBC1S+imIfivpw0Hyntv05y7dr/JnSTcawxYiebZk/BR1alSopjI4kTpNcPo4GbZAGpMy+OUfPrpJIEUxk22x0suMLZ8l5vkLpwiAU91gEYZrRyNQsmZEN7ORtapFlhfrpxSBfbx/s1D7rTd5BbRMPXLdxL0FWQIDAQAB";
                this.g = "0000";
                return;
            case 3:
                this.a = g3.f;
                this.b = "t_req_formal_pub_key_ver";
                this.f40c = "t_req_formal_pub_key_64";
                this.d = "t_req_formal_key_update_time";
                this.e = 5000L;
                this.f = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDN3nnu9opv0d0vBC1S+imIfivpw0Hyntv05y7dr/JnSTcawxYiebZk/BR1alSopjI4kTpNcPo4GbZAGpMy+OUfPrpJIEUxk22x0suMLZ8l5vkLpwiAU91gEYZrRyNQsmZEN7ORtapFlhfrpxSBfbx/s1D7rTd5BbRMPXLdxL0FWQIDAQAB";
                this.g = "0000";
                return;
            case 4:
                this.a = g3.i;
                this.b = "t_mointor_pub_key_ver";
                this.f40c = "t_mointor_pub_key_64";
                this.d = "t_mointer_key_update_time";
                this.e = 5000L;
                this.f = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDLCSnM2rZ/Zm/LnTTdDaMkxg7xjTJmn09Dl1Sf0z9l4CrGCsuC5y+6ByK6pYMGB8ia80WlJpvNP8qSgY+EkaZ5axhn+H6YEUua1T0ZR4CYcUKJIXyLypszLJJ3kHur9T0gU4HRctaAqOaTC9xKvT/3BUZBUNVXQk/CY7L8nCtJ4wIDAQAB";
                this.g = "0000";
                return;
            case 5:
                this.a = g3.j;
                this.b = "t_corsRsa_pub_key_ver";
                this.f40c = "t_corsRsa_pub_key_64";
                this.d = "t_corsRsa_key_update_time";
                this.e = 5000L;
                this.f = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDrriJ+Bf2olQS5xhU+Uouzyi4dawVe8QJ0w82DlHr/wk1pqMbQEu3O70yd3A/cBSukhuL9r5u3rUL/zmT7N5l70nxy2gyMyIyyd6efx8HtUmuxFukkFfMHTVdnC4tdT+AwayUIxyPxY91GQJ/u1t8bvFDqNyxiX+Puiud2tzOy7QIDAQAB";
                this.g = "0000";
                return;
            default:
                return;
        }
    }

    @Override // c.t.m.g.k2
    public String a() {
        return this.a;
    }

    @Override // c.t.m.g.k2
    public String b() {
        return this.b;
    }

    @Override // c.t.m.g.k2
    public String c() {
        return this.f40c;
    }

    @Override // c.t.m.g.k2
    public String d() {
        return this.d;
    }

    @Override // c.t.m.g.k2
    public String e() {
        return this.f;
    }

    @Override // c.t.m.g.k2
    public long f() {
        return this.e;
    }

    @Override // c.t.m.g.k2
    public String g() {
        return this.g;
    }

    public String toString() {
        return "CommEncryptConfig{urlUpdateRsaPublicKey='" + this.a + "', SP_KEY_VERSION='" + this.b + "', SP_KEY_BASE64='" + this.f40c + "', SP_KEY_UPDATE_TIME='" + this.d + "', requestPubKeyDelayTime=" + this.e + ", defaultPublicKey='" + this.f + "', defaultPublicKeyVersion='" + this.g + "'}";
    }
}