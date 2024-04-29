package Lab_3.demo.controllers;

import Lab_3.demo.models.*;
import Lab_3.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Main_Controller {
    @Autowired
    private Coin_Repository coin_repository;
    @Autowired
    private Exchange_Repository exchange_repository;
    @Autowired
    private Deal_Repository deal_repository;
    @Autowired
    private Portfolio_Repository portfolio_repository;
    @Autowired
    private Trend_Repository trend_repository;

    @GetMapping("/api/coins")
    @ResponseBody
    public Iterable<Coin> GET_Coins() {
        Iterable<Coin> coins = coin_repository.findAll();
        return coins;
    }
    @PostMapping("/api/coin/add")
    @ResponseBody
    public Coin ADD_Coin(@RequestBody Coin coin) {
        coin_repository.save(coin);
        return coin;
    }

    @GetMapping("/api/exchanges")
    @ResponseBody
    public Iterable<Exchange> GET_Exchanges() {
        Iterable<Exchange> exchanges = exchange_repository.findAll();
        return exchanges;
    }
    @PostMapping("/api/exchange/add")
    @ResponseBody
    public Exchange ADD_Exchange(@RequestBody Exchange exchange) {
        exchange_repository.save(exchange);
        return exchange;
    }

    @GetMapping("/api/portfolio/{id}")
    @ResponseBody
    public Portfolio GET_Portfolio(@PathVariable Long id) {
        return portfolio_repository.findById(id).orElse(null);
    }
    @PostMapping("/api/portfolio/add")
    @ResponseBody
    public Portfolio ADD_Portfolio(@RequestBody Portfolio portfolio){
        portfolio_repository.save(portfolio);
        return portfolio;
    }

    @GetMapping("/api/trends")
    @ResponseBody
    public Iterable<Trend> GET_Trends() {
        Iterable<Trend> trends = trend_repository.findAll();
        return trends;
    }
    @PostMapping("/api/trend/add")
    @ResponseBody
    public Trend ADD_Trend(@RequestBody Coin COIN) {
        Coin coin = coin_repository.findById(COIN.getId()).orElse(null);
        if (coin != null) {
            Trend trend = new Trend(coin.getCoin_name(), coin.getCoin_code(), coin.getH24());
            trend_repository.save(trend);
            return trend;
        } else {
            return null;
        }
    }

    @PostMapping("/api/portfolio/{id}/add-deal")
    @ResponseBody
    public Deal ADD_Deal(@PathVariable Long id, @RequestBody Deal DEAL) {
        Portfolio portfolio = portfolio_repository.findById(id).orElse(null);
        if (portfolio != null) {
            portfolio.getDeals().add(DEAL);
            deal_repository.save(DEAL);
            portfolio_repository.save(portfolio);
            return DEAL;
        } else {
            return null;
        }
    }
    @PostMapping("/api/portfolio/{id}/add-coin")
    @ResponseBody
    public Coin ADD_Coin(@PathVariable Long id, @RequestBody Coin COIN) {
        Portfolio portfolio = portfolio_repository.findById(id).orElse(null);
        if (portfolio != null) {
            Coin coin = coin_repository.findById(COIN.getId()).orElse(null);
            if (coin != null) {
                portfolio.getCoins().add(coin);
                portfolio_repository.save(portfolio);
                return coin;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}