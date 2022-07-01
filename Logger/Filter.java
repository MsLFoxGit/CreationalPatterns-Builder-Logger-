package Netology.СreationalPatterns.Logger;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int treshold) {
        this.threshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        logger.log("Запускаем фильтрацию");
        for (Integer x : source) {
            if (x <= threshold) result.add(x);
            logger.log("Элемент \"" + x + "\"" + (x > threshold ? " не" : "") + " проходит");
        }
        int resultSizeLastNumber = result.size() % 10;
        String elements =
                (resultSizeLastNumber == 0 || resultSizeLastNumber > 4) ? " элементов" :
                        (resultSizeLastNumber == 1) ? " элемент" : " элемента";

        logger.log("Прошло фильтр " + result.size() + elements + " из " + source.size());
        return result;
    }
}
