class run_code {
    public static void main(String[] args) {
        char[][] dictionary = {
                {'а','р','ф','а'},
                {'ф', 'о', 'н', 'а', 'р','ь'},
                {'ф', 'а', 'р', 'а'},
                {'т','ё','р','к','а'},
                {'а','к','т','ё','р'},
                {'з', 'м', 'е', 'я'},
                {'к', 'о', 'т'},
                {'р', 'о', 'з', 'а'},
                {'г','л','и','н','а'}
        };
        char[][][] list_by_len = new char[7][dictionary.length][];
        for(int i = 0;  i < dictionary.length;  i++) {
            for (int j = 0; j < dictionary.length; j++) {
                if(list_by_len[dictionary[i].length][j] == null) {
                    list_by_len[dictionary[i].length][j] = dictionary[i];
                    break;
                }
            }
        }
        check_correct(list_by_len);
    }

    public static void check_correct(char[][][] list_by_len){
        for(int i = 2; i < list_by_len.length; i++){
            if(list_by_len[i][0] != null && list_by_len[i][1] != null){
                char[][] res_line = check_line(list_by_len[i]);
                for(int j=0;j <res_line.length; j++){
                    if (res_line[j] != null) {
                        print(res_line[j]);
                        System.out.print(",");
                    }
                }
                System.out.print('\n');
            }
        }
    }


    public static char[][] check_line(char[][] line) {
        char[][] res_line = new char[line.length][];
        for (int j = 0; j < line.length - 1; j++) { //сравниваемое слово
            for (int z = j + 1; z < line.length; z++) {//остальные слова
                if (check_words(line[j], line[z])) {
                    res_line[j] = line[j];
                    res_line[z] = line[z];
                    break;
                }
            }
        }
        return res_line;
    }
    public static boolean check_words ( char[] first, char[] second_orig){
        if (first == null || second_orig == null) {
            return false;
        }
        char[] second = new char[second_orig.length];
        for (int i = 0; i < second_orig.length; i++) {
            second[i] = second_orig[i];
        }

        int sovp = 0;
        for (int x = 0; x < first.length; x++) { //каждый символ первого слова
            for (int c = 0; c < second.length; c++) {//каждый символ второго слова
                if (first[x] == second[c]) {
                    second[c] = ' ';
                    sovp++;
                    break;
                }
            }
        }
        return sovp == first.length;
    }

    public static void print ( char[] word){
        if(word != null) {
            for (int i = 0; i < word.length; i++) {
                System.out.print(word[i]);
            }
        }
    }
}
