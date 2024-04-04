package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomAutoGenerator implements AutoGenerator {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int ZERO = 0;
    private static final int LOTTO_BALLS_COUNT = 6;

    private final List<Integer> lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUM, MAX_LOTTO_NUM)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public List<Integer> generate() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(ZERO, LOTTO_BALLS_COUNT);
    }
}
