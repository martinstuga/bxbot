/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.bxbot.core.api.strategy;

import com.gazbert.bxbot.core.api.trading.Market;
import com.gazbert.bxbot.core.api.trading.TradingApi;

/**
 * <p>
 * All user defined Trading Strategies must implement this interface.
 * </p>
 * <p/>
 * <p>
 * The Trading Engine will send only 1 thread through your strategy code at a time - you do not have to code for concurrency.
 * </p>
 *
 * @author gazbert
 */
public interface TradingStrategy {

    /**
     * Called once by the Trading Engine when it starts up.
     *
     * @param tradingApi the Trading API.
     * @param market     the market for this strategy.
     * @param config     optional configuration for the strategy.
     */
    void init(TradingApi tradingApi, Market market, StrategyConfig config);

    /**
     * <p>
     * Called by the Trading Engine during each trade cycle.
     * </p>
     * <p/>
     * <p>
     * Here, you can make some trades, cancel some, go for a beer... do whatever you want.
     * </p>
     *
     * @throws StrategyException if something goes bad. Trading Strategy implementations should throw this exception
     *                           if they want the Trading Engine to shutdown the bot immediately.
     */
    void execute() throws StrategyException;
}
