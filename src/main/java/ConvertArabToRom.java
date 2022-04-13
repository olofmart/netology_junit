
public class ConvertArabToRom {
    public String convert (int number) {
        int[] arabValueList = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanValueList = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arabValueList.length; i++) {
            while (number >= arabValueList[i]){
                number -= arabValueList[i];
                result.append(romanValueList[i]);
            }
        }
        return result.toString();
    }
}
