public class MathOper {
    private ConverRomToArab converRomToArab = new ConverRomToArab();
    private  ConvertArabToRom convertArabToRom = new ConvertArabToRom();

    public String addition (String a, String b) {
        Integer c = 0;
        if (isArabic(a) && isArabic(b)) {
            c = Integer.parseInt(a) + Integer.parseInt(b);
            return c.toString();
        } else {
            c = converRomToArab.convert(a) + converRomToArab.convert(b);
            return convertArabToRom.convert(c);
        }
    }

    public String subtraction (String a, String b) throws Exception {
        Integer c = 0;
        if (isArabic(a) && isArabic(b)) {
            c = Integer.parseInt(a) - Integer.parseInt(b);
            return c.toString();
        } else {
            c = converRomToArab.convert(a) - converRomToArab.convert(b);
            if (c < 1) {
                throw new Exception();
            }
            return convertArabToRom.convert(c);
        }
    }

    public String division (String a, String b) throws Exception {
        Integer c = 0;
        if (isArabic(a) && isArabic(b)) {
            if (Integer.parseInt(b) == 0) throw new Exception();
            c = Integer.parseInt(a) / Integer.parseInt(b);
            return c.toString();
        } else {
            c = converRomToArab.convert(a) / converRomToArab.convert(b);
            return convertArabToRom.convert(c);
        }
    }

    public String multiplication (String a, String b) {
        Integer c = 0;
        if (isArabic(a) && isArabic(b)) {
            c = Integer.parseInt(a) * Integer.parseInt(b);
            return c.toString();
        } else {
            c = converRomToArab.convert(a) * converRomToArab.convert(b);
            return convertArabToRom.convert(c);
        }
    }

    private boolean isArabic (String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
