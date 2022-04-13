
public class ConverRomToArab {

    public int convert (String str) {
        int value = 0;
        int nextValue = 0;
        int tempValue = 0;
        int result = 0;

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            value = matching(str.charAt(i));

            if (value < 0) {
                return -1;
            }

            if (i < str.length() - 1) {
                nextValue = matching(str.charAt(i + 1));
            } else {
                nextValue = 0;
            }

            if (nextValue == 0) {
                tempValue = value;
            } else {
                if (value > nextValue) {
                    tempValue = value;
                } else if (value < nextValue) {
                    tempValue = nextValue - value;
                    i++;
                } else if (value == nextValue) {
                    tempValue = value;
                }
            }
            result += tempValue;
        }
        return result;
    }

    private static int matching (char c) {
        switch (c) {
            case 'x':
                return 10;
            case 'v':
                return 5;
            case 'i':
                return 1;
            default:
                return -1;
        }
    }
}
