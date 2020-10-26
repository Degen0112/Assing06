import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Counter {

    File nF;
    int countL = 0;

    public Counter(File nF) {

        this.nF = nF;

    }

    public int traverseF() throws IOException {

        List<String> searchF = Files.readAllLines(Path.of(String.valueOf(this.nF)));

        for (int m = 0; m < searchF.size(); m++) {

            if (searchF.get(m).trim().length() > 0) {

                for (int i = 0; i < searchF.get(m).length(); i++) {

                    if (searchF.get(m).charAt(i) == '/' && searchF.get(m).charAt(i + 1) == '/') {
                        break;
                    } else if (searchF.get(m).charAt(i) == '/' && searchF.get(m).charAt(i + 1) == '*') {
                        break;
                    } else if (searchF.get(m).charAt(i) == '*' && searchF.get(m).charAt(i + 1) != '/') {

                        boolean chck = quickS(searchF.get(m + 1));
                        if (!chck) {
                            countL++;
                        }
                        break;

                    } else if (searchF.get(m).charAt(i) == '*' && (searchF.get(m).charAt(i + 1) == '/')) {
                        break;
                    } else if (i == searchF.get(m).length() - 1) {
                        countL++;
                    }

                }
            }
        }

        return countL;

    }

    private boolean quickS(String s) {

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '*') {
                return true;
            }

        }

        return false;

    }


}
