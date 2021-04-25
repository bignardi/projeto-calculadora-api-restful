package com.vbt.projetocalculadora.domain.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

// RepresentationModel pertence ao Hateoas
@JsonPropertyOrder({"id", "author", "title", "price", "launch_date"})
public class BookV1 extends RepresentationModel<BookV1> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String author;
    private Instant launch_date;
    private Double price;
    private String title;

    public BookV1() {
    }

    public BookV1(Long key, String author, Instant launch_date, Double price, String title) {
        this.key = key;
        this.author = author;
        this.launch_date = launch_date;
        this.price = price;
        this.title = title;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Instant getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(Instant launch_date) {
        this.launch_date = launch_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookV1 bookV1 = (BookV1) o;
        return Objects.equals(key, bookV1.key)
                && Objects.equals(author, bookV1.author)
                && Objects.equals(launch_date, bookV1.launch_date)
                && Objects.equals(price, bookV1.price)
                && Objects.equals(title, bookV1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, author, launch_date, price, title);
    }

}
