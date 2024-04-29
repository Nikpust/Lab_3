package Lab_3.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coin_name, coin_code;
    private Float price, h1, h24, d7, market_cap, volume;
    private List<Float> last_price = new ArrayList<>();
    public Coin() {
    }
    public Coin(String coin_name, String coin_code, Float price, Float h1, Float h24, Float d7, Float market_cap, Float volume, List<Float> last_price) {
        this.coin_name = coin_name;
        this.coin_code = coin_code;
        this.price = price;
        this.h1 = h1;
        this.h24 = h24;
        this.d7 = d7;
        this.market_cap = market_cap;
        this.volume = volume;
        this.last_price = last_price;
    }

    // Далее реализация методов для получения и установки значений полей (Getters and Setters)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public String getCoin_code() {
        return coin_code;
    }

    public void setCoin_code(String coin_code) {
        this.coin_code = coin_code;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getH1() {
        return h1;
    }

    public void setH1(Float h1) {
        this.h1 = h1;
    }

    public Float getH24() {
        return h24;
    }

    public void setH24(Float h24) {
        this.h24 = h24;
    }

    public Float getD7() {
        return d7;
    }

    public void setD7(Float d7) {
        this.d7 = d7;
    }

    public Float getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(Float market_cap) {
        this.market_cap = market_cap;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public List<Float> getLast_price() {
        return last_price;
    }

    public void setLast_price(List<Float> last_price) {
        this.last_price = last_price;
    }
}
