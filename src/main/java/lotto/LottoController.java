package lotto;

import lotto.dto.GameResultDTO;
import lotto.dto.LottoGroupDTOs;
import lotto.model.LottoGame;
import lotto.model.RandomAutoGenerator;
import lotto.model.WinningGroup;
import lotto.model.WinningStatistics;
import lotto.model.vo.PurchaseCount;
import lotto.model.vo.PurchaseMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoGame lottoGame = new LottoGame(new RandomAutoGenerator());

    public void run() {
        final PurchaseCount purchaseCount = makePurchaseCount();
        final List<String> manualLottoInputs = readManualLottoInputs();

        buyLottos(manualLottoInputs, purchaseCount);

        final WinningGroup winningGroup = makeWinningGroup();
        executeResult(winningGroup);
    }

    private List<String> readManualLottoInputs() {
        final int manualLottoCount = InputView.readManualLottoCount();
        if (manualLottoCount == 0) {
            return List.of();
        }
        return InputView.readManualLottoInputs(manualLottoCount);
    }

    private void buyLottos(List<String> customLottoInputs, PurchaseCount purchaseCount) {
        lottoGame.addManualLottos(customLottoInputs);
        lottoGame.runAutoLottos(purchaseCount.getCount() - customLottoInputs.size());

        OutputView.printLottoGroups(
                customLottoInputs.size(),
                purchaseCount.getCount() - customLottoInputs.size(),
                new LottoGroupDTOs(lottoGame.getLottoGroups()));
    }

    private PurchaseCount makePurchaseCount() {
        final int purchaseMoneyInput = InputView.readPurchaseMoney();
        return new PurchaseMoney(purchaseMoneyInput).toPurchaseCount();
    }

    private WinningGroup makeWinningGroup() {
        final String winningGroupInput = InputView.readWinningGroup();
        final int bonusBallInput = InputView.readBonusBall();
        return new WinningGroup(winningGroupInput, bonusBallInput);
    }

    private void executeResult(final WinningGroup winningGroup) {
        final WinningStatistics winningStatistics = lottoGame.makeResult(winningGroup);
        final GameResultDTO gameResultDTO = new GameResultDTO(winningStatistics.getStatistics(), winningStatistics.calculateRevenueRate().getValue());
        OutputView.printGameResult(gameResultDTO);
    }
}
