/**
 * We need to define a separator that we can uniquely identify again in the encoded string.
 * Idea: whenever we see the separator in the original string, we escape it.
 * This way the separator only ever occurs unescaped, if it is the real separator.
 * While decoding we then need to remove any escapings.
 */
public class EncodeDecode {
    
    private static final char DELIMETER = ';';
    private static final char ESCAPE = '/';

    public String encode(List<String> strings) {
        var sb = new StringBuilder();
        for (var str : strings) {
            sb.append(str.replaceAll(DELIMETER, ESCAPE + DELIMETER));
            sb.append(DELIMETER);
        }
        return sb.toString();
    }
    
    public List<String> decode(String str) {
        int i = 0;
        var strings = new LinkedList<String>();
        // "/;abc;def;"
        while (i < str.length()) {
            int j = 0;
            while (j < str.length()) {
                if (str.charAt(j) == ';' && str.charAt(j-1) != ESCAPE) {
                    strings.add(str.substring(i, j));
                    break;
                }
                j++;
            }
            var length = j - i;
            i += (length + 1);
        }
        return strings.stream()
            .map(str -> str.replaceAll(ESCAPE + DELIMETER, DELIMETER))
            .collect(Collectors.toList());
    }
}
