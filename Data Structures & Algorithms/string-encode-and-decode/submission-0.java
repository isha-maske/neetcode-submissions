class Solution {

    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {

            encoded.append(str.length());
            encoded.append('#');
            encoded.append(str);

        }

        return encoded.toString();
    }

    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            int j = i;

            while (s.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(s.substring(i, j));
            j++;
            result.add(s.substring(j, j + length));
            i = j + length;
        }

        return result;
    }
}

