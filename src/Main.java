void main() {
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
            for(int j = 0; j < list_by_len[i].length - 1; j++){ //сравниваемое слово
                for(int z = j+1; z < list_by_len[i].length; z++){//остальные слова
                    if(check_words(list_by_len[i][j], list_by_len[i][z])){
                        print(list_by_len[i][j]);
                        System.out.print(",");
                        print(list_by_len[i][z]);
                        System.out.print('\n');
                        break;
                    }
                }
            }
        }
    }
}

public static boolean check_words(char[] first, char[] second_orig){
    if(first == null || second_orig == null){
        return false;
    }
    char[] second = new char[second_orig.length];
    for (int i = 0; i < second_orig.length; i++) {
        second[i] = second_orig[i];
    }

    int sovp = 0;
    for (int x = 0; x < first.length; x++){ //каждый символ первого слова
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

public static void print(char[] word){
    for(int i = 0; i < word.length; i++){
        System.out.print(word[i]);
    }
}
