package lotto.model;

import java.util.List;

public interface LottoMachine {

    LottoGroup autoGenerate();

    LottoGroup manualGenerate(List<Integer> numbers);
}
